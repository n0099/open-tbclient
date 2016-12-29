package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class e {
    private static e aAU = null;
    private boolean aAV = false;
    private int aAW;

    private e() {
    }

    public static e Fp() {
        if (aAU == null) {
            synchronized (e.class) {
                if (aAU == null) {
                    aAU = new e();
                }
            }
        }
        return aAU;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aAP) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    at atVar = new at("userconvert");
                    atVar.ab("obj_source", c.C(dVar.Fm()));
                    atVar.ab("obj_locate", dVar.getCurrentPageKey());
                    atVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aAT)) {
                        atVar.ab("obj_id", dVar.aAT);
                    }
                    TiebaStatic.log(atVar);
                }
            } else if (dVar.Fn() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Fl() && bVar.a(dVar)) {
                    at atVar2 = new at("stime");
                    atVar2.ab("obj_source", c.C(dVar.Fm()));
                    atVar2.ab("obj_type", dVar.getCurrentPageKey());
                    atVar2.ab("obj_duration", String.valueOf(dVar.Fn()));
                    if (dVar.getFid() > 0) {
                        atVar2.ab("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        atVar2.ab("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        atVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(atVar2);
                }
            }
        }
    }

    public boolean Fq() {
        return this.aAV;
    }

    public void bV(boolean z) {
        this.aAV = z;
    }

    public int Fr() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.tW().getInt("page_stay_max_cost", 0) : this.aAW;
    }

    public void fc(int i) {
        this.aAW = i;
        com.baidu.tbadk.core.sharedPref.b.tW().putInt("page_stay_max_cost", this.aAW);
    }
}
