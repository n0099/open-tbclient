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
    public static String eHs = "";
    public static String eHt = "";
    public static String eHu = "";
    public static String eHv = "";
    public static String eHw = "";
    public static String eHx = "";
    public static String eHy = "";
    public static String eHz = "";
    public static String eHA = "";
    public static String eHB = "";
    public static String eHC = "";
    public static String eHD = "";
    public static String eHE = "";
    public static String eHF = "";
    public static String eHG = "";
    public static String eHH = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId eHI = BdUniqueId.gen();
    public static final BdUniqueId bJY = BdUniqueId.gen();
    public static final BdUniqueId bKe = BdUniqueId.gen();
    public static final BdUniqueId eHJ = BdUniqueId.gen();
    public static final BdUniqueId eHK = BdUniqueId.gen();
    public static final BdUniqueId eHL = BdUniqueId.gen();
    public static final BdUniqueId eHM = BdUniqueId.gen();
    public static final BdUniqueId eHN = BdUniqueId.gen();
    public static final BdUniqueId eHO = BdUniqueId.gen();
    public static final BdUniqueId eHP = BdUniqueId.gen();
    public static final BdUniqueId eHQ = BdUniqueId.gen();
    public static final BdUniqueId eHR = BdUniqueId.gen();
    public static final BdUniqueId bKi = BdUniqueId.gen();
    public static final BdUniqueId bKj = BdUniqueId.gen();
    public boolean eHS = false;
    public boolean isLinkThread = false;
    public boolean eHT = false;
    public boolean bJz = false;
    public boolean bJA = false;
    public boolean eHU = false;
    public boolean bJD = false;
    public boolean bJE = false;
    public boolean bJF = false;
    public boolean eHV = false;
    public boolean bJI = false;
    public boolean eHW = false;
    public boolean cuq = true;

    public static boolean X(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.bJM || bhVar.getType() == bh.bJZ || bhVar.getType() == bh.bJY || bhVar.getType() == bh.bKe || bhVar.getType() == bh.bKg;
    }

    public static boolean Y(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.bKi || bhVar.getType() == bh.bKj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.threadData.threadType == 63) {
            return bKi;
        }
        if (this.threadData.threadType == 64) {
            return bKj;
        }
        if (this.bJz) {
            return eHK;
        }
        if (this.bJA) {
            return eHL;
        }
        if (this.eHU) {
            return eHN;
        }
        if (this.bJD) {
            return eHO;
        }
        if (this.bJE) {
            return eHR;
        }
        if (this.bJF) {
            return eHQ;
        }
        if (this.eHV) {
            return eHP;
        }
        if (this.threadData.isShareThread) {
            return bKe;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acC() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.aeq() == 5) {
            return this.threadData;
        }
        this.threadData.hi(1);
        return this.threadData;
    }

    public boolean baN() {
        return (this.threadData == null || v.Z(this.threadData.aeQ()) == 0) ? false : true;
    }

    public boolean baO() {
        return this.threadData == null || this.threadData.afx();
    }

    public boolean afw() {
        return this.threadData != null && this.threadData.afw();
    }

    public an baP() {
        SmartApp afo;
        if (baN()) {
            an wb = wb(eHx);
            if (wb != null) {
                wb.setPosition(this.position);
                if (acC() != null) {
                    bh acC = acC();
                    wb.P("obj_name", acC.aga() != null && (acC.aga().cqB() != null || acC.aga().azi() != null) ? 1 : 0);
                    if (acC.aeC() != null) {
                        wb.P("ab_type", acC.aeC().hadConcerned() ? 1 : 0);
                    }
                    wb.P("is_full", acC.agr() ? 1 : 0);
                }
            }
            return wb;
        } else if (baO()) {
            an wb2 = wb(eHD);
            if (wb2 != null) {
                wb2.setPosition(this.position);
                if (acC() != null && (afo = acC().afo()) != null) {
                    wb2.bT("obj_type", afo.id);
                    wb2.bT("obj_name", afo.name);
                    return wb2;
                }
                return wb2;
            }
            return wb2;
        } else if (afw()) {
            return null;
        } else {
            an wb3 = wb(eHs);
            if (wb3 != null) {
                wb3.setPosition(this.position);
                wb3.bT("ab_tag", baE()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (acC() != null) {
                    bh acC2 = acC();
                    boolean z = (acC2.aga() == null || (acC2.aga().cqB() == null && acC2.aga().azi() == null)) ? false : true;
                    wb3.P("obj_name", z ? 1 : 0);
                    if (z && acC2.aga().cqB() != null && acC2.aga().cqB().ayZ() != null && acC2.aga().cqB().ayZ().size() > 0) {
                        wb3.P("obj_to", acC2.aga().jjh ? 2 : 1);
                    }
                    if (acC2.aeC() != null) {
                        wb3.P("ab_type", acC2.aeC().hadConcerned() ? 1 : 0);
                    }
                    wb3.P("is_full", acC2.agr() ? 1 : 0);
                }
            }
            return wb3;
        }
    }

    public an wd(String str) {
        int i;
        an anVar = new an(str);
        if (this.threadData != null) {
            anVar.n("fid", this.threadData.getFid());
            anVar.bT("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            anVar.P("obj_type", i);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aeC().getUserId());
            anVar.P("obj_param1", baJ() ? 2 : 1);
        }
        return anVar;
    }

    public an we(String str) {
        an wb = wb(str);
        if (wb != null) {
            wb.bT("ab_tag", baE()).bT("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (acC() != null) {
                bh acC = acC();
                boolean z = (acC.aga() == null || (acC.aga().cqB() == null && acC.aga().azi() == null)) ? false : true;
                wb.P("obj_name", z ? 1 : 0);
                if (z && acC.aga().cqB() != null && acC.aga().cqB().ayZ() != null && acC.aga().cqB().ayZ().size() > 0) {
                    wb.P("obj_to", acC.aga().jjh ? 2 : 1);
                }
            }
        }
        return wb;
    }

    public an baQ() {
        an wb;
        SmartApp afo;
        if (baN()) {
            wb = wb(eHy);
        } else if (baO()) {
            an wb2 = wb(eHE);
            if (wb2 != null && acC() != null && (afo = acC().afo()) != null) {
                wb2.bT("obj_type", afo.id);
                wb2.bT("obj_name", afo.name);
                return wb2;
            }
            return wb2;
        } else {
            wb = wb(eHt);
            if (wb != null) {
                wb.bT("ab_tag", baE()).bT("ab_action", "click");
            }
        }
        if (wb != null && acC() != null) {
            wb.P("is_full", acC().agr() ? 1 : 0);
        }
        return wb;
    }

    public an baR() {
        if (baN()) {
            return wb(eHz);
        }
        if (l.X(this.threadData)) {
            return W(eHH, true);
        }
        an au = au(eHu, 0);
        if (au != null) {
            au.bT("ab_tag", baE()).bT("ab_action", "click");
            return au;
        }
        return au;
    }

    public an baS() {
        if (l.X(this.threadData)) {
            return W(eHG, true);
        }
        if (baN()) {
            return wb(eHA);
        }
        an wb = wb(eHv);
        if (wb != null) {
            wb.bT("ab_tag", baE()).bT("ab_action", "click");
            return wb;
        }
        return wb;
    }

    public an baT() {
        if (baN()) {
            return wb(eHB);
        }
        an wb = wb(eHw);
        if (wb != null) {
            wb.bT("ab_tag", baE()).bT("ab_action", "click");
            return wb;
        }
        return wb;
    }

    public an baU() {
        return wb(eHC);
    }

    public an baV() {
        return W(eHF, true);
    }

    public an wf(String str) {
        an wb = wb(str);
        if (this.threadData != null && this.threadData.aeC() != null) {
            wb.P("ab_type", this.threadData.aeC().hadConcerned() ? 1 : 0);
        }
        return wb;
    }

    public an wg(String str) {
        return wb(str);
    }
}
