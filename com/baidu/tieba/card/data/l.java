package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class l extends c {
    public bl threadData;
    public static String bKe = "";
    public static String bKf = "";
    public static String bKg = "";
    public static String bKh = "";
    public static String bKi = "";
    public static String bKj = "";
    public static String bKk = "";
    public static String bKl = "";
    public static String bKm = "";
    public static String bKn = "";
    public static String bKo = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bKp = BdUniqueId.gen();
    public static final BdUniqueId Zd = BdUniqueId.gen();
    public boolean bKq = false;
    public boolean isLinkThread = false;
    public boolean bKr = false;
    public boolean aDv = true;

    public static boolean B(bl blVar) {
        if (blVar == null) {
            return false;
        }
        return blVar.getType() == bl.Zc || blVar.getType() == bl.Ze || blVar.getType() == bl.Zd;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bKq) {
            return bKp;
        }
        if (this.isLinkThread) {
            return Zd;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.threadData;
    }

    public boolean Xj() {
        return (this.threadData == null || u.u(this.threadData.rT()) == 0) ? false : true;
    }

    public aj Xk() {
        if (Xj()) {
            aj jk = jk(bKj);
            if (jk != null && MF() != null) {
                bl MF = MF();
                jk.r("obj_name", MF.sU() != null && (MF.sU().aBw() != null || MF.sU().Iv() != null) ? 1 : 0);
            }
            return jk;
        }
        aj jk2 = jk(bKe);
        if (jk2 != null) {
            jk2.aa("ab_tag", Xd()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF2 = MF();
                jk2.r("obj_name", MF2.sU() != null && (MF2.sU().aBw() != null || MF2.sU().Iv() != null) ? 1 : 0);
            }
        }
        return jk2;
    }

    public aj jl(String str) {
        aj jk = jk(str);
        if (jk != null) {
            jk.g("fid", this.threadData.getFid());
            jk.aa("tid", this.threadData.getTid());
            jk.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return jk;
    }

    public aj jm(String str) {
        aj jk = jk(str);
        if (jk != null) {
            jk.aa("ab_tag", Xd()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF = MF();
                jk.r("obj_name", MF.sU() != null && (MF.sU().aBw() != null || MF.sU().Iv() != null) ? 1 : 0);
            }
        }
        return jk;
    }

    public aj jn(String str) {
        aj jk = jk(str);
        if (jk != null) {
            jk.aa("ab_tag", Xd()).aa("ab_action", "click");
        }
        return jk;
    }

    public aj Xl() {
        if (Xj()) {
            return jk(bKk);
        }
        aj jk = jk(bKf);
        if (jk != null) {
            jk.aa("ab_tag", Xd()).aa("ab_action", "click");
            return jk;
        }
        return jk;
    }

    public aj Xm() {
        if (Xj()) {
            return jk(bKl);
        }
        aj J = J(bKg, 0);
        if (J != null) {
            J.aa("ab_tag", Xd()).aa("ab_action", "click");
            return J;
        }
        return J;
    }

    public aj Xn() {
        if (Xj()) {
            return jk(bKm);
        }
        aj jk = jk(bKh);
        if (jk != null) {
            jk.aa("ab_tag", Xd()).aa("ab_action", "click");
            return jk;
        }
        return jk;
    }

    public aj Xo() {
        if (Xj()) {
            return jk(bKn);
        }
        aj jk = jk(bKi);
        if (jk != null) {
            jk.aa("ab_tag", Xd()).aa("ab_action", "click");
            return jk;
        }
        return jk;
    }

    public aj Xp() {
        return jk(bKo);
    }

    public aj jo(String str) {
        return jk(str);
    }
}
