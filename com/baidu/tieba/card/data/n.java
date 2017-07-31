package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bJN = BdUniqueId.gen();
    public static final BdUniqueId bJO = BdUniqueId.gen();
    public static String bJP = "";
    public static String bJQ = "";
    public static String bJR = "";
    public static String bJS = "";
    public static String bJT = "";
    public static String bJU = "";
    public static String bJV = "";
    public bl bcL;
    public boolean bJI = false;
    public boolean bJW = true;
    public int sourceType = 0;

    public n(bl blVar) {
        this.bcL = blVar;
    }

    public static boolean B(bl blVar) {
        return (blVar == null || blVar.rW() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bcL == null) {
            return bJN;
        }
        if (this.bcL.rI() || this.bcL.rJ()) {
            return bJO;
        }
        return bJN;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcL;
    }

    public aj jk(String str) {
        aj jj = jj(str);
        if (jj != null && this.bcL != null) {
            jj.g("fid", this.bcL.getFid());
            jj.aa("tid", this.bcL.getTid());
            jj.r("obj_type", 2);
        }
        return jj;
    }

    public aj WO() {
        aj v = v(bJS, true);
        if (v != null && MF() != null) {
            bl MF = MF();
            v.r("obj_name", MF.sU() != null && (MF.sU().aAP() != null || MF.sU().Iv() != null) ? 1 : 0);
        }
        return v;
    }

    public aj C(bl blVar) {
        return (blVar.sJ() == null || blVar.sJ().channelId <= 0) ? v(bJT, true) : v(bJU, true);
    }

    public aj WQ() {
        return v(bJQ, true);
    }

    public aj D(bl blVar) {
        return (blVar.sJ() == null || blVar.sJ().channelId <= 0) ? v(bJP, true) : v(bJV, true);
    }
}
