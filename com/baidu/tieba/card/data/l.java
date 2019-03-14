package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public bg cZz;
    public static final BdUniqueId bBd = BdUniqueId.gen();
    public static final BdUniqueId elJ = BdUniqueId.gen();
    public static final BdUniqueId elK = BdUniqueId.gen();
    public static String els = "";
    public static String elL = "";
    public static String elM = "";
    public static String elr = "";
    public static String elN = "";
    public static String elO = "";
    public static String elP = "";
    public boolean elI = false;
    public boolean elQ = true;
    public boolean bAF = false;
    public boolean elR = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean elG = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.cZz = bgVar;
    }

    public static boolean W(bg bgVar) {
        return (bgVar == null || bgVar.Zi() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cZz == null) {
            return k.TYPE;
        }
        if (this.bAF) {
            return k.elv;
        }
        if (this.elR) {
            return bBd;
        }
        if (this.bAK) {
            return k.elC;
        }
        if (this.bAL) {
            return k.elB;
        }
        if (this.elG) {
            return k.elA;
        }
        return bBd;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WR() {
        if (this.cZz == null) {
            return null;
        }
        if (this.cZz.YF() != 5) {
            this.cZz.setResource(1);
        }
        return this.cZz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WS() {
        if (this.cZz == null) {
            return null;
        }
        return this.cZz.bCZ;
    }

    public am tH(String str) {
        am amVar = new am(str);
        if (this.cZz != null) {
            amVar.k(ImageViewerConfig.FORUM_ID, this.cZz.getFid());
            amVar.bJ("tid", this.cZz.getTid());
            amVar.T("obj_type", 2);
            amVar.T("obj_param1", aQU() ? 2 : 1);
            if (this.cZz.YR() != null) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.cZz.YR().getUserId());
            }
        }
        return amVar;
    }

    public am aRa() {
        am S = S(elM, true);
        if (S != null && WR() != null) {
            bg WR = WR();
            S.T("obj_name", WR.aap() != null && (WR.aap().cev() != null || WR.aap().asF() != null) ? 1 : 0);
            if (WR.YR() != null) {
                S.T("ab_type", WR.YR().hadConcerned() ? 1 : 0);
            }
        }
        return S;
    }

    public am b(bg bgVar, int i) {
        if (bgVar.aab() != null && bgVar.aab().channelId > 0) {
            return S(elN, true);
        }
        am S = S(elr, true);
        if (S != null && i != -1) {
            S.T("click_locate", i);
            return S;
        }
        return S;
    }

    public am Y(bg bgVar) {
        return b(bgVar, -1);
    }

    public am aRh() {
        return S(elP, true);
    }

    public am aRc() {
        return S(elL, true);
    }

    public am Z(bg bgVar) {
        return (bgVar.aab() == null || bgVar.aab().channelId <= 0) ? S(els, true) : S(elO, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.cZz == null || this.cZz.Zi() == null || this.cZz.Zi().video_url == null) {
            return null;
        }
        return this.cZz.Zi().video_url;
    }
}
