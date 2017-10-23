package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public bh bee;
    public static final BdUniqueId bNz = BdUniqueId.gen();
    public static final BdUniqueId bNA = BdUniqueId.gen();
    public static String bNB = "";
    public static String bNC = "";
    public static String bND = "";
    public static String bNE = "";
    public static String bNF = "";
    public static String bNG = "";
    public static String bNH = "";
    public boolean bNu = false;
    public boolean bNI = true;
    public int sourceType = 0;

    public n(bh bhVar) {
        this.bee = bhVar;
    }

    public static boolean A(bh bhVar) {
        return (bhVar == null || bhVar.rF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bee == null) {
            return bNz;
        }
        if (this.bee.rr() || this.bee.rs()) {
            return bNA;
        }
        return bNz;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nd() {
        return this.bee;
    }

    public ak jt(String str) {
        ak akVar = new ak(str);
        if (this.bee != null) {
            akVar.f("fid", this.bee.getFid());
            akVar.ac("tid", this.bee.getTid());
            akVar.r("obj_type", 2);
            if (this.bee.getAuthor() != null) {
                akVar.ac("obj_id", this.bee.getAuthor().getUserId());
            }
        }
        return akVar;
    }

    public ak XZ() {
        ak u = u(bNE, true);
        if (u != null && Nd() != null) {
            bh Nd = Nd();
            u.r("obj_name", Nd.sE() != null && (Nd.sE().aBY() != null || Nd.sE().IF() != null) ? 1 : 0);
        }
        return u;
    }

    public ak B(bh bhVar) {
        return (bhVar.ss() == null || bhVar.ss().channelId <= 0) ? u(bNF, true) : u(bNG, true);
    }

    public ak Yb() {
        return u(bNC, true);
    }

    public ak C(bh bhVar) {
        return (bhVar.ss() == null || bhVar.ss().channelId <= 0) ? u(bNB, true) : u(bNH, true);
    }
}
