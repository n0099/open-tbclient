package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId beG = BdUniqueId.gen();
    public static final BdUniqueId beH = BdUniqueId.gen();
    public static String beI = "";
    public static String beJ = "";
    public static String beK = "";
    public static String beL = "";
    public static String beM = "";
    public bg beB;
    public boolean beA = false;
    public boolean beN = true;
    public int sourceType = 0;

    public o(bg bgVar) {
        this.beB = bgVar;
    }

    public static boolean l(bg bgVar) {
        return (bgVar == null || bgVar.rW() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.beB == null) {
            return beG;
        }
        if (this.beB.rH() || this.beB.rI()) {
            return beH;
        }
        return beG;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg IU() {
        return this.beB;
    }

    public at OZ() {
        return hR(beL);
    }

    public at Pa() {
        return hR(beM);
    }

    public at Pb() {
        return hR(beJ);
    }

    public at Pc() {
        return hR(beI);
    }

    public at Pk() {
        return x(beK, true);
    }
}
