package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class e {
    private static e aFn = null;
    private boolean aFo = false;
    private int aFp;

    private e() {
    }

    public static e EZ() {
        if (aFn == null) {
            synchronized (e.class) {
                if (aFn == null) {
                    aFn = new e();
                }
            }
        }
        return aFn;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aFi) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    as asVar = new as("userconvert");
                    asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.z(dVar.EW()));
                    asVar.Z("obj_locate", dVar.getCurrentPageKey());
                    asVar.Z("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aFm)) {
                        asVar.Z("obj_id", dVar.aFm);
                    }
                    TiebaStatic.log(asVar);
                }
            } else if (dVar.EX() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.EV() && bVar.a(dVar)) {
                    as asVar2 = new as("stime");
                    asVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.z(dVar.EW()));
                    asVar2.Z("obj_type", dVar.getCurrentPageKey());
                    asVar2.Z("obj_duration", String.valueOf(dVar.EX()));
                    if (dVar.getFid() > 0) {
                        asVar2.Z("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        asVar2.Z("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        asVar2.Z(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    if (!StringUtils.isNull(dVar.objParam1)) {
                        asVar2.Z("obj_param1", dVar.objParam1);
                    }
                    TiebaStatic.log(asVar2);
                }
            }
        }
    }

    public boolean Fa() {
        return this.aFo;
    }

    public void bU(boolean z) {
        this.aFo = z;
    }

    public int Fb() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aFp;
    }

    public void eX(int i) {
        this.aFp = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aFp);
    }
}
