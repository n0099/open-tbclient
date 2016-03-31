package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class t extends c {
    public as aVJ;
    public boolean aWd = false;
    public boolean aWe = false;
    public boolean auT = true;
    public static String aVR = "";
    public static String aVS = "";
    public static String aVT = "";
    public static String aVU = "";
    public static String aVV = "";
    public static String aVW = "";
    public static String aVX = "";
    public static String aVY = "";
    public static String aVZ = "";
    public static String aWa = "";
    public static String aWb = "";
    public static final BdUniqueId TC = BdUniqueId.gen();
    public static final BdUniqueId aWc = BdUniqueId.gen();

    public static boolean b(as asVar) {
        return asVar != null && asVar.getType() == as.UW;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.aVJ == null) {
            return TC;
        }
        if (this.aWd) {
            return aWc;
        }
        return TC;
    }

    @Override // com.baidu.tieba.card.a.c
    public as LC() {
        return this.aVJ;
    }

    public boolean LM() {
        return (this.aVJ == null || com.baidu.tbadk.core.util.y.p(this.aVJ.tz()) == 0) ? false : true;
    }

    public aw LN() {
        if (LM()) {
            return hh(aVW);
        }
        aw hh = hh(aVR);
        if (hh != null) {
            hh.ac("ab_tag", LA()).ac("ab_action", "show");
            return hh;
        }
        return hh;
    }

    public aw LO() {
        if (LM()) {
            return hh(aVX);
        }
        aw hh = hh(aVS);
        if (hh != null) {
            hh.ac("ab_tag", LA()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw LP() {
        if (LM()) {
            return hh(aVY);
        }
        aw hh = hh(aVT);
        if (hh != null) {
            hh.ac("ab_tag", LA()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw LQ() {
        if (LM()) {
            return hh(aVZ);
        }
        aw hh = hh(aVU);
        if (hh != null) {
            hh.ac("ab_tag", LA()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw LR() {
        if (LM()) {
            return hh(aWa);
        }
        aw hh = hh(aVV);
        if (hh != null) {
            hh.ac("ab_tag", LA()).ac("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public aw LS() {
        return hh(aWb);
    }
}
