package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bID = BdUniqueId.gen();
    public static final BdUniqueId bIE = BdUniqueId.gen();
    public static String bIF = "";
    public static String bIG = "";
    public static String bIH = "";
    public static String bII = "";
    public static String bIJ = "";
    public static String bIK = "";
    public static String bIL = "";
    public bl bbB;
    public boolean bIy = false;
    public boolean bIM = true;
    public int sourceType = 0;

    public n(bl blVar) {
        this.bbB = blVar;
    }

    public static boolean B(bl blVar) {
        return (blVar == null || blVar.rM() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bbB == null) {
            return bID;
        }
        if (this.bbB.ry() || this.bbB.rz()) {
            return bIE;
        }
        return bID;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MA() {
        return this.bbB;
    }

    public aj jf(String str) {
        aj je = je(str);
        if (je != null && this.bbB != null) {
            je.f("fid", this.bbB.getFid());
            je.aa("tid", this.bbB.getTid());
            je.r("obj_type", 2);
        }
        return je;
    }

    public aj WJ() {
        aj v = v(bII, true);
        if (v != null && MA() != null) {
            bl MA = MA();
            v.r("obj_name", MA.sK() != null && (MA.sK().aAE() != null || MA.sK().Io() != null) ? 1 : 0);
        }
        return v;
    }

    public aj C(bl blVar) {
        return (blVar.sz() == null || blVar.sz().channelId <= 0) ? v(bIJ, true) : v(bIK, true);
    }

    public aj WL() {
        return v(bIG, true);
    }

    public aj D(bl blVar) {
        return (blVar.sz() == null || blVar.sz().channelId <= 0) ? v(bIF, true) : v(bIL, true);
    }
}
