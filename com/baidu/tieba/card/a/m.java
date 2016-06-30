package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class m extends c {
    public boolean aVt = false;
    public boolean aVu = false;
    public boolean arI = true;
    public az threadData;
    public static String aVh = "";
    public static String aVi = "";
    public static String aVj = "";
    public static String aVk = "";
    public static String aVl = "";
    public static String aVm = "";
    public static String aVn = "";
    public static String aVo = "";
    public static String aVp = "";
    public static String aVq = "";
    public static String aVr = "";
    public static final BdUniqueId Op = BdUniqueId.gen();
    public static final BdUniqueId aVs = BdUniqueId.gen();

    public static boolean c(az azVar) {
        if (azVar == null) {
            return false;
        }
        return azVar.getType() == az.TYPE_NORMAL || azVar.getType() == az.Qg;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return Op;
        }
        if (this.aVt) {
            return aVs;
        }
        return Op;
    }

    @Override // com.baidu.tieba.card.a.c
    public az Ix() {
        return this.threadData;
    }

    public boolean Lu() {
        return (this.threadData == null || y.s(this.threadData.qT()) == 0) ? false : true;
    }

    public ay Lv() {
        if (Lu()) {
            return hh(aVm);
        }
        ay hh = hh(aVh);
        if (hh != null) {
            hh.ab("ab_tag", Lj()).ab("ab_action", "show");
            return hh;
        }
        return hh;
    }

    public ay Lw() {
        if (Lu()) {
            return hh(aVn);
        }
        ay hh = hh(aVi);
        if (hh != null) {
            hh.ab("ab_tag", Lj()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Lx() {
        if (Lu()) {
            return hh(aVo);
        }
        ay hh = hh(aVj);
        if (hh != null) {
            hh.ab("ab_tag", Lj()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Ly() {
        if (Lu()) {
            return hh(aVp);
        }
        ay hh = hh(aVk);
        if (hh != null) {
            hh.ab("ab_tag", Lj()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Lz() {
        if (Lu()) {
            return hh(aVq);
        }
        ay hh = hh(aVl);
        if (hh != null) {
            hh.ab("ab_tag", Lj()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay LA() {
        return hh(aVr);
    }
}
