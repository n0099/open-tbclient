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
    private static e aFA = null;
    private boolean aFB = false;
    private int aFC;

    private e() {
    }

    public static e Ff() {
        if (aFA == null) {
            synchronized (e.class) {
                if (aFA == null) {
                    aFA = new e();
                }
            }
        }
        return aFA;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aFv) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    as asVar = new as("userconvert");
                    asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.z(dVar.Fc()));
                    asVar.aa("obj_locate", dVar.getCurrentPageKey());
                    asVar.aa("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aFz)) {
                        asVar.aa("obj_id", dVar.aFz);
                    }
                    TiebaStatic.log(asVar);
                }
            } else if (dVar.Fd() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Fb() && bVar.a(dVar)) {
                    as asVar2 = new as("stime");
                    asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.z(dVar.Fc()));
                    asVar2.aa("obj_type", dVar.getCurrentPageKey());
                    asVar2.aa("obj_duration", String.valueOf(dVar.Fd()));
                    if (dVar.getFid() > 0) {
                        asVar2.aa("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        asVar2.aa("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        asVar2.aa(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    if (!StringUtils.isNull(dVar.objParam1)) {
                        asVar2.aa("obj_param1", dVar.objParam1);
                    }
                    TiebaStatic.log(asVar2);
                }
            }
        }
    }

    public boolean Fg() {
        return this.aFB;
    }

    public void bX(boolean z) {
        this.aFB = z;
    }

    public int Fh() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.tX().getInt("page_stay_max_cost", 0) : this.aFC;
    }

    public void eW(int i) {
        this.aFC = i;
        com.baidu.tbadk.core.sharedPref.b.tX().putInt("page_stay_max_cost", this.aFC);
    }
}
