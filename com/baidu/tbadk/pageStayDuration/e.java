package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class e {
    private static e azM = null;
    private boolean azN = false;
    private int azO;

    private e() {
    }

    public static e Fj() {
        if (azM == null) {
            synchronized (e.class) {
                if (azM == null) {
                    azM = new e();
                }
            }
        }
        return azM;
    }

    public void a(Context context, d dVar) {
        a(context, dVar, null);
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.azH) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    ar arVar = new ar("userconvert");
                    arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.A(dVar.Fg()));
                    arVar.ab("obj_locate", dVar.getCurrentPageKey());
                    arVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.azL)) {
                        arVar.ab("obj_id", dVar.azL);
                    }
                    TiebaStatic.log(arVar);
                }
            } else if (dVar.Fh() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Ff() && bVar.a(dVar)) {
                    ar arVar2 = new ar("stime");
                    arVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.A(dVar.Fg()));
                    arVar2.ab("obj_type", dVar.getCurrentPageKey());
                    arVar2.ab("obj_duration", String.valueOf(dVar.Fh()));
                    if (dVar.getFid() > 0) {
                        arVar2.ab("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        arVar2.ab("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        arVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public boolean Fk() {
        return this.azN;
    }

    public void bV(boolean z) {
        this.azN = z;
    }

    public int Fl() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.tQ().getInt("page_stay_max_cost", 0) : this.azO;
    }

    public void fd(int i) {
        this.azO = i;
        com.baidu.tbadk.core.sharedPref.b.tQ().putInt("page_stay_max_cost", this.azO);
    }
}
