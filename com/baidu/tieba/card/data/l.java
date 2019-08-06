package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId bJC = BdUniqueId.gen();
    public static final BdUniqueId eGo = BdUniqueId.gen();
    public static final BdUniqueId eGp = BdUniqueId.gen();
    public static String eFX = "";
    public static String eFY = "";
    public static String eGq = "";
    public static String eFW = "";
    public static String eGr = "";
    public static String eGs = "";
    public static String eGt = "";
    public boolean eGn = false;
    public boolean eGu = true;
    public boolean bJb = false;
    public boolean eGv = false;
    public boolean bJg = false;
    public boolean bJh = false;
    public boolean eGm = false;
    public int sourceType = 0;

    public l(bh bhVar) {
        this.threadData = bhVar;
    }

    public static boolean W(bh bhVar) {
        return (bhVar == null || bhVar.aeP() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return k.TYPE;
        }
        if (this.bJb) {
            return k.eGb;
        }
        if (this.eGv) {
            return bJC;
        }
        if (this.bJg) {
            return k.eGi;
        }
        if (this.bJh) {
            return k.eGh;
        }
        if (this.eGm) {
            return k.eGg;
        }
        return bJC;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acy() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aem() != 5) {
            this.threadData.hh(1);
        }
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acz() {
        if (this.threadData == null) {
            return null;
        }
        return this.threadData.bLz;
    }

    public an vE(String str) {
        an anVar = new an(str);
        if (this.threadData != null) {
            anVar.l("fid", this.threadData.getFid());
            anVar.bT("tid", this.threadData.getTid());
            anVar.P("obj_type", 2);
            anVar.P("obj_param1", baf() ? 2 : 1);
            if (this.threadData.aey() != null) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aey().getUserId());
            }
        }
        return anVar;
    }

    public an bal() {
        an W = W(eGq, true);
        if (W != null && acy() != null) {
            bh acy = acy();
            W.P("obj_name", acy.afW() != null && (acy.afW().cpN() != null || acy.afW().ayW() != null) ? 1 : 0);
            if (acy.aey() != null) {
                W.P("ab_type", acy.aey().hadConcerned() ? 1 : 0);
            }
        }
        return W;
    }

    public an b(bh bhVar, int i) {
        if (bhVar.afI() != null && bhVar.afI().channelId > 0) {
            return W(eGr, true);
        }
        an W = W(eFW, true);
        if (W != null && i != -1) {
            W.P("click_locate", i);
            return W;
        }
        return W;
    }

    public an Y(bh bhVar) {
        return b(bhVar, -1);
    }

    public an bas() {
        return W(eGt, true);
    }

    public an ban() {
        return W(eFY, true);
    }

    public an Z(bh bhVar) {
        return (bhVar.afI() == null || bhVar.afI().channelId <= 0) ? W(eFX, true) : W(eGs, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.threadData == null || this.threadData.aeP() == null || this.threadData.aeP().video_url == null) {
            return null;
        }
        return this.threadData.aeP().video_url;
    }
}
