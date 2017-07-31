package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class l extends c {
    public bl threadData;
    public static String bJv = "";
    public static String bJw = "";
    public static String bJx = "";
    public static String bJy = "";
    public static String bJz = "";
    public static String bJA = "";
    public static String bJB = "";
    public static String bJC = "";
    public static String bJD = "";
    public static String bJE = "";
    public static String bJF = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bJG = BdUniqueId.gen();
    public static final BdUniqueId Zb = BdUniqueId.gen();
    public boolean bJH = false;
    public boolean isLinkThread = false;
    public boolean bJI = false;
    public boolean aDu = true;

    public static boolean B(bl blVar) {
        if (blVar == null) {
            return false;
        }
        return blVar.getType() == bl.Za || blVar.getType() == bl.Zc || blVar.getType() == bl.Zb;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bJH) {
            return bJG;
        }
        if (this.isLinkThread) {
            return Zb;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.threadData;
    }

    public boolean WN() {
        return (this.threadData == null || u.u(this.threadData.rT()) == 0) ? false : true;
    }

    public aj WO() {
        if (WN()) {
            aj jj = jj(bJA);
            if (jj != null && MF() != null) {
                bl MF = MF();
                jj.r("obj_name", MF.sU() != null && (MF.sU().aAP() != null || MF.sU().Iv() != null) ? 1 : 0);
            }
            return jj;
        }
        aj jj2 = jj(bJv);
        if (jj2 != null) {
            jj2.aa("ab_tag", WH()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF2 = MF();
                jj2.r("obj_name", MF2.sU() != null && (MF2.sU().aAP() != null || MF2.sU().Iv() != null) ? 1 : 0);
            }
        }
        return jj2;
    }

    public aj jk(String str) {
        aj jj = jj(str);
        if (jj != null) {
            jj.g("fid", this.threadData.getFid());
            jj.aa("tid", this.threadData.getTid());
            jj.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return jj;
    }

    public aj jl(String str) {
        aj jj = jj(str);
        if (jj != null) {
            jj.aa("ab_tag", WH()).aa("ab_action", "show");
            if (MF() != null) {
                bl MF = MF();
                jj.r("obj_name", MF.sU() != null && (MF.sU().aAP() != null || MF.sU().Iv() != null) ? 1 : 0);
            }
        }
        return jj;
    }

    public aj jm(String str) {
        aj jj = jj(str);
        if (jj != null) {
            jj.aa("ab_tag", WH()).aa("ab_action", "click");
        }
        return jj;
    }

    public aj WP() {
        if (WN()) {
            return jj(bJB);
        }
        aj jj = jj(bJw);
        if (jj != null) {
            jj.aa("ab_tag", WH()).aa("ab_action", "click");
            return jj;
        }
        return jj;
    }

    public aj WQ() {
        if (WN()) {
            return jj(bJC);
        }
        aj J = J(bJx, 0);
        if (J != null) {
            J.aa("ab_tag", WH()).aa("ab_action", "click");
            return J;
        }
        return J;
    }

    public aj WR() {
        if (WN()) {
            return jj(bJD);
        }
        aj jj = jj(bJy);
        if (jj != null) {
            jj.aa("ab_tag", WH()).aa("ab_action", "click");
            return jj;
        }
        return jj;
    }

    public aj WS() {
        if (WN()) {
            return jj(bJE);
        }
        aj jj = jj(bJz);
        if (jj != null) {
            jj.aa("ab_tag", WH()).aa("ab_action", "click");
            return jj;
        }
        return jj;
    }

    public aj WT() {
        return jj(bJF);
    }

    public aj jn(String str) {
        return jj(str);
    }
}
