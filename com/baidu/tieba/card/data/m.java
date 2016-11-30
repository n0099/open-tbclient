package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class m extends c {
    public bk threadData;
    public static String beX = "";
    public static String beY = "";
    public static String beZ = "";
    public static String bfa = "";
    public static String bfc = "";
    public static String bfd = "";
    public static String bfe = "";
    public static String bff = "";
    public static String bfg = "";
    public static String bfh = "";
    public static String bfi = "";
    public static final BdUniqueId RQ = BdUniqueId.gen();
    public static final BdUniqueId bfj = BdUniqueId.gen();
    public boolean bfk = false;
    public boolean bfl = false;
    public boolean awb = true;

    public static boolean g(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        return bkVar.getType() == bk.TM || bkVar.getType() == bk.TO;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return RQ;
        }
        if (this.bfk) {
            return bfj;
        }
        return RQ;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk Jz() {
        return this.threadData;
    }

    public boolean PC() {
        return (this.threadData == null || x.s(this.threadData.sc()) == 0) ? false : true;
    }

    public av PD() {
        if (PC()) {
            return hX(bfd);
        }
        av hX = hX(beX);
        if (hX != null) {
            hX.ab("ab_tag", Pp()).ab("ab_action", "show");
            return hX;
        }
        return hX;
    }

    public av PE() {
        if (PC()) {
            return hX(bfe);
        }
        av hX = hX(beY);
        if (hX != null) {
            hX.ab("ab_tag", Pp()).ab("ab_action", "click");
            return hX;
        }
        return hX;
    }

    public av PF() {
        if (PC()) {
            return hX(bff);
        }
        av hX = hX(beZ);
        if (hX != null) {
            hX.ab("ab_tag", Pp()).ab("ab_action", "click");
            return hX;
        }
        return hX;
    }

    public av PG() {
        if (PC()) {
            return hX(bfg);
        }
        av hX = hX(bfa);
        if (hX != null) {
            hX.ab("ab_tag", Pp()).ab("ab_action", "click");
            return hX;
        }
        return hX;
    }

    public av PH() {
        if (PC()) {
            return hX(bfh);
        }
        av hX = hX(bfc);
        if (hX != null) {
            hX.ab("ab_tag", Pp()).ab("ab_action", "click");
            return hX;
        }
        return hX;
    }

    public av PI() {
        return hX(bfi);
    }
}
