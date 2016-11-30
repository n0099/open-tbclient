package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class e {
    private static e aBA = null;
    private boolean aBB = false;
    private int aBC;

    private e() {
    }

    public static e FP() {
        if (aBA == null) {
            synchronized (e.class) {
                if (aBA == null) {
                    aBA = new e();
                }
            }
        }
        return aBA;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aBv) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    av avVar = new av("userconvert");
                    avVar.ab("obj_source", c.C(dVar.FM()));
                    avVar.ab("obj_locate", dVar.getCurrentPageKey());
                    avVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aBz)) {
                        avVar.ab("obj_id", dVar.aBz);
                    }
                    TiebaStatic.log(avVar);
                }
            } else if (dVar.FN() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.FL() && bVar.a(dVar)) {
                    av avVar2 = new av("stime");
                    avVar2.ab("obj_source", c.C(dVar.FM()));
                    avVar2.ab("obj_type", dVar.getCurrentPageKey());
                    avVar2.ab("obj_duration", String.valueOf(dVar.FN()));
                    if (dVar.getFid() > 0) {
                        avVar2.ab("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        avVar2.ab("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        avVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(avVar2);
                }
            }
        }
    }

    public boolean FQ() {
        return this.aBB;
    }

    public void bW(boolean z) {
        this.aBB = z;
    }

    public int FR() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.um().getInt("page_stay_max_cost", 0) : this.aBC;
    }

    public void fc(int i) {
        this.aBC = i;
        com.baidu.tbadk.core.sharedPref.b.um().putInt("page_stay_max_cost", this.aBC);
    }
}
