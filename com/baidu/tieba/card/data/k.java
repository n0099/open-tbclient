package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public static String eAG = "";
    public static String eAH = "";
    public static String eAI = "";
    public static String eAJ = "";
    public static String eAK = "";
    public static String eAL = "";
    public static String eAM = "";
    public static String eAN = "";
    public static String eAO = "";
    public static String eAP = "";
    public static String eAQ = "";
    public static String eAR = "";
    public static String eAS = "";
    public static String eAT = "";
    public static String eAU = "";
    public static String eAV = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId eAW = BdUniqueId.gen();
    public static final BdUniqueId bIv = BdUniqueId.gen();
    public static final BdUniqueId bIB = BdUniqueId.gen();
    public static final BdUniqueId eAX = BdUniqueId.gen();
    public static final BdUniqueId eAY = BdUniqueId.gen();
    public static final BdUniqueId eAZ = BdUniqueId.gen();
    public static final BdUniqueId eBa = BdUniqueId.gen();
    public static final BdUniqueId eBb = BdUniqueId.gen();
    public static final BdUniqueId eBc = BdUniqueId.gen();
    public static final BdUniqueId eBd = BdUniqueId.gen();
    public static final BdUniqueId eBe = BdUniqueId.gen();
    public static final BdUniqueId eBf = BdUniqueId.gen();
    public static final BdUniqueId bIF = BdUniqueId.gen();
    public static final BdUniqueId bIG = BdUniqueId.gen();
    public boolean eBg = false;
    public boolean isLinkThread = false;
    public boolean eBh = false;
    public boolean bHW = false;
    public boolean bHX = false;
    public boolean eBi = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean bIc = false;
    public boolean eBj = false;
    public boolean bIf = false;
    public boolean eBk = false;
    public boolean csa = true;

    public static boolean V(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bIj || bgVar.getType() == bg.bIw || bgVar.getType() == bg.bIv || bgVar.getType() == bg.bIB || bgVar.getType() == bg.bID;
    }

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bIF || bgVar.getType() == bg.bIG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bIF;
        }
        if (this.threadData.threadType == 64) {
            return bIG;
        }
        if (this.bHW) {
            return eAY;
        }
        if (this.bHX) {
            return eAZ;
        }
        if (this.eBi) {
            return eBb;
        }
        if (this.bIa) {
            return eBc;
        }
        if (this.bIb) {
            return eBf;
        }
        if (this.bIc) {
            return eBe;
        }
        if (this.eBj) {
            return eBd;
        }
        if (this.threadData.isShareThread) {
            return bIB;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg abv() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.adj() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aYi() {
        return (this.threadData == null || v.Z(this.threadData.adJ()) == 0) ? false : true;
    }

    public boolean aYj() {
        return this.threadData == null || this.threadData.aeq();
    }

    public boolean aep() {
        return this.threadData != null && this.threadData.aep();
    }

    public am aYk() {
        SmartApp aeh;
        if (aYi()) {
            am uW = uW(eAL);
            if (uW != null) {
                uW.setPosition(this.position);
                if (abv() != null) {
                    bg abv = abv();
                    uW.P("obj_name", abv.aeT() != null && (abv.aeT().cmz() != null || abv.aeT().axI() != null) ? 1 : 0);
                    if (abv.adv() != null) {
                        uW.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
                    }
                    uW.P("is_full", abv.afk() ? 1 : 0);
                }
            }
            return uW;
        } else if (aYj()) {
            am uW2 = uW(eAR);
            if (uW2 != null) {
                uW2.setPosition(this.position);
                if (abv() != null && (aeh = abv().aeh()) != null) {
                    uW2.bT("obj_type", aeh.id);
                    uW2.bT("obj_name", aeh.name);
                    return uW2;
                }
                return uW2;
            }
            return uW2;
        } else if (aep()) {
            return null;
        } else {
            am uW3 = uW(eAG);
            if (uW3 != null) {
                uW3.setPosition(this.position);
                uW3.bT("ab_tag", aYa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (abv() != null) {
                    bg abv2 = abv();
                    boolean z = (abv2.aeT() == null || (abv2.aeT().cmz() == null && abv2.aeT().axI() == null)) ? false : true;
                    uW3.P("obj_name", z ? 1 : 0);
                    if (z && abv2.aeT().cmz() != null && abv2.aeT().cmz().axz() != null && abv2.aeT().cmz().axz().size() > 0) {
                        uW3.P("obj_to", abv2.aeT().iZn ? 2 : 1);
                    }
                    if (abv2.adv() != null) {
                        uW3.P("ab_type", abv2.adv().hadConcerned() ? 1 : 0);
                    }
                    uW3.P("is_full", abv2.afk() ? 1 : 0);
                }
            }
            return uW3;
        }
    }

    public am uY(String str) {
        int i;
        am amVar = new am(str);
        if (this.threadData != null) {
            amVar.l("fid", this.threadData.getFid());
            amVar.bT("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.P("obj_type", i);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.adv().getUserId());
            amVar.P("obj_param1", aYe() ? 2 : 1);
        }
        return amVar;
    }

    public am uZ(String str) {
        am uW = uW(str);
        if (uW != null) {
            uW.bT("ab_tag", aYa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (abv() != null) {
                bg abv = abv();
                boolean z = (abv.aeT() == null || (abv.aeT().cmz() == null && abv.aeT().axI() == null)) ? false : true;
                uW.P("obj_name", z ? 1 : 0);
                if (z && abv.aeT().cmz() != null && abv.aeT().cmz().axz() != null && abv.aeT().cmz().axz().size() > 0) {
                    uW.P("obj_to", abv.aeT().iZn ? 2 : 1);
                }
            }
        }
        return uW;
    }

    public am aYl() {
        am uW;
        SmartApp aeh;
        if (aYi()) {
            uW = uW(eAM);
        } else if (aYj()) {
            am uW2 = uW(eAS);
            if (uW2 != null && abv() != null && (aeh = abv().aeh()) != null) {
                uW2.bT("obj_type", aeh.id);
                uW2.bT("obj_name", aeh.name);
                return uW2;
            }
            return uW2;
        } else {
            uW = uW(eAH);
            if (uW != null) {
                uW.bT("ab_tag", aYa()).bT("ab_action", "click");
            }
        }
        if (uW != null && abv() != null) {
            uW.P("is_full", abv().afk() ? 1 : 0);
        }
        return uW;
    }

    public am aYm() {
        if (aYi()) {
            return uW(eAN);
        }
        if (l.V(this.threadData)) {
            return U(eAV, true);
        }
        am ar = ar(eAI, 0);
        if (ar != null) {
            ar.bT("ab_tag", aYa()).bT("ab_action", "click");
            return ar;
        }
        return ar;
    }

    public am aYn() {
        if (l.V(this.threadData)) {
            return U(eAU, true);
        }
        if (aYi()) {
            return uW(eAO);
        }
        am uW = uW(eAJ);
        if (uW != null) {
            uW.bT("ab_tag", aYa()).bT("ab_action", "click");
            return uW;
        }
        return uW;
    }

    public am aYo() {
        if (aYi()) {
            return uW(eAP);
        }
        am uW = uW(eAK);
        if (uW != null) {
            uW.bT("ab_tag", aYa()).bT("ab_action", "click");
            return uW;
        }
        return uW;
    }

    public am aYp() {
        return uW(eAQ);
    }

    public am aYq() {
        return U(eAT, true);
    }

    public am va(String str) {
        am uW = uW(str);
        if (this.threadData != null && this.threadData.adv() != null) {
            uW.P("ab_type", this.threadData.adv().hadConcerned() ? 1 : 0);
        }
        return uW;
    }

    public am vb(String str) {
        return uW(str);
    }
}
