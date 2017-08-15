package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class n extends c {
    public bl bcM;
    public static final BdUniqueId bKw = BdUniqueId.gen();
    public static final BdUniqueId bKx = BdUniqueId.gen();
    public static String bKy = "";
    public static String bKz = "";
    public static String bKA = "";
    public static String bKB = "";
    public static String bKC = "";
    public static String bKD = "";
    public static String bKE = "";
    public boolean bKr = false;
    public boolean bKF = true;
    public int sourceType = 0;

    public n(bl blVar) {
        this.bcM = blVar;
    }

    public static boolean B(bl blVar) {
        return (blVar == null || blVar.rW() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bcM == null) {
            return bKw;
        }
        if (this.bcM.rI() || this.bcM.rJ()) {
            return bKx;
        }
        return bKw;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcM;
    }

    public aj jl(String str) {
        aj jk = jk(str);
        if (jk != null && this.bcM != null) {
            jk.g("fid", this.bcM.getFid());
            jk.aa("tid", this.bcM.getTid());
            jk.r("obj_type", 2);
        }
        return jk;
    }

    public aj Xk() {
        aj v = v(bKB, true);
        if (v != null && MF() != null) {
            bl MF = MF();
            v.r("obj_name", MF.sU() != null && (MF.sU().aBw() != null || MF.sU().Iv() != null) ? 1 : 0);
        }
        return v;
    }

    public aj C(bl blVar) {
        return (blVar.sJ() == null || blVar.sJ().channelId <= 0) ? v(bKC, true) : v(bKD, true);
    }

    public aj Xm() {
        return v(bKz, true);
    }

    public aj D(bl blVar) {
        return (blVar.sJ() == null || blVar.sJ().channelId <= 0) ? v(bKy, true) : v(bKE, true);
    }
}
