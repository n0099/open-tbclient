package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bOg = BdUniqueId.gen();
    public static final BdUniqueId bOh = BdUniqueId.gen();
    public static String bOi = "";
    public static String bOj = "";
    public static String bOk = "";
    public static String bOl = "";
    public static String bOm = "";
    public static String bOn = "";
    public static String bOo = "";
    public bj bcG;
    public boolean bOb = false;
    public boolean bOp = true;
    public int sourceType = 0;

    public n(bj bjVar) {
        this.bcG = bjVar;
    }

    public static boolean F(bj bjVar) {
        return (bjVar == null || bjVar.rS() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bcG == null) {
            return bOg;
        }
        if (this.bcG.rE() || this.bcG.rF()) {
            return bOh;
        }
        return bOg;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.bcG;
    }

    public ak jB(String str) {
        ak jA = jA(str);
        if (jA != null && this.bcG != null) {
            jA.f("fid", this.bcG.getFid());
            jA.ad("tid", this.bcG.getTid());
            jA.r("obj_type", 2);
        }
        return jA;
    }

    public ak Yv() {
        ak v = v(bOl, true);
        if (v != null && MR() != null) {
            bj MR = MR();
            v.r("obj_name", MR.sR() != null && (MR.sR().aDr() != null || MR.sR().ID() != null) ? 1 : 0);
        }
        return v;
    }

    public ak G(bj bjVar) {
        return (bjVar.sF() == null || bjVar.sF().channelId <= 0) ? v(bOm, true) : v(bOn, true);
    }

    public ak Yx() {
        return v(bOj, true);
    }

    public ak H(bj bjVar) {
        return (bjVar.sF() == null || bjVar.sF().channelId <= 0) ? v(bOi, true) : v(bOo, true);
    }
}
