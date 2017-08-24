package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class n extends c {
    public bl bcN;
    public static final BdUniqueId bKx = BdUniqueId.gen();
    public static final BdUniqueId bKy = BdUniqueId.gen();
    public static String bKz = "";
    public static String bKA = "";
    public static String bKB = "";
    public static String bKC = "";
    public static String bKD = "";
    public static String bKE = "";
    public static String bKF = "";
    public boolean bKs = false;
    public boolean bKG = true;
    public int sourceType = 0;

    public n(bl blVar) {
        this.bcN = blVar;
    }

    public static boolean B(bl blVar) {
        return (blVar == null || blVar.rX() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bcN == null) {
            return bKx;
        }
        if (this.bcN.rJ() || this.bcN.rK()) {
            return bKy;
        }
        return bKx;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcN;
    }

    public aj jo(String str) {
        aj jn = jn(str);
        if (jn != null && this.bcN != null) {
            jn.g("fid", this.bcN.getFid());
            jn.aa("tid", this.bcN.getTid());
            jn.r("obj_type", 2);
        }
        return jn;
    }

    public aj Xh() {
        aj v = v(bKC, true);
        if (v != null && MF() != null) {
            bl MF = MF();
            v.r("obj_name", MF.sV() != null && (MF.sV().aBr() != null || MF.sV().Iv() != null) ? 1 : 0);
        }
        return v;
    }

    public aj C(bl blVar) {
        return (blVar.sK() == null || blVar.sK().channelId <= 0) ? v(bKD, true) : v(bKE, true);
    }

    public aj Xj() {
        return v(bKA, true);
    }

    public aj D(bl blVar) {
        return (blVar.sK() == null || blVar.sK().channelId <= 0) ? v(bKz, true) : v(bKF, true);
    }
}
