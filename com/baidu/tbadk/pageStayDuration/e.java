package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class e {
    private static e axZ = null;
    private boolean aya = false;
    private int ayb;

    private e() {
    }

    public static e Es() {
        if (axZ == null) {
            synchronized (e.class) {
                if (axZ == null) {
                    axZ = new e();
                }
            }
        }
        return axZ;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.axU) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    ay ayVar = new ay("userconvert");
                    ayVar.ab("obj_source", c.C(dVar.Ep()));
                    ayVar.ab("obj_locate", dVar.getCurrentPageKey());
                    ayVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.axY)) {
                        ayVar.ab("obj_id", dVar.axY);
                    }
                    TiebaStatic.log(ayVar);
                }
            } else if (dVar.Eq() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Eo() && bVar.a(dVar)) {
                    ay ayVar2 = new ay("stime");
                    ayVar2.ab("obj_source", c.C(dVar.Ep()));
                    ayVar2.ab("obj_type", dVar.getCurrentPageKey());
                    ayVar2.ab("obj_duration", String.valueOf(dVar.Eq()));
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

    public boolean Et() {
        return this.aya;
    }

    public void bR(boolean z) {
        this.aya = z;
    }

    public int Eu() {
        return !TbadkCoreApplication.m10getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.sN().getInt("page_stay_max_cost", 0) : this.ayb;
    }

    public void eM(int i) {
        this.ayb = i;
        com.baidu.tbadk.core.sharedPref.b.sN().putInt("page_stay_max_cost", this.ayb);
    }
}
