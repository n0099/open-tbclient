package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public static String ePg = "";
    public static String ePh = "";
    public static String ePi = "";
    public static String ePj = "";
    public static String ePk = "";
    public static String ePl = "";
    public static String ePm = "";
    public static String ePn = "";
    public static String ePo = "";
    public static String ePp = "";
    public static String ePq = "";
    public static String ePr = "";
    public static String ePs = "";
    public static String ePt = "";
    public static String ePu = "";
    public static String ePv = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ePw = BdUniqueId.gen();
    public static final BdUniqueId caP = BdUniqueId.gen();
    public static final BdUniqueId caV = BdUniqueId.gen();
    public static final BdUniqueId ePx = BdUniqueId.gen();
    public static final BdUniqueId ePy = BdUniqueId.gen();
    public static final BdUniqueId ePz = BdUniqueId.gen();
    public static final BdUniqueId ePA = BdUniqueId.gen();
    public static final BdUniqueId ePB = BdUniqueId.gen();
    public static final BdUniqueId ePC = BdUniqueId.gen();
    public static final BdUniqueId ePD = BdUniqueId.gen();
    public static final BdUniqueId ePE = BdUniqueId.gen();
    public static final BdUniqueId ePF = BdUniqueId.gen();
    public static final BdUniqueId caZ = BdUniqueId.gen();
    public static final BdUniqueId cba = BdUniqueId.gen();
    public boolean ePG = false;
    public boolean isLinkThread = false;
    public boolean ePH = false;
    public boolean cap = false;
    public boolean caq = false;
    public boolean ePI = false;
    public boolean cat = false;
    public boolean cau = false;
    public boolean cav = false;
    public boolean ePJ = false;
    public boolean cay = false;
    public boolean ePK = false;
    public boolean cFI = true;

    public static boolean V(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.caD || bhVar.getType() == bh.caQ || bhVar.getType() == bh.caP || bhVar.getType() == bh.caV || bhVar.getType() == bh.caX;
    }

    public static boolean W(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.caZ || bhVar.getType() == bh.cba;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.caz == null) {
            return TYPE;
        }
        if (this.caz.threadType == 63) {
            return caZ;
        }
        if (this.caz.threadType == 64) {
            return cba;
        }
        if (this.cap) {
            return ePy;
        }
        if (this.caq) {
            return ePz;
        }
        if (this.ePI) {
            return ePB;
        }
        if (this.cat) {
            return ePC;
        }
        if (this.cau) {
            return ePF;
        }
        if (this.cav) {
            return ePE;
        }
        if (this.ePJ) {
            return ePD;
        }
        if (this.caz.isShareThread) {
            return caV;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agG() {
        if (this.caz == null) {
            return this.caz;
        }
        if (this.caz.ais() == 5) {
            return this.caz;
        }
        this.caz.hG(1);
        return this.caz;
    }

    public boolean baN() {
        return (this.caz == null || v.getCount(this.caz.aiS()) == 0) ? false : true;
    }

    public boolean baO() {
        return this.caz == null || this.caz.ajz();
    }

    public boolean ajy() {
        return this.caz != null && this.caz.ajy();
    }

    public an baP() {
        SmartApp ajq;
        if (baN()) {
            an uD = uD(ePl);
            if (uD != null) {
                uD.setPosition(this.position);
                if (agG() != null) {
                    bh agG = agG();
                    uD.O("obj_name", agG.akb() != null && (agG.akb().cop() != null || agG.akb().azp() != null) ? 1 : 0);
                    if (agG.aiE() != null) {
                        uD.O(TiebaInitialize.Params.AB_TYPE, agG.aiE().hadConcerned() ? 1 : 0);
                    }
                    uD.O("is_full", agG.aks() ? 1 : 0);
                }
            }
            return uD;
        } else if (baO()) {
            an uD2 = uD(ePr);
            if (uD2 != null) {
                uD2.setPosition(this.position);
                if (agG() != null && (ajq = agG().ajq()) != null) {
                    uD2.bS("obj_type", ajq.id);
                    uD2.bS("obj_name", ajq.name);
                    return uD2;
                }
                return uD2;
            }
            return uD2;
        } else if (ajy()) {
            return null;
        } else {
            an uD3 = uD(ePg);
            if (uD3 != null) {
                uD3.setPosition(this.position);
                uD3.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "show");
                if (agG() != null) {
                    bh agG2 = agG();
                    boolean z = (agG2.akb() == null || (agG2.akb().cop() == null && agG2.akb().azp() == null)) ? false : true;
                    uD3.O("obj_name", z ? 1 : 0);
                    if (z && agG2.akb().cop() != null && agG2.akb().cop().azf() != null && agG2.akb().cop().azf().size() > 0) {
                        uD3.O(TiebaInitialize.Params.OBJ_TO, agG2.akb().jie ? 2 : 1);
                    }
                    if (agG2.aiE() != null) {
                        uD3.O(TiebaInitialize.Params.AB_TYPE, agG2.aiE().hadConcerned() ? 1 : 0);
                    }
                    uD3.O("is_full", agG2.aks() ? 1 : 0);
                }
            }
            return uD3;
        }
    }

    public an uF(String str) {
        int i;
        an anVar = new an(str);
        if (this.caz != null) {
            anVar.p("fid", this.caz.getFid());
            anVar.bS("tid", this.caz.getTid());
            if (this.caz.isLinkThread()) {
                i = 4;
            } else {
                i = this.caz.isShareThread ? 5 : 1;
            }
            anVar.O("obj_type", i);
            anVar.bS("obj_id", this.caz.aiE().getUserId());
            anVar.O("obj_param1", baJ() ? 2 : 1);
        }
        return anVar;
    }

    public an uG(String str) {
        an uD = uD(str);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "show");
            if (agG() != null) {
                bh agG = agG();
                boolean z = (agG.akb() == null || (agG.akb().cop() == null && agG.akb().azp() == null)) ? false : true;
                uD.O("obj_name", z ? 1 : 0);
                if (z && agG.akb().cop() != null && agG.akb().cop().azf() != null && agG.akb().cop().azf().size() > 0) {
                    uD.O(TiebaInitialize.Params.OBJ_TO, agG.akb().jie ? 2 : 1);
                }
            }
        }
        return uD;
    }

    public an baQ() {
        an uD;
        SmartApp ajq;
        if (baN()) {
            uD = uD(ePm);
        } else if (baO()) {
            an uD2 = uD(ePs);
            if (uD2 != null && agG() != null && (ajq = agG().ajq()) != null) {
                uD2.bS("obj_type", ajq.id);
                uD2.bS("obj_name", ajq.name);
                return uD2;
            }
            return uD2;
        } else {
            uD = uD(ePh);
            if (uD != null) {
                uD.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            }
        }
        if (uD != null && agG() != null) {
            uD.O("is_full", agG().aks() ? 1 : 0);
        }
        return uD;
    }

    public an baR() {
        if (baN()) {
            return uD(ePn);
        }
        if (l.V(this.caz)) {
            return ab(ePv, true);
        }
        an ap = ap(ePi, 0);
        if (ap != null) {
            ap.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return ap;
        }
        return ap;
    }

    public an baS() {
        if (l.V(this.caz)) {
            return ab(ePu, true);
        }
        if (baN()) {
            return uD(ePo);
        }
        an uD = uD(ePj);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return uD;
        }
        return uD;
    }

    public an baT() {
        if (baN()) {
            return uD(ePp);
        }
        an uD = uD(ePk);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baF()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return uD;
        }
        return uD;
    }

    public an baU() {
        return uD(ePq);
    }

    public an baV() {
        return ab(ePt, true);
    }

    public an uH(String str) {
        an uD = uD(str);
        if (this.caz != null && this.caz.aiE() != null) {
            uD.O(TiebaInitialize.Params.AB_TYPE, this.caz.aiE().hadConcerned() ? 1 : 0);
        }
        return uD;
    }

    public an uI(String str) {
        return uD(str);
    }
}
