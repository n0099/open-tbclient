package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId eBl = BdUniqueId.gen();
    public static final BdUniqueId eBm = BdUniqueId.gen();
    public static String eAU = "";
    public static String eAV = "";
    public static String eBn = "";
    public static String eAT = "";
    public static String eBo = "";
    public static String eBp = "";
    public static String eBq = "";
    public boolean eBk = false;
    public boolean eBr = true;
    public boolean bHV = false;
    public boolean eBs = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean eBj = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.threadData = bgVar;
    }

    public static boolean V(bg bgVar) {
        return (bgVar == null || bgVar.adM() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return k.TYPE;
        }
        if (this.bHV) {
            return k.eAY;
        }
        if (this.eBs) {
            return bIw;
        }
        if (this.bIa) {
            return k.eBf;
        }
        if (this.bIb) {
            return k.eBe;
        }
        if (this.eBj) {
            return k.eBd;
        }
        return bIw;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg abv() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.adj() != 5) {
            this.threadData.setResource(1);
        }
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String abw() {
        if (this.threadData == null) {
            return null;
        }
        return this.threadData.bKt;
    }

    public am uZ(String str) {
        am amVar = new am(str);
        if (this.threadData != null) {
            amVar.l("fid", this.threadData.getFid());
            amVar.bT("tid", this.threadData.getTid());
            amVar.P("obj_type", 2);
            amVar.P("obj_param1", aYe() ? 2 : 1);
            if (this.threadData.adv() != null) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.adv().getUserId());
            }
        }
        return amVar;
    }

    public am aYk() {
        am U = U(eBn, true);
        if (U != null && abv() != null) {
            bg abv = abv();
            U.P("obj_name", abv.aeT() != null && (abv.aeT().cmy() != null || abv.aeT().axI() != null) ? 1 : 0);
            if (abv.adv() != null) {
                U.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
            }
        }
        return U;
    }

    public am b(bg bgVar, int i) {
        if (bgVar.aeF() != null && bgVar.aeF().channelId > 0) {
            return U(eBo, true);
        }
        am U = U(eAT, true);
        if (U != null && i != -1) {
            U.P("click_locate", i);
            return U;
        }
        return U;
    }

    public am X(bg bgVar) {
        return b(bgVar, -1);
    }

    public am aYr() {
        return U(eBq, true);
    }

    public am aYm() {
        return U(eAV, true);
    }

    public am Y(bg bgVar) {
        return (bgVar.aeF() == null || bgVar.aeF().channelId <= 0) ? U(eAU, true) : U(eBp, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.threadData == null || this.threadData.adM() == null || this.threadData.adM().video_url == null) {
            return null;
        }
        return this.threadData.adM().video_url;
    }
}
