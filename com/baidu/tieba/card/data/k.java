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
    public static String ekR = "";
    public static String ekS = "";
    public static String ekT = "";
    public static String ekU = "";
    public static String ekV = "";
    public static String ekW = "";
    public static String ekX = "";
    public static String ekY = "";
    public static String ekZ = "";
    public static String ela = "";
    public static String elb = "";
    public static String elc = "";
    public static String eld = "";
    public static String ele = "";
    public static String elf = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId elg = BdUniqueId.gen();
    public static final BdUniqueId bBf = BdUniqueId.gen();
    public static final BdUniqueId bBl = BdUniqueId.gen();
    public static final BdUniqueId elh = BdUniqueId.gen();
    public static final BdUniqueId eli = BdUniqueId.gen();
    public static final BdUniqueId elj = BdUniqueId.gen();
    public static final BdUniqueId elk = BdUniqueId.gen();
    public static final BdUniqueId ell = BdUniqueId.gen();
    public static final BdUniqueId elm = BdUniqueId.gen();
    public static final BdUniqueId eln = BdUniqueId.gen();
    public static final BdUniqueId elo = BdUniqueId.gen();
    public static final BdUniqueId elp = BdUniqueId.gen();
    public static final BdUniqueId bBp = BdUniqueId.gen();
    public static final BdUniqueId bBq = BdUniqueId.gen();
    public boolean elq = false;
    public boolean isLinkThread = false;
    public boolean elr = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean els = false;
    public boolean bAN = false;
    public boolean bAO = false;
    public boolean bAP = false;
    public boolean elt = false;
    public boolean elu = false;
    public boolean elv = false;
    public boolean cjR = true;

    public static boolean V(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bAU || bgVar.getType() == bg.bBg || bgVar.getType() == bg.bBf || bgVar.getType() == bg.bBl || bgVar.getType() == bg.bBn;
    }

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bBp || bgVar.getType() == bg.bBq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bBp;
        }
        if (this.threadData.threadType == 64) {
            return bBq;
        }
        if (this.bAJ) {
            return eli;
        }
        if (this.bAK) {
            return elj;
        }
        if (this.els) {
            return ell;
        }
        if (this.bAN) {
            return elm;
        }
        if (this.bAO) {
            return elp;
        }
        if (this.bAP) {
            return elo;
        }
        if (this.elt) {
            return eln;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg WO() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.YC() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aQW() {
        return (this.threadData == null || v.S(this.threadData.Zc()) == 0) ? false : true;
    }

    public boolean aQX() {
        return this.threadData == null || this.threadData.ZJ();
    }

    public am aQY() {
        SmartApp ZA;
        if (aQW()) {
            am tE = tE(ekW);
            if (tE != null) {
                tE.setPosition(this.position);
                if (WO() != null) {
                    bg WO = WO();
                    tE.T("obj_name", WO.aam() != null && (WO.aam().cer() != null || WO.aam().asC() != null) ? 1 : 0);
                    if (WO.YO() != null) {
                        tE.T("ab_type", WO.YO().hadConcerned() ? 1 : 0);
                    }
                    tE.T("is_full", WO.aaD() ? 1 : 0);
                }
            }
            return tE;
        } else if (aQX()) {
            am tE2 = tE(elc);
            if (tE2 != null) {
                tE2.setPosition(this.position);
                if (WO() != null && (ZA = WO().ZA()) != null) {
                    tE2.bJ("obj_type", ZA.id);
                    tE2.bJ("obj_name", ZA.name);
                    return tE2;
                }
                return tE2;
            }
            return tE2;
        } else {
            am tE3 = tE(ekR);
            if (tE3 != null) {
                tE3.setPosition(this.position);
                tE3.bJ("ab_tag", aQO()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (WO() != null) {
                    bg WO2 = WO();
                    boolean z = (WO2.aam() == null || (WO2.aam().cer() == null && WO2.aam().asC() == null)) ? false : true;
                    tE3.T("obj_name", z ? 1 : 0);
                    if (z && WO2.aam().cer() != null && WO2.aam().cer().ast() != null && WO2.aam().cer().ast().size() > 0) {
                        tE3.T("obj_to", WO2.aam().iGs ? 2 : 1);
                    }
                    if (WO2.YO() != null) {
                        tE3.T("ab_type", WO2.YO().hadConcerned() ? 1 : 0);
                    }
                    tE3.T("is_full", WO2.aaD() ? 1 : 0);
                }
            }
            return tE3;
        }
    }

    public am tG(String str) {
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
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.threadData.YO().getUserId());
            amVar.T("obj_param1", aQS() ? 2 : 1);
        }
        return amVar;
    }

    public am tH(String str) {
        am tE = tE(str);
        if (tE != null) {
            tE.bJ("ab_tag", aQO()).bJ("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (WO() != null) {
                bg WO = WO();
                boolean z = (WO.aam() == null || (WO.aam().cer() == null && WO.aam().asC() == null)) ? false : true;
                tE.T("obj_name", z ? 1 : 0);
                if (z && WO.aam().cer() != null && WO.aam().cer().ast() != null && WO.aam().cer().ast().size() > 0) {
                    tE.T("obj_to", WO.aam().iGs ? 2 : 1);
                }
            }
        }
        return tE;
    }

    public am aQZ() {
        am tE;
        SmartApp ZA;
        if (aQW()) {
            tE = tE(ekX);
        } else if (aQX()) {
            am tE2 = tE(eld);
            if (tE2 != null && WO() != null && (ZA = WO().ZA()) != null) {
                tE2.bJ("obj_type", ZA.id);
                tE2.bJ("obj_name", ZA.name);
                return tE2;
            }
            return tE2;
        } else {
            tE = tE(ekS);
            if (tE != null) {
                tE.bJ("ab_tag", aQO()).bJ("ab_action", "click");
            }
        }
        if (tE != null && WO() != null) {
            tE.T("is_full", WO().aaD() ? 1 : 0);
        }
        return tE;
    }

    public am aRa() {
        if (aQW()) {
            return tE(ekY);
        }
        am av = av(ekT, 0);
        if (av != null) {
            av.bJ("ab_tag", aQO()).bJ("ab_action", "click");
            return av;
        }
        return av;
    }

    public am aRb() {
        if (l.V(this.threadData)) {
            return S(elf, true);
        }
        if (aQW()) {
            return tE(ekZ);
        }
        am tE = tE(ekU);
        if (tE != null) {
            tE.bJ("ab_tag", aQO()).bJ("ab_action", "click");
            return tE;
        }
        return tE;
    }

    public am aRc() {
        if (aQW()) {
            return tE(ela);
        }
        am tE = tE(ekV);
        if (tE != null) {
            tE.bJ("ab_tag", aQO()).bJ("ab_action", "click");
            return tE;
        }
        return tE;
    }

    public am aRd() {
        return tE(elb);
    }

    public am aRe() {
        return S(ele, true);
    }

    public am tI(String str) {
        am tE = tE(str);
        if (this.threadData != null && this.threadData.YO() != null) {
            tE.T("ab_type", this.threadData.YO().hadConcerned() ? 1 : 0);
        }
        return tE;
    }

    public am tJ(String str) {
        return tE(str);
    }
}
