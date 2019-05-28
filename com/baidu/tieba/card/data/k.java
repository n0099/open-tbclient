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
    public static final BdUniqueId bIu = BdUniqueId.gen();
    public static final BdUniqueId bIA = BdUniqueId.gen();
    public static final BdUniqueId eAX = BdUniqueId.gen();
    public static final BdUniqueId eAY = BdUniqueId.gen();
    public static final BdUniqueId eAZ = BdUniqueId.gen();
    public static final BdUniqueId eBa = BdUniqueId.gen();
    public static final BdUniqueId eBb = BdUniqueId.gen();
    public static final BdUniqueId eBc = BdUniqueId.gen();
    public static final BdUniqueId eBd = BdUniqueId.gen();
    public static final BdUniqueId eBe = BdUniqueId.gen();
    public static final BdUniqueId eBf = BdUniqueId.gen();
    public static final BdUniqueId bIE = BdUniqueId.gen();
    public static final BdUniqueId bIF = BdUniqueId.gen();
    public boolean eBg = false;
    public boolean isLinkThread = false;
    public boolean eBh = false;
    public boolean bHV = false;
    public boolean bHW = false;
    public boolean eBi = false;
    public boolean bHZ = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean eBj = false;
    public boolean bIe = false;
    public boolean eBk = false;
    public boolean crZ = true;

    public static boolean V(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bIi || bgVar.getType() == bg.bIv || bgVar.getType() == bg.bIu || bgVar.getType() == bg.bIA || bgVar.getType() == bg.bIC;
    }

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bIE || bgVar.getType() == bg.bIF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bIE;
        }
        if (this.threadData.threadType == 64) {
            return bIF;
        }
        if (this.bHV) {
            return eAY;
        }
        if (this.bHW) {
            return eAZ;
        }
        if (this.eBi) {
            return eBb;
        }
        if (this.bHZ) {
            return eBc;
        }
        if (this.bIa) {
            return eBf;
        }
        if (this.bIb) {
            return eBe;
        }
        if (this.eBj) {
            return eBd;
        }
        if (this.threadData.isShareThread) {
            return bIA;
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
            am uX = uX(eAL);
            if (uX != null) {
                uX.setPosition(this.position);
                if (abv() != null) {
                    bg abv = abv();
                    uX.P("obj_name", abv.aeT() != null && (abv.aeT().cmy() != null || abv.aeT().axI() != null) ? 1 : 0);
                    if (abv.adv() != null) {
                        uX.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
                    }
                    uX.P("is_full", abv.afk() ? 1 : 0);
                }
            }
            return uX;
        } else if (aYj()) {
            am uX2 = uX(eAR);
            if (uX2 != null) {
                uX2.setPosition(this.position);
                if (abv() != null && (aeh = abv().aeh()) != null) {
                    uX2.bT("obj_type", aeh.id);
                    uX2.bT("obj_name", aeh.name);
                    return uX2;
                }
                return uX2;
            }
            return uX2;
        } else if (aep()) {
            return null;
        } else {
            am uX3 = uX(eAG);
            if (uX3 != null) {
                uX3.setPosition(this.position);
                uX3.bT("ab_tag", aYa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (abv() != null) {
                    bg abv2 = abv();
                    boolean z = (abv2.aeT() == null || (abv2.aeT().cmy() == null && abv2.aeT().axI() == null)) ? false : true;
                    uX3.P("obj_name", z ? 1 : 0);
                    if (z && abv2.aeT().cmy() != null && abv2.aeT().cmy().axz() != null && abv2.aeT().cmy().axz().size() > 0) {
                        uX3.P("obj_to", abv2.aeT().iZj ? 2 : 1);
                    }
                    if (abv2.adv() != null) {
                        uX3.P("ab_type", abv2.adv().hadConcerned() ? 1 : 0);
                    }
                    uX3.P("is_full", abv2.afk() ? 1 : 0);
                }
            }
            return uX3;
        }
    }

    public am uZ(String str) {
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

    public am va(String str) {
        am uX = uX(str);
        if (uX != null) {
            uX.bT("ab_tag", aYa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (abv() != null) {
                bg abv = abv();
                boolean z = (abv.aeT() == null || (abv.aeT().cmy() == null && abv.aeT().axI() == null)) ? false : true;
                uX.P("obj_name", z ? 1 : 0);
                if (z && abv.aeT().cmy() != null && abv.aeT().cmy().axz() != null && abv.aeT().cmy().axz().size() > 0) {
                    uX.P("obj_to", abv.aeT().iZj ? 2 : 1);
                }
            }
        }
        return uX;
    }

    public am aYl() {
        am uX;
        SmartApp aeh;
        if (aYi()) {
            uX = uX(eAM);
        } else if (aYj()) {
            am uX2 = uX(eAS);
            if (uX2 != null && abv() != null && (aeh = abv().aeh()) != null) {
                uX2.bT("obj_type", aeh.id);
                uX2.bT("obj_name", aeh.name);
                return uX2;
            }
            return uX2;
        } else {
            uX = uX(eAH);
            if (uX != null) {
                uX.bT("ab_tag", aYa()).bT("ab_action", "click");
            }
        }
        if (uX != null && abv() != null) {
            uX.P("is_full", abv().afk() ? 1 : 0);
        }
        return uX;
    }

    public am aYm() {
        if (aYi()) {
            return uX(eAN);
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
            return uX(eAO);
        }
        am uX = uX(eAJ);
        if (uX != null) {
            uX.bT("ab_tag", aYa()).bT("ab_action", "click");
            return uX;
        }
        return uX;
    }

    public am aYo() {
        if (aYi()) {
            return uX(eAP);
        }
        am uX = uX(eAK);
        if (uX != null) {
            uX.bT("ab_tag", aYa()).bT("ab_action", "click");
            return uX;
        }
        return uX;
    }

    public am aYp() {
        return uX(eAQ);
    }

    public am aYq() {
        return U(eAT, true);
    }

    public am vb(String str) {
        am uX = uX(str);
        if (this.threadData != null && this.threadData.adv() != null) {
            uX.P("ab_type", this.threadData.adv().hadConcerned() ? 1 : 0);
        }
        return uX;
    }

    public am vc(String str) {
        return uX(str);
    }
}
