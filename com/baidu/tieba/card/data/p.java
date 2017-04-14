package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class p extends c {
    public static final BdUniqueId bvn = BdUniqueId.gen();
    public static final BdUniqueId bvo = BdUniqueId.gen();
    public static String bvp = "";
    public static String bvq = "";
    public static String bvr = "";
    public static String bvs = "";
    public static String bvt = "";
    public static String bvu = "";
    public static String bvv = "";
    public bi bbo;
    public boolean bvi = false;
    public boolean bvw = true;
    public int sourceType = 0;

    public p(bi biVar) {
        this.bbo = biVar;
    }

    public static boolean n(bi biVar) {
        return (biVar == null || biVar.sF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bbo == null) {
            return bvn;
        }
        if (this.bbo.sr() || this.bbo.ss()) {
            return bvo;
        }
        return bvn;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.bbo;
    }

    public as Tl() {
        return ie(bvs);
    }

    public as o(bi biVar) {
        return (biVar.ts() == null || biVar.ts().channelId <= 0) ? ie(bvt) : ie(bvu);
    }

    public as Tn() {
        return ie(bvq);
    }

    public as p(bi biVar) {
        return (biVar.ts() == null || biVar.ts().channelId <= 0) ? ie(bvp) : ie(bvv);
    }
}
