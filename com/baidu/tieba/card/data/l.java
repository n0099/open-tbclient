package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bj threadData;
    public static String bNO = "";
    public static String bNP = "";
    public static String bNQ = "";
    public static String bNR = "";
    public static String bNS = "";
    public static String bNT = "";
    public static String bNU = "";
    public static String bNV = "";
    public static String bNW = "";
    public static String bNX = "";
    public static String bNY = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bNZ = BdUniqueId.gen();
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public boolean bOa = false;
    public boolean isLinkThread = false;
    public boolean bOb = false;
    public boolean aCG = true;

    public static boolean F(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.Yh || bjVar.getType() == bj.Yj || bjVar.getType() == bj.Yi;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bOa) {
            return bNZ;
        }
        if (this.isLinkThread) {
            return Yi;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.threadData;
    }

    public boolean Yu() {
        return (this.threadData == null || v.u(this.threadData.rP()) == 0) ? false : true;
    }

    public ak Yv() {
        if (Yu()) {
            ak jA = jA(bNT);
            if (jA != null && MR() != null) {
                bj MR = MR();
                jA.r("obj_name", MR.sR() != null && (MR.sR().aDr() != null || MR.sR().ID() != null) ? 1 : 0);
            }
            return jA;
        }
        ak jA2 = jA(bNO);
        if (jA2 != null) {
            jA2.ad("ab_tag", Yo()).ad("ab_action", "show");
            if (MR() != null) {
                bj MR2 = MR();
                boolean z = (MR2.sR() == null || (MR2.sR().aDr() == null && MR2.sR().ID() == null)) ? false : true;
                jA2.r("obj_name", z ? 1 : 0);
                if (z && MR2.sR().aDr() != null && MR2.sR().aDr().Iv() != null && MR2.sR().aDr().Iv().size() > 0) {
                    jA2.r("obj_to", MR2.sR().gjK ? 2 : 1);
                }
            }
        }
        return jA2;
    }

    public ak jB(String str) {
        ak jA = jA(str);
        if (jA != null) {
            jA.f("fid", this.threadData.getFid());
            jA.ad("tid", this.threadData.getTid());
            jA.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return jA;
    }

    public ak jC(String str) {
        ak jA = jA(str);
        if (jA != null) {
            jA.ad("ab_tag", Yo()).ad("ab_action", "show");
            if (MR() != null) {
                bj MR = MR();
                boolean z = (MR.sR() == null || (MR.sR().aDr() == null && MR.sR().ID() == null)) ? false : true;
                jA.r("obj_name", z ? 1 : 0);
                if (z && MR.sR().aDr() != null && MR.sR().aDr().Iv() != null && MR.sR().aDr().Iv().size() > 0) {
                    jA.r("obj_to", MR.sR().gjK ? 2 : 1);
                }
            }
        }
        return jA;
    }

    public ak jD(String str) {
        ak jA = jA(str);
        if (jA != null) {
            jA.ad("ab_tag", Yo()).ad("ab_action", "click");
        }
        return jA;
    }

    public ak Yw() {
        if (Yu()) {
            return jA(bNU);
        }
        ak jA = jA(bNP);
        if (jA != null) {
            jA.ad("ab_tag", Yo()).ad("ab_action", "click");
            return jA;
        }
        return jA;
    }

    public ak Yx() {
        if (Yu()) {
            return jA(bNV);
        }
        ak J = J(bNQ, 0);
        if (J != null) {
            J.ad("ab_tag", Yo()).ad("ab_action", "click");
            return J;
        }
        return J;
    }

    public ak Yy() {
        if (Yu()) {
            return jA(bNW);
        }
        ak jA = jA(bNR);
        if (jA != null) {
            jA.ad("ab_tag", Yo()).ad("ab_action", "click");
            return jA;
        }
        return jA;
    }

    public ak Yz() {
        if (Yu()) {
            return jA(bNX);
        }
        ak jA = jA(bNS);
        if (jA != null) {
            jA.ad("ab_tag", Yo()).ad("ab_action", "click");
            return jA;
        }
        return jA;
    }

    public ak YA() {
        return jA(bNY);
    }

    public ak jE(String str) {
        return jA(str);
    }
}
