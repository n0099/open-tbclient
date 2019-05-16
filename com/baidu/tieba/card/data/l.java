package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId eBk = BdUniqueId.gen();
    public static final BdUniqueId eBl = BdUniqueId.gen();
    public static String eAT = "";
    public static String eAU = "";
    public static String eBm = "";
    public static String eAS = "";
    public static String eBn = "";
    public static String eBo = "";
    public static String eBp = "";
    public boolean eBj = false;
    public boolean eBq = true;
    public boolean bHV = false;
    public boolean eBr = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean eBi = false;
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
            return k.eAX;
        }
        if (this.eBr) {
            return bIw;
        }
        if (this.bIa) {
            return k.eBe;
        }
        if (this.bIb) {
            return k.eBd;
        }
        if (this.eBi) {
            return k.eBc;
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
            amVar.P("obj_param1", aYb() ? 2 : 1);
            if (this.threadData.adv() != null) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.adv().getUserId());
            }
        }
        return amVar;
    }

    public am aYh() {
        am U = U(eBm, true);
        if (U != null && abv() != null) {
            bg abv = abv();
            U.P("obj_name", abv.aeT() != null && (abv.aeT().cmw() != null || abv.aeT().axH() != null) ? 1 : 0);
            if (abv.adv() != null) {
                U.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
            }
        }
        return U;
    }

    public am b(bg bgVar, int i) {
        if (bgVar.aeF() != null && bgVar.aeF().channelId > 0) {
            return U(eBn, true);
        }
        am U = U(eAS, true);
        if (U != null && i != -1) {
            U.P("click_locate", i);
            return U;
        }
        return U;
    }

    public am X(bg bgVar) {
        return b(bgVar, -1);
    }

    public am aYo() {
        return U(eBp, true);
    }

    public am aYj() {
        return U(eAU, true);
    }

    public am Y(bg bgVar) {
        return (bgVar.aeF() == null || bgVar.aeF().channelId <= 0) ? U(eAT, true) : U(eBo, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.threadData == null || this.threadData.adM() == null || this.threadData.adM().video_url == null) {
            return null;
        }
        return this.threadData.adM().video_url;
    }
}
