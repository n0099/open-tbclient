package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class k extends c {
    public static String ePX = "";
    public static String ePY = "";
    public static String ePZ = "";
    public static String eQa = "";
    public static String eQb = "";
    public static String eQc = "";
    public static String eQd = "";
    public static String eQe = "";
    public static String eQf = "";
    public static String eQg = "";
    public static String eQh = "";
    public static String eQi = "";
    public static String eQj = "";
    public static String eQk = "";
    public static String eQl = "";
    public static String eQm = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId eQn = BdUniqueId.gen();
    public static final BdUniqueId cbG = BdUniqueId.gen();
    public static final BdUniqueId cbM = BdUniqueId.gen();
    public static final BdUniqueId eQo = BdUniqueId.gen();
    public static final BdUniqueId eQp = BdUniqueId.gen();
    public static final BdUniqueId eQq = BdUniqueId.gen();
    public static final BdUniqueId eQr = BdUniqueId.gen();
    public static final BdUniqueId eQs = BdUniqueId.gen();
    public static final BdUniqueId eQt = BdUniqueId.gen();
    public static final BdUniqueId eQu = BdUniqueId.gen();
    public static final BdUniqueId eQv = BdUniqueId.gen();
    public static final BdUniqueId eQw = BdUniqueId.gen();
    public static final BdUniqueId cbQ = BdUniqueId.gen();
    public static final BdUniqueId cbR = BdUniqueId.gen();
    public boolean eQx = false;
    public boolean isLinkThread = false;
    public boolean eQy = false;
    public boolean cbg = false;
    public boolean cbh = false;
    public boolean eQz = false;
    public boolean cbk = false;
    public boolean cbl = false;
    public boolean cbm = false;
    public boolean eQA = false;
    public boolean cbp = false;
    public boolean eQB = false;
    public boolean cGz = true;

    public static boolean V(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.cbu || bhVar.getType() == bh.cbH || bhVar.getType() == bh.cbG || bhVar.getType() == bh.cbM || bhVar.getType() == bh.cbO;
    }

    public static boolean W(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.cbQ || bhVar.getType() == bh.cbR;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cbq == null) {
            return TYPE;
        }
        if (this.cbq.threadType == 63) {
            return cbQ;
        }
        if (this.cbq.threadType == 64) {
            return cbR;
        }
        if (this.cbg) {
            return eQp;
        }
        if (this.cbh) {
            return eQq;
        }
        if (this.eQz) {
            return eQs;
        }
        if (this.cbk) {
            return eQt;
        }
        if (this.cbl) {
            return eQw;
        }
        if (this.cbm) {
            return eQv;
        }
        if (this.eQA) {
            return eQu;
        }
        if (this.cbq.isShareThread) {
            return cbM;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agI() {
        if (this.cbq == null) {
            return this.cbq;
        }
        if (this.cbq.aiu() == 5) {
            return this.cbq;
        }
        this.cbq.hH(1);
        return this.cbq;
    }

    public boolean baP() {
        return (this.cbq == null || v.getCount(this.cbq.aiU()) == 0) ? false : true;
    }

    public boolean baQ() {
        return this.cbq == null || this.cbq.ajB();
    }

    public boolean ajA() {
        return this.cbq != null && this.cbq.ajA();
    }

    public an baR() {
        SmartApp ajs;
        if (baP()) {
            an uD = uD(eQc);
            if (uD != null) {
                uD.setPosition(this.position);
                if (agI() != null) {
                    bh agI = agI();
                    uD.O("obj_name", agI.akd() != null && (agI.akd().cor() != null || agI.akd().azr() != null) ? 1 : 0);
                    if (agI.aiG() != null) {
                        uD.O(TiebaInitialize.Params.AB_TYPE, agI.aiG().hadConcerned() ? 1 : 0);
                    }
                    uD.O("is_full", agI.aku() ? 1 : 0);
                }
            }
            return uD;
        } else if (baQ()) {
            an uD2 = uD(eQi);
            if (uD2 != null) {
                uD2.setPosition(this.position);
                if (agI() != null && (ajs = agI().ajs()) != null) {
                    uD2.bS("obj_type", ajs.id);
                    uD2.bS("obj_name", ajs.name);
                    return uD2;
                }
                return uD2;
            }
            return uD2;
        } else if (ajA()) {
            return null;
        } else {
            an uD3 = uD(ePX);
            if (uD3 != null) {
                uD3.setPosition(this.position);
                uD3.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "show");
                if (agI() != null) {
                    bh agI2 = agI();
                    boolean z = (agI2.akd() == null || (agI2.akd().cor() == null && agI2.akd().azr() == null)) ? false : true;
                    uD3.O("obj_name", z ? 1 : 0);
                    if (z && agI2.akd().cor() != null && agI2.akd().cor().azh() != null && agI2.akd().cor().azh().size() > 0) {
                        uD3.O(TiebaInitialize.Params.OBJ_TO, agI2.akd().jiV ? 2 : 1);
                    }
                    if (agI2.aiG() != null) {
                        uD3.O(TiebaInitialize.Params.AB_TYPE, agI2.aiG().hadConcerned() ? 1 : 0);
                    }
                    uD3.O("is_full", agI2.aku() ? 1 : 0);
                }
            }
            return uD3;
        }
    }

    public an uF(String str) {
        int i;
        an anVar = new an(str);
        if (this.cbq != null) {
            anVar.p("fid", this.cbq.getFid());
            anVar.bS("tid", this.cbq.getTid());
            if (this.cbq.isLinkThread()) {
                i = 4;
            } else {
                i = this.cbq.isShareThread ? 5 : 1;
            }
            anVar.O("obj_type", i);
            anVar.bS("obj_id", this.cbq.aiG().getUserId());
            anVar.O("obj_param1", baL() ? 2 : 1);
        }
        return anVar;
    }

    public an uG(String str) {
        an uD = uD(str);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "show");
            if (agI() != null) {
                bh agI = agI();
                boolean z = (agI.akd() == null || (agI.akd().cor() == null && agI.akd().azr() == null)) ? false : true;
                uD.O("obj_name", z ? 1 : 0);
                if (z && agI.akd().cor() != null && agI.akd().cor().azh() != null && agI.akd().cor().azh().size() > 0) {
                    uD.O(TiebaInitialize.Params.OBJ_TO, agI.akd().jiV ? 2 : 1);
                }
            }
        }
        return uD;
    }

    public an baS() {
        an uD;
        SmartApp ajs;
        if (baP()) {
            uD = uD(eQd);
        } else if (baQ()) {
            an uD2 = uD(eQj);
            if (uD2 != null && agI() != null && (ajs = agI().ajs()) != null) {
                uD2.bS("obj_type", ajs.id);
                uD2.bS("obj_name", ajs.name);
                return uD2;
            }
            return uD2;
        } else {
            uD = uD(ePY);
            if (uD != null) {
                uD.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            }
        }
        if (uD != null && agI() != null) {
            uD.O("is_full", agI().aku() ? 1 : 0);
        }
        return uD;
    }

    public an baT() {
        if (baP()) {
            return uD(eQe);
        }
        if (l.V(this.cbq)) {
            return ab(eQm, true);
        }
        an ap = ap(ePZ, 0);
        if (ap != null) {
            ap.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return ap;
        }
        return ap;
    }

    public an baU() {
        if (l.V(this.cbq)) {
            return ab(eQl, true);
        }
        if (baP()) {
            return uD(eQf);
        }
        an uD = uD(eQa);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return uD;
        }
        return uD;
    }

    public an baV() {
        if (baP()) {
            return uD(eQg);
        }
        an uD = uD(eQb);
        if (uD != null) {
            uD.bS(TiebaInitialize.Params.AB_TAG, baH()).bS(TiebaInitialize.Params.AB_ACTION, "click");
            return uD;
        }
        return uD;
    }

    public an baW() {
        return uD(eQh);
    }

    public an baX() {
        return ab(eQk, true);
    }

    public an uH(String str) {
        an uD = uD(str);
        if (this.cbq != null && this.cbq.aiG() != null) {
            uD.O(TiebaInitialize.Params.AB_TYPE, this.cbq.aiG().hadConcerned() ? 1 : 0);
        }
        return uD;
    }

    public an uI(String str) {
        return uD(str);
    }
}
