package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId bcr = BdUniqueId.gen();
    public static final BdUniqueId bcs = BdUniqueId.gen();
    public static String bct = "";
    public static String bcu = "";
    public static String bcv = "";
    public static String bcw = "";
    public static String bcx = "";
    public bi bbU;
    public boolean bcm = false;
    public boolean bcy = true;

    public o(bi biVar) {
        this.bbU = biVar;
    }

    public static boolean d(bi biVar) {
        return (biVar == null || biVar.sd() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bbU == null) {
            return bcr;
        }
        if (this.bbU.rP() || this.bbU.rQ()) {
            return bcs;
        }
        return bcr;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Jv() {
        return this.bbU;
    }

    public ax OA() {
        return hT(bcw);
    }

    public ax OB() {
        return hT(bcx);
    }

    public ax OC() {
        return hT(bcu);
    }

    public ax OD() {
        return hT(bct);
    }

    public ax OL() {
        return x(bcv, true);
    }
}
