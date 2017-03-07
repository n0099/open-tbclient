package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class p extends c {
    public bj bbv;
    public static final BdUniqueId bvu = BdUniqueId.gen();
    public static final BdUniqueId bvv = BdUniqueId.gen();
    public static String bvw = "";
    public static String bvx = "";
    public static String bvy = "";
    public static String bvz = "";
    public static String bvA = "";
    public static String bvB = "";
    public static String bvC = "";
    public boolean bvp = false;
    public boolean bvD = true;
    public int sourceType = 0;

    public p(bj bjVar) {
        this.bbv = bjVar;
    }

    public static boolean n(bj bjVar) {
        return (bjVar == null || bjVar.sh() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bbv == null) {
            return bvu;
        }
        if (this.bbv.rT() || this.bbv.rU()) {
            return bvv;
        }
        return bvu;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj JN() {
        return this.bbv;
    }

    public as SN() {
        return ia(bvz);
    }

    public as o(bj bjVar) {
        return (bjVar.sU() == null || bjVar.sU().channelId <= 0) ? ia(bvA) : ia(bvB);
    }

    public as SP() {
        return ia(bvx);
    }

    public as p(bj bjVar) {
        return (bjVar.sU() == null || bjVar.sU().channelId <= 0) ? ia(bvw) : ia(bvC);
    }
}
