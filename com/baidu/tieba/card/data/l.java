package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public bg cZC;
    public static final BdUniqueId bBg = BdUniqueId.gen();
    public static final BdUniqueId elv = BdUniqueId.gen();
    public static final BdUniqueId elw = BdUniqueId.gen();
    public static String ele = "";
    public static String elx = "";
    public static String ely = "";
    public static String eld = "";
    public static String elz = "";
    public static String elA = "";
    public static String elB = "";
    public boolean elu = false;
    public boolean elC = true;
    public boolean bAI = false;
    public boolean elD = false;
    public boolean bAN = false;
    public boolean bAO = false;
    public boolean els = false;
    public int sourceType = 0;

    public l(bg bgVar) {
        this.cZC = bgVar;
    }

    public static boolean V(bg bgVar) {
        return (bgVar == null || bgVar.Zf() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cZC == null) {
            return k.TYPE;
        }
        if (this.bAI) {
            return k.elh;
        }
        if (this.elD) {
            return bBg;
        }
        if (this.bAN) {
            return k.elo;
        }
        if (this.bAO) {
            return k.eln;
        }
        if (this.els) {
            return k.elm;
        }
        return bBg;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WO() {
        if (this.cZC == null) {
            return null;
        }
        if (this.cZC.YC() != 5) {
            this.cZC.setResource(1);
        }
        return this.cZC;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        if (this.cZC == null) {
            return null;
        }
        return this.cZC.bDc;
    }

    public am tG(String str) {
        am amVar = new am(str);
        if (this.cZC != null) {
            amVar.k(ImageViewerConfig.FORUM_ID, this.cZC.getFid());
            amVar.bJ("tid", this.cZC.getTid());
            amVar.T("obj_type", 2);
            amVar.T("obj_param1", aQS() ? 2 : 1);
            if (this.cZC.YO() != null) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.cZC.YO().getUserId());
            }
        }
        return amVar;
    }

    public am aQY() {
        am S = S(ely, true);
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
            return S(elz, true);
        }
        am S = S(eld, true);
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
        return S(elB, true);
    }

    public am aRa() {
        return S(elx, true);
    }

    public am Y(bg bgVar) {
        return (bgVar.ZY() == null || bgVar.ZY().channelId <= 0) ? S(ele, true) : S(elA, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.cZC == null || this.cZC.Zf() == null || this.cZC.Zf().video_url == null) {
            return null;
        }
        return this.cZC.Zf().video_url;
    }
}
