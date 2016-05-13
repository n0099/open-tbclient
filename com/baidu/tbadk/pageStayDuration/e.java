package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class e {
    private static e awt = null;
    private boolean awu = false;
    private int awv;

    private e() {
    }

    public static e Ek() {
        if (awt == null) {
            synchronized (e.class) {
                if (awt == null) {
                    awt = new e();
                }
            }
        }
        return awt;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && dVar.Ei() > 0 && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (bVar == null) {
                bVar = new f(this);
            }
            if (bVar.Eg() && bVar.a(dVar)) {
                aw awVar = new aw("stime");
                awVar.ac("obj_source", c.B(dVar.Eh()));
                awVar.ac("obj_type", dVar.getCurrentPageKey());
                awVar.ac("obj_duration", String.valueOf(dVar.Ei()));
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

    public boolean El() {
        return this.awu;
    }

    public void bP(boolean z) {
        this.awu = z;
    }

    public int Em() {
        return !TbadkCoreApplication.m11getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.sR().getInt("page_stay_max_cost", 0) : this.awv;
    }

    public void eH(int i) {
        this.awv = i;
        com.baidu.tbadk.core.sharedPref.b.sR().putInt("page_stay_max_cost", this.awv);
    }
}
