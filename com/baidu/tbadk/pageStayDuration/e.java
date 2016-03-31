package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class e {
    private static e aAq = null;
    private boolean aAr = false;
    private int aAs;

    private e() {
    }

    public static e Gr() {
        if (aAq == null) {
            synchronized (e.class) {
                if (aAq == null) {
                    aAq = new e();
                }
            }
        }
        return aAq;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && dVar.Gp() > 0 && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (bVar == null) {
                bVar = new f(this);
            }
            if (bVar.Gn() && bVar.a(dVar)) {
                aw awVar = new aw("stime");
                awVar.ac("obj_source", c.z(dVar.Go()));
                awVar.ac("obj_type", dVar.getCurrentPageKey());
                awVar.ac("obj_duration", String.valueOf(dVar.Gp()));
                if (dVar.getFid() > 0) {
                    awVar.ac("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    awVar.ac("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    awVar.ac(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                TiebaStatic.log(awVar);
            }
        }
    }

    public boolean Gs() {
        return this.aAr;
    }

    public void bJ(boolean z) {
        this.aAr = z;
    }

    public int Gt() {
        return !TbadkCoreApplication.m411getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.vk().getInt("page_stay_max_cost", 0) : this.aAs;
    }

    public void fc(int i) {
        this.aAs = i;
        com.baidu.tbadk.core.sharedPref.b.vk().putInt("page_stay_max_cost", this.aAs);
    }
}
