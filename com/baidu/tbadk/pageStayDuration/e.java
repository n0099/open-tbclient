package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class e {
    private static e aBg = null;
    private boolean aBh = false;
    private int aBi;

    private e() {
    }

    public static e FM() {
        if (aBg == null) {
            synchronized (e.class) {
                if (aBg == null) {
                    aBg = new e();
                }
            }
        }
        return aBg;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aBb) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    ay ayVar = new ay("userconvert");
                    ayVar.ab("obj_source", c.C(dVar.FJ()));
                    ayVar.ab("obj_locate", dVar.getCurrentPageKey());
                    ayVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aBf)) {
                        ayVar.ab("obj_id", dVar.aBf);
                    }
                    TiebaStatic.log(ayVar);
                }
            } else if (dVar.FK() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.FI() && bVar.a(dVar)) {
                    ay ayVar2 = new ay("stime");
                    ayVar2.ab("obj_source", c.C(dVar.FJ()));
                    ayVar2.ab("obj_type", dVar.getCurrentPageKey());
                    ayVar2.ab("obj_duration", String.valueOf(dVar.FK()));
                    if (dVar.getFid() > 0) {
                        ayVar2.ab("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        ayVar2.ab("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        ayVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(ayVar2);
                }
            }
        }
    }

    public boolean FN() {
        return this.aBh;
    }

    public void bT(boolean z) {
        this.aBh = z;
    }

    public int FO() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.tS().getInt("page_stay_max_cost", 0) : this.aBi;
    }

    public void fa(int i) {
        this.aBi = i;
        com.baidu.tbadk.core.sharedPref.b.tS().putInt("page_stay_max_cost", this.aBi);
    }
}
