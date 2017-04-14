package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class n extends c {
    public bi threadData;
    public static String buV = "";
    public static String buW = "";
    public static String buX = "";
    public static String buY = "";
    public static String buZ = "";
    public static String bva = "";
    public static String bvb = "";
    public static String bvc = "";
    public static String bvd = "";
    public static String bve = "";
    public static String bvf = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bvg = BdUniqueId.gen();
    public boolean bvh = false;
    public boolean bvi = false;
    public boolean aAo = true;

    public static boolean n(bi biVar) {
        if (biVar == null) {
            return false;
        }
        return biVar.getType() == bi.Ya || biVar.getType() == bi.Yb;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bvh) {
            return bvg;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.threadData;
    }

    public boolean Tk() {
        return (this.threadData == null || x.p(this.threadData.sC()) == 0) ? false : true;
    }

    public as Tl() {
        if (Tk()) {
            return ie(bva);
        }
        as ie = ie(buV);
        if (ie != null) {
            ie.aa("ab_tag", SX()).aa("ab_action", "show");
            return ie;
        }
        return ie;
    }

    public as Tm() {
        if (Tk()) {
            return ie(bvb);
        }
        as ie = ie(buW);
        if (ie != null) {
            ie.aa("ab_tag", SX()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as Tn() {
        if (Tk()) {
            return ie(bvc);
        }
        as ie = ie(buX);
        if (ie != null) {
            ie.aa("ab_tag", SX()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as To() {
        if (Tk()) {
            return ie(bvd);
        }
        as ie = ie(buY);
        if (ie != null) {
            ie.aa("ab_tag", SX()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as Tp() {
        if (Tk()) {
            return ie(bve);
        }
        as ie = ie(buZ);
        if (ie != null) {
            ie.aa("ab_tag", SX()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as Tq() {
        return ie(bvf);
    }
}
