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
    public static String ele = "";
    public static String elf = "";
    public static String elg = "";
    public static String elh = "";
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
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId elt = BdUniqueId.gen();
    public static final BdUniqueId bBb = BdUniqueId.gen();
    public static final BdUniqueId bBh = BdUniqueId.gen();
    public static final BdUniqueId elu = BdUniqueId.gen();
    public static final BdUniqueId elv = BdUniqueId.gen();
    public static final BdUniqueId elw = BdUniqueId.gen();
    public static final BdUniqueId elx = BdUniqueId.gen();
    public static final BdUniqueId ely = BdUniqueId.gen();
    public static final BdUniqueId elz = BdUniqueId.gen();
    public static final BdUniqueId elA = BdUniqueId.gen();
    public static final BdUniqueId elB = BdUniqueId.gen();
    public static final BdUniqueId elC = BdUniqueId.gen();
    public static final BdUniqueId bBl = BdUniqueId.gen();
    public static final BdUniqueId bBm = BdUniqueId.gen();
    public boolean elD = false;
    public boolean isLinkThread = false;
    public boolean elE = false;
    public boolean bAF = false;
    public boolean bAG = false;
    public boolean elF = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean elG = false;
    public boolean elH = false;
    public boolean elI = false;
    public boolean cjO = true;

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bAQ || bgVar.getType() == bg.bBc || bgVar.getType() == bg.bBb || bgVar.getType() == bg.bBh || bgVar.getType() == bg.bBj;
    }

    public static boolean X(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bBl || bgVar.getType() == bg.bBm;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bBl;
        }
        if (this.threadData.threadType == 64) {
            return bBm;
        }
        if (this.bAF) {
            return elv;
        }
        if (this.bAG) {
            return elw;
        }
        if (this.elF) {
            return ely;
        }
        if (this.bAJ) {
            return elz;
        }
        if (this.bAK) {
            return elC;
        }
        if (this.bAL) {
            return elB;
        }
        if (this.elG) {
            return elA;
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

    public boolean aQY() {
        return (this.threadData == null || v.S(this.threadData.Zf()) == 0) ? false : true;
    }

    public boolean aQZ() {
        return this.threadData == null || this.threadData.ZM();
    }

    public am aRa() {
        SmartApp ZD;
        if (aQY()) {
            am tF = tF(elj);
            if (tF != null) {
                tF.setPosition(this.position);
                if (WR() != null) {
                    bg WR = WR();
                    tF.T("obj_name", WR.aap() != null && (WR.aap().cev() != null || WR.aap().asF() != null) ? 1 : 0);
                    if (WR.YR() != null) {
                        tF.T("ab_type", WR.YR().hadConcerned() ? 1 : 0);
                    }
                    tF.T("is_full", WR.aaG() ? 1 : 0);
                }
            }
            return tF;
        } else if (aQZ()) {
            am tF2 = tF(elp);
            if (tF2 != null) {
                tF2.setPosition(this.position);
                if (WR() != null && (ZD = WR().ZD()) != null) {
                    tF2.bJ("obj_type", ZD.id);
                    tF2.bJ("obj_name", ZD.name);
                    return tF2;
                }
                return tF2;
            }
            return tF2;
        } else {
            am tF3 = tF(ele);
            if (tF3 != null) {
                tF3.setPosition(this.position);
                tF3.bJ("ab_tag", aQQ()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (WR() != null) {
                    bg WR2 = WR();
                    boolean z = (WR2.aap() == null || (WR2.aap().cev() == null && WR2.aap().asF() == null)) ? false : true;
                    tF3.T("obj_name", z ? 1 : 0);
                    if (z && WR2.aap().cev() != null && WR2.aap().cev().asw() != null && WR2.aap().cev().asw().size() > 0) {
                        tF3.T("obj_to", WR2.aap().iGH ? 2 : 1);
                    }
                    if (WR2.YR() != null) {
                        tF3.T("ab_type", WR2.YR().hadConcerned() ? 1 : 0);
                    }
                    tF3.T("is_full", WR2.aaG() ? 1 : 0);
                }
            }
            return tF3;
        }
    }

    public am tH(String str) {
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
            amVar.T("obj_param1", aQU() ? 2 : 1);
        }
        return amVar;
    }

    public am tI(String str) {
        am tF = tF(str);
        if (tF != null) {
            tF.bJ("ab_tag", aQQ()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (WR() != null) {
                bg WR = WR();
                boolean z = (WR.aap() == null || (WR.aap().cev() == null && WR.aap().asF() == null)) ? false : true;
                tF.T("obj_name", z ? 1 : 0);
                if (z && WR.aap().cev() != null && WR.aap().cev().asw() != null && WR.aap().cev().asw().size() > 0) {
                    tF.T("obj_to", WR.aap().iGH ? 2 : 1);
                }
            }
        }
        return tF;
    }

    public am aRb() {
        am tF;
        SmartApp ZD;
        if (aQY()) {
            tF = tF(elk);
        } else if (aQZ()) {
            am tF2 = tF(elq);
            if (tF2 != null && WR() != null && (ZD = WR().ZD()) != null) {
                tF2.bJ("obj_type", ZD.id);
                tF2.bJ("obj_name", ZD.name);
                return tF2;
            }
            return tF2;
        } else {
            tF = tF(elf);
            if (tF != null) {
                tF.bJ("ab_tag", aQQ()).bJ("ab_action", "click");
            }
        }
        if (tF != null && WR() != null) {
            tF.T("is_full", WR().aaG() ? 1 : 0);
        }
        return tF;
    }

    public am aRc() {
        if (aQY()) {
            return tF(ell);
        }
        am av = av(elg, 0);
        if (av != null) {
            av.bJ("ab_tag", aQQ()).bJ("ab_action", "click");
            return av;
        }
        return av;
    }

    public am aRd() {
        if (l.W(this.threadData)) {
            return S(els, true);
        }
        if (aQY()) {
            return tF(elm);
        }
        am tF = tF(elh);
        if (tF != null) {
            tF.bJ("ab_tag", aQQ()).bJ("ab_action", "click");
            return tF;
        }
        return tF;
    }

    public am aRe() {
        if (aQY()) {
            return tF(eln);
        }
        am tF = tF(eli);
        if (tF != null) {
            tF.bJ("ab_tag", aQQ()).bJ("ab_action", "click");
            return tF;
        }
        return tF;
    }

    public am aRf() {
        return tF(elo);
    }

    public am aRg() {
        return S(elr, true);
    }

    public am tJ(String str) {
        am tF = tF(str);
        if (this.threadData != null && this.threadData.YR() != null) {
            tF.T("ab_type", this.threadData.YR().hadConcerned() ? 1 : 0);
        }
        return tF;
    }

    public am tK(String str) {
        return tF(str);
    }
}
