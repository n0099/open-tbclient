package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class k extends b {
    public static String iAu = "";
    public static String iAv = "";
    public static String iAw = "";
    public static String iAx = "";
    public static String iAy = "";
    public static String iAz = "";
    public static String iAA = "";
    public static String iAB = "";
    public static String iAC = "";
    public static String iAD = "";
    public static String iAE = "";
    public static String iAF = "";
    public static String iAG = "";
    public static String iAH = "";
    public static String iAI = "";
    public static String iAJ = "";
    public static String iAK = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iAL = BdUniqueId.gen();
    public static final BdUniqueId eQI = BdUniqueId.gen();
    public static final BdUniqueId eQP = BdUniqueId.gen();
    public static final BdUniqueId eQQ = BdUniqueId.gen();
    public static final BdUniqueId eQR = BdUniqueId.gen();
    public static final BdUniqueId eQS = BdUniqueId.gen();
    public static final BdUniqueId eQW = BdUniqueId.gen();
    public static final BdUniqueId eQX = BdUniqueId.gen();
    public static final BdUniqueId iAM = BdUniqueId.gen();
    public static final BdUniqueId iAN = BdUniqueId.gen();
    public static final BdUniqueId eQr = BdUniqueId.gen();
    public static final BdUniqueId iAO = BdUniqueId.gen();
    public static final BdUniqueId iAP = BdUniqueId.gen();
    public static final BdUniqueId iAQ = BdUniqueId.gen();
    public static final BdUniqueId iAR = BdUniqueId.gen();
    public static final BdUniqueId iAS = BdUniqueId.gen();
    public static final BdUniqueId iAT = BdUniqueId.gen();
    public static final BdUniqueId iAU = BdUniqueId.gen();
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public static final BdUniqueId eQF = BdUniqueId.gen();
    public static final BdUniqueId eQG = BdUniqueId.gen();
    public boolean iAV = false;
    public boolean isLinkThread = false;
    public boolean eQc = false;
    public boolean iAW = false;
    public boolean iAX = false;
    public boolean fCP = true;

    public static boolean ae(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        return cbVar.getType() == cb.eQm || cbVar.getType() == cb.eQJ || cbVar.getType() == cb.eQI || cbVar.getType() == cb.eQP || cbVar.getType() == cb.eQU;
    }

    public static boolean ag(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        return cbVar.getType() == cb.eQW || cbVar.getType() == cb.eQX;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.eJQ == null) {
            return TYPE;
        }
        if (this.iAm && b.iAc.length > 1) {
            BdUniqueId type = this.eJQ.getType();
            if (type == cb.eQm || type == cb.eQI || type == cb.eQU || type == cb.eQJ) {
                if (this.eQi) {
                    indexOf = b.iAa.indexOf(b.izR);
                } else {
                    indexOf = b.iAa.indexOf(b.izQ);
                }
                if (this.ePW) {
                    indexOf2 = b.iAb.indexOf(b.izS);
                } else if (this.ePV) {
                    indexOf2 = b.iAb.indexOf(b.izU);
                } else if (this.iAj) {
                    indexOf2 = b.iAb.indexOf(b.izT);
                } else {
                    indexOf2 = b.iAb.indexOf(b.izV);
                }
                if (indexOf >= 0 && indexOf < b.iAc.length && indexOf2 >= 0 && indexOf2 < b.iAc[0].length) {
                    return b.iAc[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.eJQ.threadType == 63) {
            return eQW;
        } else {
            if (this.eJQ.threadType == 64) {
                return eQX;
            }
            if (this.eJQ.isShareThread && this.eJQ.eTc != null) {
                if (this.eJQ.eTc.eOz) {
                    OriginalThreadInfo originalThreadInfo = this.eJQ.eTc;
                    if (originalThreadInfo.videoInfo != null) {
                        return eQS;
                    }
                    if (originalThreadInfo.bmx()) {
                        return eQR;
                    }
                    return eQQ;
                }
                return eQP;
            } else if (this.ePR) {
                return iAN;
            } else {
                if (this.ePS) {
                    return iAO;
                }
                if (this.iAj) {
                    return iAP;
                }
                if (this.ePV) {
                    return iAQ;
                }
                if (this.ePW) {
                    return iAR;
                }
                if (this.ePX) {
                    return iAS;
                }
                if (this.ePY) {
                    return iAU;
                }
                if (this.iAl) {
                    return iAT;
                }
                if (this.eQi) {
                    return eQr;
                }
                if (this.eQe) {
                    return eQD;
                }
                if (this.eQg) {
                    return eQF;
                }
                if (this.eQh) {
                    return eQG;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        if (this.eJQ == null) {
            return null;
        }
        if (this.eJQ.bnE() == 5) {
            return this.eJQ;
        }
        this.eJQ.nj(1);
        return this.eJQ;
    }

    public boolean csU() {
        return (this.eJQ == null || y.getCount(this.eJQ.bod()) == 0) ? false : true;
    }

    public boolean csV() {
        return this.eJQ == null || this.eJQ.boU();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmv() {
        return this.eJQ != null && this.eJQ.bmv();
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csQ() {
        SmartApp boE;
        if (csU()) {
            ar IR = IR(iAz);
            if (IR != null) {
                IR.setPosition(this.position);
                if (bln() != null) {
                    cb bln = bln();
                    IR.ap("obj_name", bln.bpv() != null && (bln.bpv().dNz() != null || bln.bpv().bHH() != null) ? 1 : 0);
                    if (bln.bnQ() != null) {
                        IR.ap(TiebaInitialize.Params.AB_TYPE, bln.bnQ().hadConcerned() ? 1 : 0);
                    }
                    IR.ap("is_full", bln.bpI() ? 1 : 0);
                }
            }
            return IR;
        } else if (csV()) {
            ar IR2 = IR(iAF);
            if (IR2 != null) {
                IR2.setPosition(this.position);
                if (bln() != null && (boE = bln().boE()) != null) {
                    TiebaStatic.deleteParamByKey(IR2, "obj_type");
                    IR2.dR("obj_type", boE.id);
                    IR2.dR("obj_name", boE.name);
                    return IR2;
                }
                return IR2;
            }
            return IR2;
        } else if (bmv()) {
            return null;
        } else {
            ar IR3 = IR(iAu);
            if (IR3 != null) {
                IR3.setPosition(this.position);
                IR3.dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (bln() != null) {
                    cb bln2 = bln();
                    boolean z = (bln2.bpv() == null || (bln2.bpv().dNz() == null && bln2.bpv().bHH() == null)) ? false : true;
                    IR3.ap("obj_name", z ? 1 : 0);
                    if (z && bln2.bpv().dNz() != null && bln2.bpv().dNz().bHz() != null && bln2.bpv().dNz().bHz().size() > 0) {
                        IR3.ap(TiebaInitialize.Params.OBJ_TO, bln2.bpv().nxe ? 2 : 1);
                    }
                    if (bln2.bnQ() != null) {
                        IR3.ap(TiebaInitialize.Params.AB_TYPE, bln2.bnQ().hadConcerned() ? 1 : 0);
                    }
                    IR3.ap("is_full", bln2.bpI() ? 1 : 0);
                    if (bln2.getBaijiahaoData() != null) {
                        IR3.dR("obj_param4", bln2.getBaijiahaoData().oriUgcNid);
                    }
                    IR3.ap("obj_param5", ai(bln2));
                    if (bln2.bpV()) {
                        IR3.ap("obj_param6", 2);
                    } else {
                        IR3.ap("obj_param6", 1);
                    }
                    if (bln2.bqb()) {
                        IR3.ap("gua_type", 1);
                    } else if (bln2.bpW() != null) {
                        IR3.ap("gua_type", 2);
                    } else {
                        IR3.ap("gua_type", 0);
                    }
                }
            }
            return IR3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public ar IS(String str) {
        int i;
        ar arVar = new ar(str);
        if (this.eJQ != null) {
            if (this.eJQ.getBaijiahaoData() == null) {
                arVar.v("fid", this.eJQ.getFid());
                arVar.dR("tid", this.eJQ.getTid());
            } else {
                arVar.dR("tid", this.eJQ.getBaijiahaoData().oriUgcNid);
            }
            if (this.eJQ.bmv()) {
                i = 2;
            } else if (this.eJQ.isLinkThread()) {
                i = 4;
            } else if (this.eJQ.isShareThread) {
                i = 5;
            } else if (this.eJQ.bmx()) {
                i = 6;
            } else if (this.eJQ.bpN()) {
                i = 7;
            } else if (this.eJQ.bmy()) {
                i = 8;
            } else {
                i = this.eJQ.bpO() ? 9 : 1;
            }
            arVar.ap("obj_type", i);
            arVar.dR("obj_id", this.eJQ.bnQ().getUserId());
            arVar.ap("obj_param1", csM() ? 2 : 1);
        }
        return arVar;
    }

    public ar IU(String str) {
        ar IR = IR(str);
        if (IR != null) {
            IR.dR("ab_tag", csI()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (bln() != null) {
                cb bln = bln();
                boolean z = (bln.bpv() == null || (bln.bpv().dNz() == null && bln.bpv().bHH() == null)) ? false : true;
                IR.ap("obj_name", z ? 1 : 0);
                if (z && bln.bpv().dNz() != null && bln.bpv().dNz().bHz() != null && bln.bpv().dNz().bHz().size() > 0) {
                    IR.ap(TiebaInitialize.Params.OBJ_TO, bln.bpv().nxe ? 2 : 1);
                }
            }
        }
        return IR;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csO() {
        ar IR;
        SmartApp boE;
        if (csU()) {
            IR = IR(iAA);
        } else if (csV()) {
            ar IR2 = IR(iAG);
            if (IR2 != null && bln() != null && (boE = bln().boE()) != null) {
                TiebaStatic.deleteParamByKey(IR2, "obj_type");
                IR2.dR("obj_type", boE.id);
                IR2.dR("obj_name", boE.name);
                return IR2;
            }
            return IR2;
        } else {
            IR = IR(iAv);
            if (IR != null) {
                IR.dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bln() != null) {
                    cb bln = bln();
                    if (bln.getBaijiahaoData() != null) {
                        IR.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                    }
                    IR.ap("obj_param5", ai(bln));
                }
            }
        }
        if (IR != null && bln() != null) {
            IR.ap("is_full", bln().bpI() ? 1 : 0);
        }
        return IR;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csN() {
        if (csU()) {
            return IR(iAB);
        }
        if (l.ae(this.eJQ)) {
            ar az = az(iAJ, true);
            if (az != null && bln() != null) {
                cb bln = bln();
                if (bln.getBaijiahaoData() != null) {
                    az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
                }
                az.ap("obj_param5", ai(bln));
                return az;
            }
            return az;
        }
        ar aV = aV(iAw, 0);
        if (aV != null) {
            aV.dR("ab_tag", csI()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bln() != null) {
                cb bln2 = bln();
                if (bln2.getBaijiahaoData() != null) {
                    aV.dR("obj_param4", bln2.getBaijiahaoData().oriUgcNid);
                }
                aV.ap("obj_param5", ai(bln2));
                aV.dR(IntentConfig.NID, bln2.bmo());
                return aV;
            }
            return aV;
        }
        return aV;
    }

    public ar csW() {
        if (l.ae(this.eJQ)) {
            ar az = az(iAI, true);
            if (az != null && bln() != null) {
                cb bln = bln();
                if (bln.getBaijiahaoData() != null) {
                    az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
                }
                az.ap("obj_param5", ai(bln));
                if (bln.bpV()) {
                    az.ap(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return az;
                }
                az.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return az;
            }
            return az;
        } else if (csU()) {
            return IR(iAC);
        } else {
            ar IR = IR(iAx);
            if (IR != null) {
                IR.dR("ab_tag", csI()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bln() != null) {
                    cb bln2 = bln();
                    if (bln2.getBaijiahaoData() != null) {
                        IR.dR("obj_param4", bln2.getBaijiahaoData().oriUgcNid);
                    }
                    IR.ap("obj_param5", ai(bln2));
                    IR.dR(IntentConfig.NID, bln2.bmo());
                    if (bln2.bpV()) {
                        IR.ap(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return IR;
                    }
                    IR.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return IR;
                }
                return IR;
            }
            return IR;
        }
    }

    public ar csX() {
        if (csU()) {
            return IR(iAD);
        }
        ar IR = IR(iAy);
        if (IR != null) {
            IR.dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bln() != null) {
                cb bln = bln();
                if (bln.getBaijiahaoData() != null) {
                    IR.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                }
                IR.ap("obj_param5", ai(bln));
                return IR;
            }
            return IR;
        }
        return IR;
    }

    public ar csY() {
        return IR(iAE);
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csP() {
        ar az = az(iAH, true);
        if (bln() != null) {
            cb bln = bln();
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
            }
            az.ap("obj_param5", ai(bln));
        }
        return az;
    }

    public ar IV(String str) {
        ar IR = IR(str);
        if (this.eJQ != null && this.eJQ.bnQ() != null) {
            IR.ap(TiebaInitialize.Params.AB_TYPE, this.eJQ.bnQ().hadConcerned() ? 1 : 0);
        }
        return IR;
    }

    public ar IW(String str) {
        return IR(str);
    }

    public int ah(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmx()) {
            return 1;
        }
        if (cbVar.bmv()) {
            return 2;
        }
        if (cbVar.bpN()) {
            return 3;
        }
        return cbVar.bpO() ? 4 : 0;
    }

    public int ai(cb cbVar) {
        if (cbVar == null) {
            return 1;
        }
        if (cbVar.bpO() || cbVar.bpN()) {
            return 2;
        }
        return (cbVar.bmx() || cbVar.bmy()) ? 3 : 1;
    }
}
