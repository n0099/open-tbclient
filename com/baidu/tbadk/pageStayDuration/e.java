package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class e {
    private static e aAJ = null;
    private boolean aAK = false;
    private int aAL;

    private e() {
    }

    public static e FL() {
        if (aAJ == null) {
            synchronized (e.class) {
                if (aAJ == null) {
                    aAJ = new e();
                }
            }
        }
        return aAJ;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aAE) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    ax axVar = new ax("userconvert");
                    axVar.ab("obj_source", c.C(dVar.FI()));
                    axVar.ab("obj_locate", dVar.getCurrentPageKey());
                    axVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aAI)) {
                        axVar.ab("obj_id", dVar.aAI);
                    }
                    TiebaStatic.log(axVar);
                }
            } else if (dVar.FJ() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.FH() && bVar.a(dVar)) {
                    ax axVar2 = new ax("stime");
                    axVar2.ab("obj_source", c.C(dVar.FI()));
                    axVar2.ab("obj_type", dVar.getCurrentPageKey());
                    axVar2.ab("obj_duration", String.valueOf(dVar.FJ()));
                    if (dVar.getFid() > 0) {
                        axVar2.ab("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        axVar2.ab("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        axVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(axVar2);
                }
            }
        }
    }

    public boolean FM() {
        return this.aAK;
    }

    public void bS(boolean z) {
        this.aAK = z;
    }

    public int FN() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.uh().getInt("page_stay_max_cost", 0) : this.aAL;
    }

    public void eZ(int i) {
        this.aAL = i;
        com.baidu.tbadk.core.sharedPref.b.uh().putInt("page_stay_max_cost", this.aAL);
    }
}
