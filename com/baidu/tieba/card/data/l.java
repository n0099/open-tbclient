package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public bg cZD;
    public static final BdUniqueId bBh = BdUniqueId.gen();
    public static final BdUniqueId elw = BdUniqueId.gen();
    public static final BdUniqueId elx = BdUniqueId.gen();
    public static String elf = "";
    public static String ely = "";
    public static String elz = "";
    public static String ele = "";
    public static String elA = "";
    public static String elB = "";
    public static String elC = "";
    public boolean elv = false;
    public boolean elD = true;
    public boolean bAJ = false;
    public boolean elE = false;
    public boolean bAO = false;
    public boolean bAP = false;
    public boolean elt = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.cZD = bgVar;
    }

    public static boolean V(bg bgVar) {
        return (bgVar == null || bgVar.Zf() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cZD == null) {
            return k.TYPE;
        }
        if (this.bAJ) {
            return k.eli;
        }
        if (this.elE) {
            return bBh;
        }
        if (this.bAO) {
            return k.elp;
        }
        if (this.bAP) {
            return k.elo;
        }
        if (this.elt) {
            return k.eln;
        }
        return bBh;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WO() {
        if (this.cZD == null) {
            return null;
        }
        if (this.cZD.YC() != 5) {
            this.cZD.setResource(1);
        }
        return this.cZD;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        if (this.cZD == null) {
            return null;
        }
        return this.cZD.bDd;
    }

    public am tG(String str) {
        am amVar = new am(str);
        if (this.cZD != null) {
            amVar.k(ImageViewerConfig.FORUM_ID, this.cZD.getFid());
            amVar.bJ("tid", this.cZD.getTid());
            amVar.T("obj_type", 2);
            amVar.T("obj_param1", aQS() ? 2 : 1);
            if (this.cZD.YO() != null) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.cZD.YO().getUserId());
            }
        }
        return amVar;
    }

    public am aQY() {
        am S = S(elz, true);
        if (S != null && WO() != null) {
            bg WO = WO();
            S.T("obj_name", WO.aam() != null && (WO.aam().cer() != null || WO.aam().asC() != null) ? 1 : 0);
            if (WO.YO() != null) {
                S.T("ab_type", WO.YO().hadConcerned() ? 1 : 0);
            }
        }
        return S;
    }

    public am b(bg bgVar, int i) {
        if (bgVar.ZY() != null && bgVar.ZY().channelId > 0) {
            return S(elA, true);
        }
        am S = S(ele, true);
        if (S != null && i != -1) {
            S.T("click_locate", i);
            return S;
        }
        return S;
    }

    public am X(bg bgVar) {
        return b(bgVar, -1);
    }

    public am aRf() {
        return S(elC, true);
    }

    public am aRa() {
        return S(ely, true);
    }

    public am Y(bg bgVar) {
        return (bgVar.ZY() == null || bgVar.ZY().channelId <= 0) ? S(elf, true) : S(elB, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.cZD == null || this.cZD.Zf() == null || this.cZD.Zf().video_url == null) {
            return null;
        }
        return this.cZD.Zf().video_url;
    }
}
