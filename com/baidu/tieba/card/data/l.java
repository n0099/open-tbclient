package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class l extends c {
    public bk threadData;
    public static String bxk = "";
    public static String bxl = "";
    public static String bxm = "";
    public static String bxn = "";
    public static String bxo = "";
    public static String bxp = "";
    public static String bxq = "";
    public static String bxr = "";
    public static String bxs = "";
    public static String bxt = "";
    public static String bxu = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bxv = BdUniqueId.gen();
    public boolean bxw = false;
    public boolean bxx = false;
    public boolean aAo = true;

    public static boolean s(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        return bkVar.getType() == bk.Xt || bkVar.getType() == bk.Xu;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bxw) {
            return bxv;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk JB() {
        return this.threadData;
    }

    public boolean TF() {
        return (this.threadData == null || x.q(this.threadData.rM()) == 0) ? false : true;
    }

    public as TG() {
        if (TF()) {
            return ie(bxp);
        }
        as ie = ie(bxk);
        if (ie != null) {
            ie.aa("ab_tag", Ts()).aa("ab_action", "show");
            return ie;
        }
        return ie;
    }

    public as TH() {
        if (TF()) {
            return ie(bxq);
        }
        as ie = ie(bxl);
        if (ie != null) {
            ie.aa("ab_tag", Ts()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as TI() {
        if (TF()) {
            return ie(bxr);
        }
        as I = I(bxm, 0);
        if (I != null) {
            I.aa("ab_tag", Ts()).aa("ab_action", "click");
            return I;
        }
        return I;
    }

    public as TJ() {
        if (TF()) {
            return ie(bxs);
        }
        as ie = ie(bxn);
        if (ie != null) {
            ie.aa("ab_tag", Ts()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as TK() {
        if (TF()) {
            return ie(bxt);
        }
        as ie = ie(bxo);
        if (ie != null) {
            ie.aa("ab_tag", Ts()).aa("ab_action", "click");
            return ie;
        }
        return ie;
    }

    public as TL() {
        return ie(bxu);
    }
}
