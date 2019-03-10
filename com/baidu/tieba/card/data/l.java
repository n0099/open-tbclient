package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public bg cZD;
    public static final BdUniqueId bBb = BdUniqueId.gen();
    public static final BdUniqueId elN = BdUniqueId.gen();
    public static final BdUniqueId elO = BdUniqueId.gen();
    public static String elw = "";
    public static String elP = "";
    public static String elQ = "";
    public static String elv = "";
    public static String elR = "";
    public static String elS = "";
    public static String elT = "";
    public boolean elM = false;
    public boolean elU = true;
    public boolean bAD = false;
    public boolean elV = false;
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean elK = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.cZD = bgVar;
    }

    public static boolean W(bg bgVar) {
        return (bgVar == null || bgVar.Zi() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cZD == null) {
            return k.TYPE;
        }
        if (this.bAD) {
            return k.elz;
        }
        if (this.elV) {
            return bBb;
        }
        if (this.bAI) {
            return k.elG;
        }
        if (this.bAJ) {
            return k.elF;
        }
        if (this.elK) {
            return k.elE;
        }
        return bBb;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WR() {
        if (this.cZD == null) {
            return null;
        }
        if (this.cZD.YF() != 5) {
            this.cZD.setResource(1);
        }
        return this.cZD;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WS() {
        if (this.cZD == null) {
            return null;
        }
        return this.cZD.bCX;
    }

    public am tJ(String str) {
        am amVar = new am(str);
        if (this.cZD != null) {
            amVar.k(ImageViewerConfig.FORUM_ID, this.cZD.getFid());
            amVar.bJ("tid", this.cZD.getTid());
            amVar.T("obj_type", 2);
            amVar.T("obj_param1", aQV() ? 2 : 1);
            if (this.cZD.YR() != null) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.cZD.YR().getUserId());
            }
        }
        return amVar;
    }

    public am aRb() {
        am S = S(elQ, true);
        if (S != null && WR() != null) {
            bg WR = WR();
            S.T("obj_name", WR.aap() != null && (WR.aap().cet() != null || WR.aap().asG() != null) ? 1 : 0);
            if (WR.YR() != null) {
                S.T("ab_type", WR.YR().hadConcerned() ? 1 : 0);
            }
        }
        return S;
    }

    public am b(bg bgVar, int i) {
        if (bgVar.aab() != null && bgVar.aab().channelId > 0) {
            return S(elR, true);
        }
        am S = S(elv, true);
        if (S != null && i != -1) {
            S.T("click_locate", i);
            return S;
        }
        return S;
    }

    public am Y(bg bgVar) {
        return b(bgVar, -1);
    }

    public am aRi() {
        return S(elT, true);
    }

    public am aRd() {
        return S(elP, true);
    }

    public am Z(bg bgVar) {
        return (bgVar.aab() == null || bgVar.aab().channelId <= 0) ? S(elw, true) : S(elS, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.cZD == null || this.cZD.Zi() == null || this.cZD.Zi().video_url == null) {
            return null;
        }
        return this.cZD.Zi().video_url;
    }
}
