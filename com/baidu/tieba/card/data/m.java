package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class m extends c {
    public bg threadData;
    public static String bem = "";
    public static String ben = "";
    public static String beo = "";
    public static String bep = "";
    public static String beq = "";
    public static String ber = "";
    public static String bes = "";
    public static String beu = "";
    public static String bev = "";
    public static String bew = "";
    public static String bex = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bey = BdUniqueId.gen();
    public boolean bez = false;
    public boolean beA = false;
    public boolean avy = true;

    public static boolean l(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.Tn || bgVar.getType() == bg.To;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bez) {
            return bey;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg IU() {
        return this.threadData;
    }

    public boolean OY() {
        return (this.threadData == null || x.s(this.threadData.rT()) == 0) ? false : true;
    }

    public at OZ() {
        if (OY()) {
            return hR(ber);
        }
        at hR = hR(bem);
        if (hR != null) {
            hR.ab("ab_tag", OL()).ab("ab_action", "show");
            return hR;
        }
        return hR;
    }

    public at Pa() {
        if (OY()) {
            return hR(bes);
        }
        at hR = hR(ben);
        if (hR != null) {
            hR.ab("ab_tag", OL()).ab("ab_action", "click");
            return hR;
        }
        return hR;
    }

    public at Pb() {
        if (OY()) {
            return hR(beu);
        }
        at hR = hR(beo);
        if (hR != null) {
            hR.ab("ab_tag", OL()).ab("ab_action", "click");
            return hR;
        }
        return hR;
    }

    public at Pc() {
        if (OY()) {
            return hR(bev);
        }
        at hR = hR(bep);
        if (hR != null) {
            hR.ab("ab_tag", OL()).ab("ab_action", "click");
            return hR;
        }
        return hR;
    }

    public at Pd() {
        if (OY()) {
            return hR(bew);
        }
        at hR = hR(beq);
        if (hR != null) {
            hR.ab("ab_tag", OL()).ab("ab_action", "click");
            return hR;
        }
        return hR;
    }

    public at Pe() {
        return hR(bex);
    }
}
