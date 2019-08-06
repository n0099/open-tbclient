package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public static String eFJ = "";
    public static String eFK = "";
    public static String eFL = "";
    public static String eFM = "";
    public static String eFN = "";
    public static String eFO = "";
    public static String eFP = "";
    public static String eFQ = "";
    public static String eFR = "";
    public static String eFS = "";
    public static String eFT = "";
    public static String eFU = "";
    public static String eFV = "";
    public static String eFW = "";
    public static String eFX = "";
    public static String eFY = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId eFZ = BdUniqueId.gen();
    public static final BdUniqueId bJA = BdUniqueId.gen();
    public static final BdUniqueId bJG = BdUniqueId.gen();
    public static final BdUniqueId eGa = BdUniqueId.gen();
    public static final BdUniqueId eGb = BdUniqueId.gen();
    public static final BdUniqueId eGc = BdUniqueId.gen();
    public static final BdUniqueId eGd = BdUniqueId.gen();
    public static final BdUniqueId eGe = BdUniqueId.gen();
    public static final BdUniqueId eGf = BdUniqueId.gen();
    public static final BdUniqueId eGg = BdUniqueId.gen();
    public static final BdUniqueId eGh = BdUniqueId.gen();
    public static final BdUniqueId eGi = BdUniqueId.gen();
    public static final BdUniqueId bJK = BdUniqueId.gen();
    public static final BdUniqueId bJL = BdUniqueId.gen();
    public boolean eGj = false;
    public boolean isLinkThread = false;
    public boolean eGk = false;
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean eGl = false;
    public boolean bJf = false;
    public boolean bJg = false;
    public boolean bJh = false;
    public boolean eGm = false;
    public boolean bJk = false;
    public boolean eGn = false;
    public boolean ctu = true;

    public static boolean W(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.bJo || bhVar.getType() == bh.bJB || bhVar.getType() == bh.bJA || bhVar.getType() == bh.bJG || bhVar.getType() == bh.bJI;
    }

    public static boolean X(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.bJK || bhVar.getType() == bh.bJL;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bJK;
        }
        if (this.threadData.threadType == 64) {
            return bJL;
        }
        if (this.bJb) {
            return eGb;
        }
        if (this.bJc) {
            return eGc;
        }
        if (this.eGl) {
            return eGe;
        }
        if (this.bJf) {
            return eGf;
        }
        if (this.bJg) {
            return eGi;
        }
        if (this.bJh) {
            return eGh;
        }
        if (this.eGm) {
            return eGg;
        }
        if (this.threadData.isShareThread) {
            return bJG;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acy() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.aem() == 5) {
            return this.threadData;
        }
        this.threadData.hh(1);
        return this.threadData;
    }

    public boolean baj() {
        return (this.threadData == null || v.Z(this.threadData.aeM()) == 0) ? false : true;
    }

    public boolean bak() {
        return this.threadData == null || this.threadData.aft();
    }

    public boolean afs() {
        return this.threadData != null && this.threadData.afs();
    }

    public an bal() {
        SmartApp afk;
        if (baj()) {
            an vC = vC(eFO);
            if (vC != null) {
                vC.setPosition(this.position);
                if (acy() != null) {
                    bh acy = acy();
                    vC.P("obj_name", acy.afW() != null && (acy.afW().cpN() != null || acy.afW().ayW() != null) ? 1 : 0);
                    if (acy.aey() != null) {
                        vC.P("ab_type", acy.aey().hadConcerned() ? 1 : 0);
                    }
                    vC.P("is_full", acy.agn() ? 1 : 0);
                }
            }
            return vC;
        } else if (bak()) {
            an vC2 = vC(eFU);
            if (vC2 != null) {
                vC2.setPosition(this.position);
                if (acy() != null && (afk = acy().afk()) != null) {
                    vC2.bT("obj_type", afk.id);
                    vC2.bT("obj_name", afk.name);
                    return vC2;
                }
                return vC2;
            }
            return vC2;
        } else if (afs()) {
            return null;
        } else {
            an vC3 = vC(eFJ);
            if (vC3 != null) {
                vC3.setPosition(this.position);
                vC3.bT("ab_tag", baa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (acy() != null) {
                    bh acy2 = acy();
                    boolean z = (acy2.afW() == null || (acy2.afW().cpN() == null && acy2.afW().ayW() == null)) ? false : true;
                    vC3.P("obj_name", z ? 1 : 0);
                    if (z && acy2.afW().cpN() != null && acy2.afW().cpN().ayN() != null && acy2.afW().cpN().ayN().size() > 0) {
                        vC3.P("obj_to", acy2.afW().jgL ? 2 : 1);
                    }
                    if (acy2.aey() != null) {
                        vC3.P("ab_type", acy2.aey().hadConcerned() ? 1 : 0);
                    }
                    vC3.P("is_full", acy2.agn() ? 1 : 0);
                }
            }
            return vC3;
        }
    }

    public an vE(String str) {
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
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aey().getUserId());
            anVar.P("obj_param1", baf() ? 2 : 1);
        }
        return anVar;
    }

    public an vF(String str) {
        an vC = vC(str);
        if (vC != null) {
            vC.bT("ab_tag", baa()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (acy() != null) {
                bh acy = acy();
                boolean z = (acy.afW() == null || (acy.afW().cpN() == null && acy.afW().ayW() == null)) ? false : true;
                vC.P("obj_name", z ? 1 : 0);
                if (z && acy.afW().cpN() != null && acy.afW().cpN().ayN() != null && acy.afW().cpN().ayN().size() > 0) {
                    vC.P("obj_to", acy.afW().jgL ? 2 : 1);
                }
            }
        }
        return vC;
    }

    public an bam() {
        an vC;
        SmartApp afk;
        if (baj()) {
            vC = vC(eFP);
        } else if (bak()) {
            an vC2 = vC(eFV);
            if (vC2 != null && acy() != null && (afk = acy().afk()) != null) {
                vC2.bT("obj_type", afk.id);
                vC2.bT("obj_name", afk.name);
                return vC2;
            }
            return vC2;
        } else {
            vC = vC(eFK);
            if (vC != null) {
                vC.bT("ab_tag", baa()).bT("ab_action", "click");
            }
        }
        if (vC != null && acy() != null) {
            vC.P("is_full", acy().agn() ? 1 : 0);
        }
        return vC;
    }

    public an ban() {
        if (baj()) {
            return vC(eFQ);
        }
        if (l.W(this.threadData)) {
            return W(eFY, true);
        }
        an as = as(eFL, 0);
        if (as != null) {
            as.bT("ab_tag", baa()).bT("ab_action", "click");
            return as;
        }
        return as;
    }

    public an bao() {
        if (l.W(this.threadData)) {
            return W(eFX, true);
        }
        if (baj()) {
            return vC(eFR);
        }
        an vC = vC(eFM);
        if (vC != null) {
            vC.bT("ab_tag", baa()).bT("ab_action", "click");
            return vC;
        }
        return vC;
    }

    public an bap() {
        if (baj()) {
            return vC(eFS);
        }
        an vC = vC(eFN);
        if (vC != null) {
            vC.bT("ab_tag", baa()).bT("ab_action", "click");
            return vC;
        }
        return vC;
    }

    public an baq() {
        return vC(eFT);
    }

    public an bar() {
        return W(eFW, true);
    }

    public an vG(String str) {
        an vC = vC(str);
        if (this.threadData != null && this.threadData.aey() != null) {
            vC.P("ab_type", this.threadData.aey().hadConcerned() ? 1 : 0);
        }
        return vC;
    }

    public an vH(String str) {
        return vC(str);
    }
}
