package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bNp = BdUniqueId.gen();
    public static final BdUniqueId bNq = BdUniqueId.gen();
    public static String bNr = "";
    public static String bNs = "";
    public static String bNt = "";
    public static String bNu = "";
    public static String bNv = "";
    public static String bNw = "";
    public static String bNx = "";
    public bj bcJ;
    public boolean bNk = false;
    public boolean bNy = true;
    public int sourceType = 0;

    public n(bj bjVar) {
        this.bcJ = bjVar;
    }

    public static boolean F(bj bjVar) {
        return (bjVar == null || bjVar.rS() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bcJ == null) {
            return bNp;
        }
        if (this.bcJ.rE() || this.bcJ.rF()) {
            return bNq;
        }
        return bNp;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.bcJ;
    }

    public ak jz(String str) {
        ak jy = jy(str);
        if (jy != null && this.bcJ != null) {
            jy.f("fid", this.bcJ.getFid());
            jy.ad("tid", this.bcJ.getTid());
            jy.r("obj_type", 2);
        }
        return jy;
    }

    public ak Yk() {
        ak v = v(bNu, true);
        if (v != null && MR() != null) {
            bj MR = MR();
            v.r("obj_name", MR.sR() != null && (MR.sR().aDg() != null || MR.sR().ID() != null) ? 1 : 0);
        }
        return v;
    }

    public ak G(bj bjVar) {
        return (bjVar.sF() == null || bjVar.sF().channelId <= 0) ? v(bNv, true) : v(bNw, true);
    }

    public ak Ym() {
        return v(bNs, true);
    }

    public ak H(bj bjVar) {
        return (bjVar.sF() == null || bjVar.sF().channelId <= 0) ? v(bNr, true) : v(bNx, true);
    }
}
