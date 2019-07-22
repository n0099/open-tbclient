package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId bJx = BdUniqueId.gen();
    public static final BdUniqueId eGh = BdUniqueId.gen();
    public static final BdUniqueId eGi = BdUniqueId.gen();
    public static String eFQ = "";
    public static String eFR = "";
    public static String eGj = "";
    public static String eFP = "";
    public static String eGk = "";
    public static String eGl = "";
    public static String eGm = "";
    public boolean eGg = false;
    public boolean eGn = true;
    public boolean bIW = false;
    public boolean eGo = false;
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean eGf = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.threadData = bgVar;
    }

    public static boolean V(bg bgVar) {
        return (bgVar == null || bgVar.aeO() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return k.TYPE;
        }
        if (this.bIW) {
            return k.eFU;
        }
        if (this.eGo) {
            return bJx;
        }
        if (this.bJb) {
            return k.eGb;
        }
        if (this.bJc) {
            return k.eGa;
        }
        if (this.eGf) {
            return k.eFZ;
        }
        return bJx;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg acx() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.ael() != 5) {
            this.threadData.hh(1);
        }
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acy() {
        if (this.threadData == null) {
            return null;
        }
        return this.threadData.bLu;
    }

    public an vD(String str) {
        an anVar = new an(str);
        if (this.threadData != null) {
            anVar.l("fid", this.threadData.getFid());
            anVar.bT("tid", this.threadData.getTid());
            anVar.P("obj_type", 2);
            anVar.P("obj_param1", bad() ? 2 : 1);
            if (this.threadData.aex() != null) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aex().getUserId());
            }
        }
        return anVar;
    }

    public an baj() {
        an W = W(eGj, true);
        if (W != null && acx() != null) {
            bg acx = acx();
            W.P("obj_name", acx.afV() != null && (acx.afV().cpr() != null || acx.afV().ayU() != null) ? 1 : 0);
            if (acx.aex() != null) {
                W.P("ab_type", acx.aex().hadConcerned() ? 1 : 0);
            }
        }
        return W;
    }

    public an b(bg bgVar, int i) {
        if (bgVar.afH() != null && bgVar.afH().channelId > 0) {
            return W(eGk, true);
        }
        an W = W(eFP, true);
        if (W != null && i != -1) {
            W.P("click_locate", i);
            return W;
        }
        return W;
    }

    public an X(bg bgVar) {
        return b(bgVar, -1);
    }

    public an baq() {
        return W(eGm, true);
    }

    public an bal() {
        return W(eFR, true);
    }

    public an Y(bg bgVar) {
        return (bgVar.afH() == null || bgVar.afH().channelId <= 0) ? W(eFQ, true) : W(eGl, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.threadData == null || this.threadData.aeO() == null || this.threadData.aeO().video_url == null) {
            return null;
        }
        return this.threadData.aeO().video_url;
    }
}
