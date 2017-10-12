package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bNL = BdUniqueId.gen();
    public static final BdUniqueId bNM = BdUniqueId.gen();
    public static String bNN = "";
    public static String bNO = "";
    public static String bNP = "";
    public static String bNQ = "";
    public static String bNR = "";
    public static String bNS = "";
    public static String bNT = "";
    public bh bes;
    public boolean bNG = false;
    public boolean bNU = true;
    public int sourceType = 0;

    public n(bh bhVar) {
        this.bes = bhVar;
    }

    public static boolean A(bh bhVar) {
        return (bhVar == null || bhVar.rM() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bes == null) {
            return bNL;
        }
        if (this.bes.ry() || this.bes.rz()) {
            return bNM;
        }
        return bNL;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nj() {
        return this.bes;
    }

    public ak ju(String str) {
        ak akVar = new ak(str);
        if (this.bes != null) {
            akVar.f("fid", this.bes.getFid());
            akVar.ad("tid", this.bes.getTid());
            akVar.r("obj_type", 2);
            if (this.bes.getAuthor() != null) {
                akVar.ad("obj_id", this.bes.getAuthor().getUserId());
            }
        }
        return akVar;
    }

    public ak Yd() {
        ak u = u(bNQ, true);
        if (u != null && Nj() != null) {
            bh Nj = Nj();
            u.r("obj_name", Nj.sL() != null && (Nj.sL().aCd() != null || Nj.sL().IL() != null) ? 1 : 0);
        }
        return u;
    }

    public ak B(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? u(bNR, true) : u(bNS, true);
    }

    public ak Yf() {
        return u(bNO, true);
    }

    public ak C(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? u(bNN, true) : u(bNT, true);
    }
}
