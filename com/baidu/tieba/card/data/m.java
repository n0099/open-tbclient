package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class m extends c {
    public bg threadData;
    public static String bbH = "";
    public static String bbI = "";
    public static String bbJ = "";
    public static String bbK = "";
    public static String bbL = "";
    public static String bbM = "";
    public static String bbN = "";
    public static String bbO = "";
    public static String bbP = "";
    public static String bbQ = "";
    public static String bbR = "";
    public static final BdUniqueId Ro = BdUniqueId.gen();
    public static final BdUniqueId bbS = BdUniqueId.gen();
    public boolean bbT = false;
    public boolean bbU = false;
    public boolean avE = true;

    public static boolean c(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.TYPE_NORMAL || bgVar.getType() == bg.Tk;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return Ro;
        }
        if (this.bbT) {
            return bbS;
        }
        return Ro;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg Kw() {
        return this.threadData;
    }

    public boolean NX() {
        return (this.threadData == null || y.s(this.threadData.rO()) == 0) ? false : true;
    }

    public ay NY() {
        if (NX()) {
            return hM(bbM);
        }
        ay hM = hM(bbH);
        if (hM != null) {
            hM.ab("ab_tag", NL()).ab("ab_action", "show");
            return hM;
        }
        return hM;
    }

    public ay NZ() {
        if (NX()) {
            return hM(bbN);
        }
        ay hM = hM(bbI);
        if (hM != null) {
            hM.ab("ab_tag", NL()).ab("ab_action", "click");
            return hM;
        }
        return hM;
    }

    public ay Oa() {
        if (NX()) {
            return hM(bbO);
        }
        ay hM = hM(bbJ);
        if (hM != null) {
            hM.ab("ab_tag", NL()).ab("ab_action", "click");
            return hM;
        }
        return hM;
    }

    public ay Ob() {
        if (NX()) {
            return hM(bbP);
        }
        ay hM = hM(bbK);
        if (hM != null) {
            hM.ab("ab_tag", NL()).ab("ab_action", "click");
            return hM;
        }
        return hM;
    }

    public ay Oc() {
        if (NX()) {
            return hM(bbQ);
        }
        ay hM = hM(bbL);
        if (hM != null) {
            hM.ab("ab_tag", NL()).ab("ab_action", "click");
            return hM;
        }
        return hM;
    }

    public ay Od() {
        return hM(bbR);
    }
}
