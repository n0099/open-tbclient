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
    private static e aFw = null;
    private boolean aFx = false;
    private int aFy;

    private e() {
    }

    public static e Gb() {
        if (aFw == null) {
            synchronized (e.class) {
                if (aFw == null) {
                    aFw = new e();
                }
            }
        }
        return aFw;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aFr) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    as asVar = new as("userconvert");
                    asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.y(dVar.FY()));
                    asVar.aa("obj_locate", dVar.getCurrentPageKey());
                    asVar.aa("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aFv)) {
                        asVar.aa("obj_id", dVar.aFv);
                    }
                    TiebaStatic.log(asVar);
                }
            } else if (dVar.FZ() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.FX() && bVar.a(dVar)) {
                    as asVar2 = new as("stime");
                    asVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.y(dVar.FY()));
                    asVar2.aa("obj_type", dVar.getCurrentPageKey());
                    asVar2.aa("obj_duration", String.valueOf(dVar.FZ()));
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

    public boolean Gc() {
        return this.aFx;
    }

    public void bW(boolean z) {
        this.aFx = z;
    }

    public int Gd() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.uL().getInt("page_stay_max_cost", 0) : this.aFy;
    }

    public void fa(int i) {
        this.aFy = i;
        com.baidu.tbadk.core.sharedPref.b.uL().putInt("page_stay_max_cost", this.aFy);
    }
}
