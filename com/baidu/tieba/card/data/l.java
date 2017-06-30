package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class l extends c {
    public bm threadData;
    public static String bDZ = "";
    public static String bEa = "";
    public static String bEb = "";
    public static String bEc = "";
    public static String bEd = "";
    public static String bEe = "";
    public static String bEf = "";
    public static String bEg = "";
    public static String bEh = "";
    public static String bEi = "";
    public static String bEj = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bEk = BdUniqueId.gen();
    public static final BdUniqueId Xp = BdUniqueId.gen();
    public boolean bEl = false;
    public boolean isLinkThread = false;
    public boolean bEm = false;
    public boolean aBd = true;

    public static boolean x(bm bmVar) {
        if (bmVar == null) {
            return false;
        }
        return bmVar.getType() == bm.Xo || bmVar.getType() == bm.Xq || bmVar.getType() == bm.Xp;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bEl) {
            return bEk;
        }
        if (this.isLinkThread) {
            return Xp;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bm Mv() {
        return this.threadData;
    }

    public boolean Wa() {
        return (this.threadData == null || z.s(this.threadData.rF()) == 0) ? false : true;
    }

    public au Wb() {
        if (Wa()) {
            au iP = iP(bEe);
            if (iP != null && Mv() != null) {
                bm Mv = Mv();
                iP.r("obj_name", Mv.sE() != null && (Mv.sE().azb() != null || Mv.sE().Ic() != null) ? 1 : 0);
            }
            return iP;
        }
        au iP2 = iP(bDZ);
        if (iP2 != null) {
            iP2.Z("ab_tag", VU()).Z("ab_action", "show");
            if (Mv() != null) {
                bm Mv2 = Mv();
                iP2.r("obj_name", Mv2.sE() != null && (Mv2.sE().azb() != null || Mv2.sE().Ic() != null) ? 1 : 0);
            }
        }
        return iP2;
    }

    public au iQ(String str) {
        au iP = iP(str);
        if (iP != null) {
            iP.Z("ab_tag", VU()).Z("ab_action", "show");
            if (Mv() != null) {
                bm Mv = Mv();
                iP.r("obj_name", Mv.sE() != null && (Mv.sE().azb() != null || Mv.sE().Ic() != null) ? 1 : 0);
            }
        }
        return iP;
    }

    public au iR(String str) {
        au iP = iP(str);
        if (iP != null) {
            iP.Z("ab_tag", VU()).Z("ab_action", "click");
        }
        return iP;
    }

    public au Wc() {
        if (Wa()) {
            return iP(bEf);
        }
        au iP = iP(bEa);
        if (iP != null) {
            iP.Z("ab_tag", VU()).Z("ab_action", "click");
            return iP;
        }
        return iP;
    }

    public au Wd() {
        if (Wa()) {
            return iP(bEg);
        }
        au K = K(bEb, 0);
        if (K != null) {
            K.Z("ab_tag", VU()).Z("ab_action", "click");
            return K;
        }
        return K;
    }

    public au We() {
        if (Wa()) {
            return iP(bEh);
        }
        au iP = iP(bEc);
        if (iP != null) {
            iP.Z("ab_tag", VU()).Z("ab_action", "click");
            return iP;
        }
        return iP;
    }

    public au Wf() {
        if (Wa()) {
            return iP(bEi);
        }
        au iP = iP(bEd);
        if (iP != null) {
            iP.Z("ab_tag", VU()).Z("ab_action", "click");
            return iP;
        }
        return iP;
    }

    public au Wg() {
        return iP(bEj);
    }

    public au iS(String str) {
        return iP(str);
    }
}
