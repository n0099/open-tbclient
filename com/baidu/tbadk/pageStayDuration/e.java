package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class e {
    private static e axj = null;
    private boolean axk = false;
    private int axl;

    private e() {
    }

    public static e Et() {
        if (axj == null) {
            synchronized (e.class) {
                if (axj == null) {
                    axj = new e();
                }
            }
        }
        return axj;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && dVar.Er() > 0 && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (bVar == null) {
                bVar = new f(this);
            }
            if (bVar.Ep() && bVar.a(dVar)) {
                ay ayVar = new ay("stime");
                ayVar.ab("obj_source", c.C(dVar.Eq()));
                ayVar.ab("obj_type", dVar.getCurrentPageKey());
                ayVar.ab("obj_duration", String.valueOf(dVar.Er()));
                if (dVar.getFid() > 0) {
                    ayVar.ab("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    ayVar.ab("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    ayVar.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                TiebaStatic.log(ayVar);
            }
        }
    }

    public boolean Eu() {
        return this.axk;
    }

    public void bO(boolean z) {
        this.axk = z;
    }

    public int Ev() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.sO().getInt("page_stay_max_cost", 0) : this.axl;
    }

    public void eM(int i) {
        this.axl = i;
        com.baidu.tbadk.core.sharedPref.b.sO().putInt("page_stay_max_cost", this.axl);
    }
}
