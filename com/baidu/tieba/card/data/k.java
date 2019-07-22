package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public static String eFC = "";
    public static String eFD = "";
    public static String eFE = "";
    public static String eFF = "";
    public static String eFG = "";
    public static String eFH = "";
    public static String eFI = "";
    public static String eFJ = "";
    public static String eFK = "";
    public static String eFL = "";
    public static String eFM = "";
    public static String eFN = "";
    public static String eFO = "";
    public static String eFP = "";
    public static String eFQ = "";
    public static String eFR = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId eFS = BdUniqueId.gen();
    public static final BdUniqueId bJv = BdUniqueId.gen();
    public static final BdUniqueId bJB = BdUniqueId.gen();
    public static final BdUniqueId eFT = BdUniqueId.gen();
    public static final BdUniqueId eFU = BdUniqueId.gen();
    public static final BdUniqueId eFV = BdUniqueId.gen();
    public static final BdUniqueId eFW = BdUniqueId.gen();
    public static final BdUniqueId eFX = BdUniqueId.gen();
    public static final BdUniqueId eFY = BdUniqueId.gen();
    public static final BdUniqueId eFZ = BdUniqueId.gen();
    public static final BdUniqueId eGa = BdUniqueId.gen();
    public static final BdUniqueId eGb = BdUniqueId.gen();
    public static final BdUniqueId bJF = BdUniqueId.gen();
    public static final BdUniqueId bJG = BdUniqueId.gen();
    public boolean eGc = false;
    public boolean isLinkThread = false;
    public boolean eGd = false;
    public boolean bIW = false;
    public boolean bIX = false;
    public boolean eGe = false;
    public boolean bJa = false;
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean eGf = false;
    public boolean bJf = false;
    public boolean eGg = false;
    public boolean ctn = true;

    public static boolean V(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bJj || bgVar.getType() == bg.bJw || bgVar.getType() == bg.bJv || bgVar.getType() == bg.bJB || bgVar.getType() == bg.bJD;
    }

    public static boolean W(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.getType() == bg.bJF || bgVar.getType() == bg.bJG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bJF;
        }
        if (this.threadData.threadType == 64) {
            return bJG;
        }
        if (this.bIW) {
            return eFU;
        }
        if (this.bIX) {
            return eFV;
        }
        if (this.eGe) {
            return eFX;
        }
        if (this.bJa) {
            return eFY;
        }
        if (this.bJb) {
            return eGb;
        }
        if (this.bJc) {
            return eGa;
        }
        if (this.eGf) {
            return eFZ;
        }
        if (this.threadData.isShareThread) {
            return bJB;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg acx() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.ael() == 5) {
            return this.threadData;
        }
        this.threadData.hh(1);
        return this.threadData;
    }

    public boolean bah() {
        return (this.threadData == null || v.Z(this.threadData.aeL()) == 0) ? false : true;
    }

    public boolean bai() {
        return this.threadData == null || this.threadData.afs();
    }

    public boolean afr() {
        return this.threadData != null && this.threadData.afr();
    }

    public an baj() {
        SmartApp afj;
        if (bah()) {
            an vB = vB(eFH);
            if (vB != null) {
                vB.setPosition(this.position);
                if (acx() != null) {
                    bg acx = acx();
                    vB.P("obj_name", acx.afV() != null && (acx.afV().cpr() != null || acx.afV().ayU() != null) ? 1 : 0);
                    if (acx.aex() != null) {
                        vB.P("ab_type", acx.aex().hadConcerned() ? 1 : 0);
                    }
                    vB.P("is_full", acx.agm() ? 1 : 0);
                }
            }
            return vB;
        } else if (bai()) {
            an vB2 = vB(eFN);
            if (vB2 != null) {
                vB2.setPosition(this.position);
                if (acx() != null && (afj = acx().afj()) != null) {
                    vB2.bT("obj_type", afj.id);
                    vB2.bT("obj_name", afj.name);
                    return vB2;
                }
                return vB2;
            }
            return vB2;
        } else if (afr()) {
            return null;
        } else {
            an vB3 = vB(eFC);
            if (vB3 != null) {
                vB3.setPosition(this.position);
                vB3.bT("ab_tag", aZY()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (acx() != null) {
                    bg acx2 = acx();
                    boolean z = (acx2.afV() == null || (acx2.afV().cpr() == null && acx2.afV().ayU() == null)) ? false : true;
                    vB3.P("obj_name", z ? 1 : 0);
                    if (z && acx2.afV().cpr() != null && acx2.afV().cpr().ayL() != null && acx2.afV().cpr().ayL().size() > 0) {
                        vB3.P("obj_to", acx2.afV().jfE ? 2 : 1);
                    }
                    if (acx2.aex() != null) {
                        vB3.P("ab_type", acx2.aex().hadConcerned() ? 1 : 0);
                    }
                    vB3.P("is_full", acx2.agm() ? 1 : 0);
                }
            }
            return vB3;
        }
    }

    public an vD(String str) {
        int i;
        an anVar = new an(str);
        if (this.threadData != null) {
            anVar.l("fid", this.threadData.getFid());
            anVar.bT("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            anVar.P("obj_type", i);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aex().getUserId());
            anVar.P("obj_param1", bad() ? 2 : 1);
        }
        return anVar;
    }

    public an vE(String str) {
        an vB = vB(str);
        if (vB != null) {
            vB.bT("ab_tag", aZY()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (acx() != null) {
                bg acx = acx();
                boolean z = (acx.afV() == null || (acx.afV().cpr() == null && acx.afV().ayU() == null)) ? false : true;
                vB.P("obj_name", z ? 1 : 0);
                if (z && acx.afV().cpr() != null && acx.afV().cpr().ayL() != null && acx.afV().cpr().ayL().size() > 0) {
                    vB.P("obj_to", acx.afV().jfE ? 2 : 1);
                }
            }
        }
        return vB;
    }

    public an bak() {
        an vB;
        SmartApp afj;
        if (bah()) {
            vB = vB(eFI);
        } else if (bai()) {
            an vB2 = vB(eFO);
            if (vB2 != null && acx() != null && (afj = acx().afj()) != null) {
                vB2.bT("obj_type", afj.id);
                vB2.bT("obj_name", afj.name);
                return vB2;
            }
            return vB2;
        } else {
            vB = vB(eFD);
            if (vB != null) {
                vB.bT("ab_tag", aZY()).bT("ab_action", "click");
            }
        }
        if (vB != null && acx() != null) {
            vB.P("is_full", acx().agm() ? 1 : 0);
        }
        return vB;
    }

    public an bal() {
        if (bah()) {
            return vB(eFJ);
        }
        if (l.V(this.threadData)) {
            return W(eFR, true);
        }
        an as = as(eFE, 0);
        if (as != null) {
            as.bT("ab_tag", aZY()).bT("ab_action", "click");
            return as;
        }
        return as;
    }

    public an bam() {
        if (l.V(this.threadData)) {
            return W(eFQ, true);
        }
        if (bah()) {
            return vB(eFK);
        }
        an vB = vB(eFF);
        if (vB != null) {
            vB.bT("ab_tag", aZY()).bT("ab_action", "click");
            return vB;
        }
        return vB;
    }

    public an ban() {
        if (bah()) {
            return vB(eFL);
        }
        an vB = vB(eFG);
        if (vB != null) {
            vB.bT("ab_tag", aZY()).bT("ab_action", "click");
            return vB;
        }
        return vB;
    }

    public an bao() {
        return vB(eFM);
    }

    public an bap() {
        return W(eFP, true);
    }

    public an vF(String str) {
        an vB = vB(str);
        if (this.threadData != null && this.threadData.aex() != null) {
            vB.P("ab_type", this.threadData.aex().hadConcerned() ? 1 : 0);
        }
        return vB;
    }

    public an vG(String str) {
        return vB(str);
    }
}
