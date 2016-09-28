package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class m extends c {
    public bi threadData;
    public static String bbZ = "";
    public static String bca = "";
    public static String bcb = "";
    public static String bcc = "";
    public static String bcd = "";
    public static String bce = "";
    public static String bcf = "";
    public static String bcg = "";
    public static String bch = "";
    public static String bci = "";
    public static String bcj = "";
    public static final BdUniqueId Ru = BdUniqueId.gen();
    public static final BdUniqueId bck = BdUniqueId.gen();
    public boolean bcl = false;
    public boolean bcm = false;
    public boolean avh = true;

    public static boolean d(bi biVar) {
        if (biVar == null) {
            return false;
        }
        return biVar.getType() == bi.Tr || biVar.getType() == bi.Ts;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return Ru;
        }
        if (this.bcl) {
            return bck;
        }
        return Ru;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Jv() {
        return this.threadData;
    }

    public boolean Oz() {
        return (this.threadData == null || y.s(this.threadData.sa()) == 0) ? false : true;
    }

    public ax OA() {
        if (Oz()) {
            return hT(bce);
        }
        ax hT = hT(bbZ);
        if (hT != null) {
            hT.ab("ab_tag", Om()).ab("ab_action", "show");
            return hT;
        }
        return hT;
    }

    public ax OB() {
        if (Oz()) {
            return hT(bcf);
        }
        ax hT = hT(bca);
        if (hT != null) {
            hT.ab("ab_tag", Om()).ab("ab_action", "click");
            return hT;
        }
        return hT;
    }

    public ax OC() {
        if (Oz()) {
            return hT(bcg);
        }
        ax hT = hT(bcb);
        if (hT != null) {
            hT.ab("ab_tag", Om()).ab("ab_action", "click");
            return hT;
        }
        return hT;
    }

    public ax OD() {
        if (Oz()) {
            return hT(bch);
        }
        ax hT = hT(bcc);
        if (hT != null) {
            hT.ab("ab_tag", Om()).ab("ab_action", "click");
            return hT;
        }
        return hT;
    }

    public ax OE() {
        if (Oz()) {
            return hT(bci);
        }
        ax hT = hT(bcd);
        if (hT != null) {
            hT.ab("ab_tag", Om()).ab("ab_action", "click");
            return hT;
        }
        return hT;
    }

    public ax OF() {
        return hT(bcj);
    }
}
