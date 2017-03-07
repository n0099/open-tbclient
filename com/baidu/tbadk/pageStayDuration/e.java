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
    private static e aFe = null;
    private boolean aFf = false;
    private int aFg;

    private e() {
    }

    public static e FD() {
        if (aFe == null) {
            synchronized (e.class) {
                if (aFe == null) {
                    aFe = new e();
                }
            }
        }
        return aFe;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aEZ) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    as asVar = new as("userconvert");
                    asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.y(dVar.FA()));
                    asVar.Z("obj_locate", dVar.getCurrentPageKey());
                    asVar.Z("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aFd)) {
                        asVar.Z("obj_id", dVar.aFd);
                    }
                    TiebaStatic.log(asVar);
                }
            } else if (dVar.FB() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Fz() && bVar.a(dVar)) {
                    as asVar2 = new as("stime");
                    asVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.y(dVar.FA()));
                    asVar2.Z("obj_type", dVar.getCurrentPageKey());
                    asVar2.Z("obj_duration", String.valueOf(dVar.FB()));
                    if (dVar.getFid() > 0) {
                        asVar2.Z("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        asVar2.Z("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        asVar2.Z(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(asVar2);
                }
            }
        }
    }

    public boolean FE() {
        return this.aFf;
    }

    public void bU(boolean z) {
        this.aFf = z;
    }

    public int FF() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.uo().getInt("page_stay_max_cost", 0) : this.aFg;
    }

    public void eX(int i) {
        this.aFg = i;
        com.baidu.tbadk.core.sharedPref.b.uo().putInt("page_stay_max_cost", this.aFg);
    }
}
