package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class q extends c {
    public ah aSc;
    public boolean aSt = false;
    public boolean aut = true;
    public static String aSi = "";
    public static String aSj = "";
    public static String aSk = "";
    public static String aSl = "";
    public static String aSm = "";
    public static String aSn = "";
    public static String aSo = "";
    public static String aSp = "";
    public static String aSq = "";
    public static String aSr = "";
    public static String aSs = "";
    public static final BdUniqueId aRS = BdUniqueId.gen();

    public static boolean b(ah ahVar) {
        return ahVar != null && ahVar.getType() == ah.WG;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }

    @Override // com.baidu.tieba.card.a.c
    public ah Ki() {
        return this.aSc;
    }

    public boolean Ks() {
        return (this.aSc == null || x.o(this.aSc.tw()) == 0) ? false : true;
    }

    public au Kt() {
        if (Ks()) {
            return gU(aSn);
        }
        au gU = gU(aSi);
        if (gU != null) {
            gU.aa("ab_tag", Kg()).aa("ab_action", "show");
            return gU;
        }
        return gU;
    }

    public au Ku() {
        if (Ks()) {
            return gU(aSo);
        }
        au gU = gU(aSj);
        if (gU != null) {
            gU.aa("ab_tag", Kg()).aa("ab_action", "click");
            return gU;
        }
        return gU;
    }

    public au Kv() {
        if (Ks()) {
            return gU(aSp);
        }
        au gU = gU(aSk);
        if (gU != null) {
            gU.aa("ab_tag", Kg()).aa("ab_action", "click");
            return gU;
        }
        return gU;
    }

    public au Kw() {
        if (Ks()) {
            return gU(aSq);
        }
        au gU = gU(aSl);
        if (gU != null) {
            gU.aa("ab_tag", Kg()).aa("ab_action", "click");
            return gU;
        }
        return gU;
    }

    public au Kx() {
        if (Ks()) {
            return gU(aSr);
        }
        au gU = gU(aSm);
        if (gU != null) {
            gU.aa("ab_tag", Kg()).aa("ab_action", "click");
            return gU;
        }
        return gU;
    }

    public au Ky() {
        return gU(aSs);
    }
}
