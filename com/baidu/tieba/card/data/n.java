package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bxC = BdUniqueId.gen();
    public static final BdUniqueId bxD = BdUniqueId.gen();
    public static String bxE = "";
    public static String bxF = "";
    public static String bxG = "";
    public static String bxH = "";
    public static String bxI = "";
    public static String bxJ = "";
    public static String bxK = "";
    public bk bcB;
    public boolean bxx = false;
    public boolean bxL = true;
    public int sourceType = 0;

    public n(bk bkVar) {
        this.bcB = bkVar;
    }

    public static boolean s(bk bkVar) {
        return (bkVar == null || bkVar.rP() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bcB == null) {
            return bxC;
        }
        if (this.bcB.rB() || this.bcB.rC()) {
            return bxD;
        }
        return bxC;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk JB() {
        return this.bcB;
    }

    public as TG() {
        return A(bxH, true);
    }

    public as t(bk bkVar) {
        return (bkVar.sC() == null || bkVar.sC().channelId <= 0) ? A(bxI, true) : A(bxJ, true);
    }

    public as TI() {
        return A(bxF, true);
    }

    public as u(bk bkVar) {
        return (bkVar.sC() == null || bkVar.sC().channelId <= 0) ? A(bxE, true) : A(bxK, true);
    }
}
