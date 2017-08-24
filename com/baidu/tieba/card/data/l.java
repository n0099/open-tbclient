package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class l extends c {
    public bl threadData;
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
    public static String bKp = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bKq = BdUniqueId.gen();
    public static final BdUniqueId Ze = BdUniqueId.gen();
    public boolean bKr = false;
    public boolean isLinkThread = false;
    public boolean bKs = false;
    public boolean aDw = true;

    public static boolean B(bl blVar) {
        if (blVar == null) {
            return false;
        }
        return blVar.getType() == bl.Zd || blVar.getType() == bl.Zf || blVar.getType() == bl.Ze;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bKr) {
            return bKq;
        }
        if (this.isLinkThread) {
            return Ze;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.threadData;
    }

    public boolean Xg() {
        return (this.threadData == null || u.u(this.threadData.rU()) == 0) ? false : true;
    }

    public aj Xh() {
        if (Xg()) {
            aj jn = jn(bKk);
            if (jn != null && MF() != null) {
                bl MF = MF();
                jn.r("obj_name", MF.sV() != null && (MF.sV().aBr() != null || MF.sV().Iv() != null) ? 1 : 0);
            }
            return jn;
        }
        aj jn2 = jn(bKf);
        if (jn2 != null) {
            jn2.aa("ab_tag", Xa()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF2 = MF();
                jn2.r("obj_name", MF2.sV() != null && (MF2.sV().aBr() != null || MF2.sV().Iv() != null) ? 1 : 0);
            }
        }
        return jn2;
    }

    public aj jo(String str) {
        aj jn = jn(str);
        if (jn != null) {
            jn.g("fid", this.threadData.getFid());
            jn.aa("tid", this.threadData.getTid());
            jn.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return jn;
    }

    public aj jp(String str) {
        aj jn = jn(str);
        if (jn != null) {
            jn.aa("ab_tag", Xa()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF = MF();
                jn.r("obj_name", MF.sV() != null && (MF.sV().aBr() != null || MF.sV().Iv() != null) ? 1 : 0);
            }
        }
        return jn;
    }

    public aj jq(String str) {
        aj jn = jn(str);
        if (jn != null) {
            jn.aa("ab_tag", Xa()).aa("ab_action", "click");
        }
        return jn;
    }

    public aj Xi() {
        if (Xg()) {
            return jn(bKl);
        }
        aj jn = jn(bKg);
        if (jn != null) {
            jn.aa("ab_tag", Xa()).aa("ab_action", "click");
            return jn;
        }
        return jn;
    }

    public aj Xj() {
        if (Xg()) {
            return jn(bKm);
        }
        aj J = J(bKh, 0);
        if (J != null) {
            J.aa("ab_tag", Xa()).aa("ab_action", "click");
            return J;
        }
        return J;
    }

    public aj Xk() {
        if (Xg()) {
            return jn(bKn);
        }
        aj jn = jn(bKi);
        if (jn != null) {
            jn.aa("ab_tag", Xa()).aa("ab_action", "click");
            return jn;
        }
        return jn;
    }

    public aj Xl() {
        if (Xg()) {
            return jn(bKo);
        }
        aj jn = jn(bKj);
        if (jn != null) {
            jn.aa("ab_tag", Xa()).aa("ab_action", "click");
            return jn;
        }
        return jn;
    }

    public aj Xm() {
        return jn(bKp);
    }

    public aj jr(String str) {
        return jn(str);
    }
}
