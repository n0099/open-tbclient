package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class p extends c {
    public static final BdUniqueId bxE = BdUniqueId.gen();
    public static final BdUniqueId bxF = BdUniqueId.gen();
    public static String bxG = "";
    public static String bxH = "";
    public static String bxI = "";
    public static String bxJ = "";
    public static String bxK = "";
    public static String bxL = "";
    public static String bxM = "";
    public bi bck;
    public boolean bxz = false;
    public boolean bxN = true;
    public int sourceType = 0;

    public p(bi biVar) {
        this.bck = biVar;
    }

    public static boolean n(bi biVar) {
        return (biVar == null || biVar.sF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bck == null) {
            return bxE;
        }
        if (this.bck.sr() || this.bck.ss()) {
            return bxF;
        }
        return bxE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.bck;
    }

    public as Un() {
        return A(bxJ, true);
    }

    public as o(bi biVar) {
        return (biVar.ts() == null || biVar.ts().channelId <= 0) ? A(bxK, true) : A(bxL, true);
    }

    public as Up() {
        return A(bxH, true);
    }

    public as p(bi biVar) {
        return (biVar.ts() == null || biVar.ts().channelId <= 0) ? A(bxG, true) : A(bxM, true);
    }
}
