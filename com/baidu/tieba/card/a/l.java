package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class l extends c {
    public ax aRG;
    public boolean aRX = false;
    public boolean aRY = false;
    public boolean aqS = true;
    public static String aRL = "";
    public static String aRM = "";
    public static String aRN = "";
    public static String aRO = "";
    public static String aRP = "";
    public static String aRQ = "";
    public static String aRR = "";
    public static String aRS = "";
    public static String aRT = "";
    public static String aRU = "";
    public static String aRV = "";
    public static final BdUniqueId Oq = BdUniqueId.gen();
    public static final BdUniqueId aRW = BdUniqueId.gen();

    public static boolean b(ax axVar) {
        return axVar != null && axVar.getType() == ax.TYPE_NORMAL;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aRG == null) {
            return Oq;
        }
        if (this.aRX) {
            return aRW;
        }
        return Oq;
    }

    @Override // com.baidu.tieba.card.a.c
    public ax Kn() {
        return this.aRG;
    }

    public boolean Kx() {
        return (this.aRG == null || y.r(this.aRG.qY()) == 0) ? false : true;
    }

    public aw Ky() {
        if (Kx()) {
            return hh(aRQ);
        }
        aw hh = hh(aRL);
        if (hh != null) {
            hh.ac("ab_tag", Kl()).ac("ab_action", "show");
            return hh;
        }
        return hh;
    }

    public aw Kz() {
        if (Kx()) {
            return hh(aRR);
        }
        aw hh = hh(aRM);
        if (hh != null) {
            hh.ac("ab_tag", Kl()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw KA() {
        if (Kx()) {
            return hh(aRS);
        }
        aw hh = hh(aRN);
        if (hh != null) {
            hh.ac("ab_tag", Kl()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw KB() {
        if (Kx()) {
            return hh(aRT);
        }
        aw hh = hh(aRO);
        if (hh != null) {
            hh.ac("ab_tag", Kl()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw KC() {
        if (Kx()) {
            return hh(aRU);
        }
        aw hh = hh(aRP);
        if (hh != null) {
            hh.ac("ab_tag", Kl()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw KD() {
        return hh(aRV);
    }
}
