package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public bg threadData;
    public static String eli = "";
    public static String elj = "";
    public static String elk = "";
    public static String ell = "";
    public static String elm = "";
    public static String eln = "";
    public static String elo = "";
    public static String elp = "";
    public static String elq = "";
    public static String elr = "";
    public static String els = "";
    public static String elt = "";
    public static String elu = "";
    public static String elv = "";
    public static String elw = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId elx = BdUniqueId.gen();
    public static final BdUniqueId bAZ = BdUniqueId.gen();
    public static final BdUniqueId bBf = BdUniqueId.gen();
    public static final BdUniqueId ely = BdUniqueId.gen();
    public static final BdUniqueId elz = BdUniqueId.gen();
    public static final BdUniqueId elA = BdUniqueId.gen();
    public static final BdUniqueId elB = BdUniqueId.gen();
    public static final BdUniqueId elC = BdUniqueId.gen();
    public static final BdUniqueId elD = BdUniqueId.gen();
    public static final BdUniqueId elE = BdUniqueId.gen();
    public static final BdUniqueId elF = BdUniqueId.gen();
    public static final BdUniqueId elG = BdUniqueId.gen();
    public static final BdUniqueId bBj = BdUniqueId.gen();
    public static final BdUniqueId bBk = BdUniqueId.gen();
    public boolean elH = false;
    public boolean isLinkThread = false;
    public boolean elI = false;
    public boolean bAD = false;
    public boolean bAE = false;
    public boolean elJ = false;
    public boolean bAH = false;
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean elK = false;
    public boolean elL = false;
    public boolean elM = false;
    public boolean cjO = true;

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bAO || bgVar.getType() == bg.bBa || bgVar.getType() == bg.bAZ || bgVar.getType() == bg.bBf || bgVar.getType() == bg.bBh;
    }

    public static boolean X(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bBj || bgVar.getType() == bg.bBk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bBj;
        }
        if (this.threadData.threadType == 64) {
            return bBk;
        }
        if (this.bAD) {
            return elz;
        }
        if (this.bAE) {
            return elA;
        }
        if (this.elJ) {
            return elC;
        }
        if (this.bAH) {
            return elD;
        }
        if (this.bAI) {
            return elG;
        }
        if (this.bAJ) {
            return elF;
        }
        if (this.elK) {
            return elE;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WR() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.YF() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aQZ() {
        return (this.threadData == null || v.S(this.threadData.Zf()) == 0) ? false : true;
    }

    public boolean aRa() {
        return this.threadData == null || this.threadData.ZM();
    }

    public am aRb() {
        SmartApp ZD;
        if (aQZ()) {
            am tH = tH(eln);
            if (tH != null) {
                tH.setPosition(this.position);
                if (WR() != null) {
                    bg WR = WR();
                    tH.T("obj_name", WR.aap() != null && (WR.aap().cet() != null || WR.aap().asG() != null) ? 1 : 0);
                    if (WR.YR() != null) {
                        tH.T("ab_type", WR.YR().hadConcerned() ? 1 : 0);
                    }
                    tH.T("is_full", WR.aaG() ? 1 : 0);
                }
            }
            return tH;
        } else if (aRa()) {
            am tH2 = tH(elt);
            if (tH2 != null) {
                tH2.setPosition(this.position);
                if (WR() != null && (ZD = WR().ZD()) != null) {
                    tH2.bJ("obj_type", ZD.id);
                    tH2.bJ("obj_name", ZD.name);
                    return tH2;
                }
                return tH2;
            }
            return tH2;
        } else {
            am tH3 = tH(eli);
            if (tH3 != null) {
                tH3.setPosition(this.position);
                tH3.bJ("ab_tag", aQR()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (WR() != null) {
                    bg WR2 = WR();
                    boolean z = (WR2.aap() == null || (WR2.aap().cet() == null && WR2.aap().asG() == null)) ? false : true;
                    tH3.T("obj_name", z ? 1 : 0);
                    if (z && WR2.aap().cet() != null && WR2.aap().cet().asx() != null && WR2.aap().cet().asx().size() > 0) {
                        tH3.T("obj_to", WR2.aap().iGP ? 2 : 1);
                    }
                    if (WR2.YR() != null) {
                        tH3.T("ab_type", WR2.YR().hadConcerned() ? 1 : 0);
                    }
                    tH3.T("is_full", WR2.aaG() ? 1 : 0);
                }
            }
            return tH3;
        }
    }

    public am tJ(String str) {
        int i;
        am amVar = new am(str);
        if (this.threadData != null) {
            amVar.k(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.bJ("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.T("obj_type", i);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.threadData.YR().getUserId());
            amVar.T("obj_param1", aQV() ? 2 : 1);
        }
        return amVar;
    }

    public am tK(String str) {
        am tH = tH(str);
        if (tH != null) {
            tH.bJ("ab_tag", aQR()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (WR() != null) {
                bg WR = WR();
                boolean z = (WR.aap() == null || (WR.aap().cet() == null && WR.aap().asG() == null)) ? false : true;
                tH.T("obj_name", z ? 1 : 0);
                if (z && WR.aap().cet() != null && WR.aap().cet().asx() != null && WR.aap().cet().asx().size() > 0) {
                    tH.T("obj_to", WR.aap().iGP ? 2 : 1);
                }
            }
        }
        return tH;
    }

    public am aRc() {
        am tH;
        SmartApp ZD;
        if (aQZ()) {
            tH = tH(elo);
        } else if (aRa()) {
            am tH2 = tH(elu);
            if (tH2 != null && WR() != null && (ZD = WR().ZD()) != null) {
                tH2.bJ("obj_type", ZD.id);
                tH2.bJ("obj_name", ZD.name);
                return tH2;
            }
            return tH2;
        } else {
            tH = tH(elj);
            if (tH != null) {
                tH.bJ("ab_tag", aQR()).bJ("ab_action", "click");
            }
        }
        if (tH != null && WR() != null) {
            tH.T("is_full", WR().aaG() ? 1 : 0);
        }
        return tH;
    }

    public am aRd() {
        if (aQZ()) {
            return tH(elp);
        }
        am av = av(elk, 0);
        if (av != null) {
            av.bJ("ab_tag", aQR()).bJ("ab_action", "click");
            return av;
        }
        return av;
    }

    public am aRe() {
        if (l.W(this.threadData)) {
            return S(elw, true);
        }
        if (aQZ()) {
            return tH(elq);
        }
        am tH = tH(ell);
        if (tH != null) {
            tH.bJ("ab_tag", aQR()).bJ("ab_action", "click");
            return tH;
        }
        return tH;
    }

    public am aRf() {
        if (aQZ()) {
            return tH(elr);
        }
        am tH = tH(elm);
        if (tH != null) {
            tH.bJ("ab_tag", aQR()).bJ("ab_action", "click");
            return tH;
        }
        return tH;
    }

    public am aRg() {
        return tH(els);
    }

    public am aRh() {
        return S(elv, true);
    }

    public am tL(String str) {
        am tH = tH(str);
        if (this.threadData != null && this.threadData.YR() != null) {
            tH.T("ab_type", this.threadData.YR().hadConcerned() ? 1 : 0);
        }
        return tH;
    }

    public am tM(String str) {
        return tH(str);
    }
}
