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
    public static String iAI = "";
    public static String iAJ = "";
    public static String iAK = "";
    public static String iAL = "";
    public static String iAM = "";
    public static String iAN = "";
    public static String iAO = "";
    public static String iAP = "";
    public static String iAQ = "";
    public static String iAR = "";
    public static String iAS = "";
    public static String iAT = "";
    public static String iAU = "";
    public static String iAV = "";
    public static String iAW = "";
    public static String iAX = "";
    public static String iAY = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iAZ = BdUniqueId.gen();
    public static final BdUniqueId eQI = BdUniqueId.gen();
    public static final BdUniqueId eQP = BdUniqueId.gen();
    public static final BdUniqueId eQQ = BdUniqueId.gen();
    public static final BdUniqueId eQR = BdUniqueId.gen();
    public static final BdUniqueId eQS = BdUniqueId.gen();
    public static final BdUniqueId eQW = BdUniqueId.gen();
    public static final BdUniqueId eQX = BdUniqueId.gen();
    public static final BdUniqueId iBa = BdUniqueId.gen();
    public static final BdUniqueId iBb = BdUniqueId.gen();
    public static final BdUniqueId eQr = BdUniqueId.gen();
    public static final BdUniqueId iBc = BdUniqueId.gen();
    public static final BdUniqueId iBd = BdUniqueId.gen();
    public static final BdUniqueId iBe = BdUniqueId.gen();
    public static final BdUniqueId iBf = BdUniqueId.gen();
    public static final BdUniqueId iBg = BdUniqueId.gen();
    public static final BdUniqueId iBh = BdUniqueId.gen();
    public static final BdUniqueId iBi = BdUniqueId.gen();
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public static final BdUniqueId eQF = BdUniqueId.gen();
    public static final BdUniqueId eQG = BdUniqueId.gen();
    public boolean iBj = false;
    public boolean isLinkThread = false;
    public boolean eQc = false;
    public boolean iBk = false;
    public boolean iBl = false;
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
        if (this.iAA && b.iAq.length > 1) {
            BdUniqueId type = this.eJQ.getType();
            if (type == cb.eQm || type == cb.eQI || type == cb.eQU || type == cb.eQJ) {
                if (this.eQi) {
                    indexOf = b.iAo.indexOf(b.iAf);
                } else {
                    indexOf = b.iAo.indexOf(b.iAe);
                }
                if (this.ePW) {
                    indexOf2 = b.iAp.indexOf(b.iAg);
                } else if (this.ePV) {
                    indexOf2 = b.iAp.indexOf(b.iAi);
                } else if (this.iAx) {
                    indexOf2 = b.iAp.indexOf(b.iAh);
                } else {
                    indexOf2 = b.iAp.indexOf(b.iAj);
                }
                if (indexOf >= 0 && indexOf < b.iAq.length && indexOf2 >= 0 && indexOf2 < b.iAq[0].length) {
                    return b.iAq[indexOf][indexOf2];
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
                return iBb;
            } else {
                if (this.ePS) {
                    return iBc;
                }
                if (this.iAx) {
                    return iBd;
                }
                if (this.ePV) {
                    return iBe;
                }
                if (this.ePW) {
                    return iBf;
                }
                if (this.ePX) {
                    return iBg;
                }
                if (this.ePY) {
                    return iBi;
                }
                if (this.iAz) {
                    return iBh;
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

    public boolean ctb() {
        return (this.eJQ == null || y.getCount(this.eJQ.bod()) == 0) ? false : true;
    }

    public boolean ctc() {
        return this.eJQ == null || this.eJQ.boU();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmv() {
        return this.eJQ != null && this.eJQ.bmv();
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csX() {
        SmartApp boE;
        if (ctb()) {
            ar IS = IS(iAN);
            if (IS != null) {
                IS.setPosition(this.position);
                if (bln() != null) {
                    cb bln = bln();
                    IS.ap("obj_name", bln.bpv() != null && (bln.bpv().dNH() != null || bln.bpv().bHH() != null) ? 1 : 0);
                    if (bln.bnQ() != null) {
                        IS.ap(TiebaInitialize.Params.AB_TYPE, bln.bnQ().hadConcerned() ? 1 : 0);
                    }
                    IS.ap("is_full", bln.bpI() ? 1 : 0);
                }
            }
            return IS;
        } else if (ctc()) {
            ar IS2 = IS(iAT);
            if (IS2 != null) {
                IS2.setPosition(this.position);
                if (bln() != null && (boE = bln().boE()) != null) {
                    TiebaStatic.deleteParamByKey(IS2, "obj_type");
                    IS2.dR("obj_type", boE.id);
                    IS2.dR("obj_name", boE.name);
                    return IS2;
                }
                return IS2;
            }
            return IS2;
        } else if (bmv()) {
            return null;
        } else {
            ar IS3 = IS(iAI);
            if (IS3 != null) {
                IS3.setPosition(this.position);
                IS3.dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (bln() != null) {
                    cb bln2 = bln();
                    boolean z = (bln2.bpv() == null || (bln2.bpv().dNH() == null && bln2.bpv().bHH() == null)) ? false : true;
                    IS3.ap("obj_name", z ? 1 : 0);
                    if (z && bln2.bpv().dNH() != null && bln2.bpv().dNH().bHz() != null && bln2.bpv().dNH().bHz().size() > 0) {
                        IS3.ap(TiebaInitialize.Params.OBJ_TO, bln2.bpv().nxE ? 2 : 1);
                    }
                    if (bln2.bnQ() != null) {
                        IS3.ap(TiebaInitialize.Params.AB_TYPE, bln2.bnQ().hadConcerned() ? 1 : 0);
                    }
                    IS3.ap("is_full", bln2.bpI() ? 1 : 0);
                    if (bln2.getBaijiahaoData() != null) {
                        IS3.dR("obj_param4", bln2.getBaijiahaoData().oriUgcNid);
                    }
                    IS3.ap("obj_param5", ai(bln2));
                    if (bln2.bpV()) {
                        IS3.ap("obj_param6", 2);
                    } else {
                        IS3.ap("obj_param6", 1);
                    }
                    if (bln2.bqb()) {
                        IS3.ap("gua_type", 1);
                    } else if (bln2.bpW() != null) {
                        IS3.ap("gua_type", 2);
                    } else {
                        IS3.ap("gua_type", 0);
                    }
                }
            }
            return IS3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public ar IT(String str) {
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
            arVar.ap("obj_param1", csT() ? 2 : 1);
        }
        return arVar;
    }

    public ar IV(String str) {
        ar IS = IS(str);
        if (IS != null) {
            IS.dR("ab_tag", csP()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (bln() != null) {
                cb bln = bln();
                boolean z = (bln.bpv() == null || (bln.bpv().dNH() == null && bln.bpv().bHH() == null)) ? false : true;
                IS.ap("obj_name", z ? 1 : 0);
                if (z && bln.bpv().dNH() != null && bln.bpv().dNH().bHz() != null && bln.bpv().dNH().bHz().size() > 0) {
                    IS.ap(TiebaInitialize.Params.OBJ_TO, bln.bpv().nxE ? 2 : 1);
                }
            }
        }
        return IS;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csV() {
        ar IS;
        SmartApp boE;
        if (ctb()) {
            IS = IS(iAO);
        } else if (ctc()) {
            ar IS2 = IS(iAU);
            if (IS2 != null && bln() != null && (boE = bln().boE()) != null) {
                TiebaStatic.deleteParamByKey(IS2, "obj_type");
                IS2.dR("obj_type", boE.id);
                IS2.dR("obj_name", boE.name);
                return IS2;
            }
            return IS2;
        } else {
            IS = IS(iAJ);
            if (IS != null) {
                IS.dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bln() != null) {
                    cb bln = bln();
                    if (bln.getBaijiahaoData() != null) {
                        IS.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                    }
                    IS.ap("obj_param5", ai(bln));
                }
            }
        }
        if (IS != null && bln() != null) {
            IS.ap("is_full", bln().bpI() ? 1 : 0);
        }
        return IS;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csU() {
        if (ctb()) {
            return IS(iAP);
        }
        if (l.ae(this.eJQ)) {
            ar az = az(iAX, true);
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
        ar aV = aV(iAK, 0);
        if (aV != null) {
            aV.dR("ab_tag", csP()).dR(TiebaInitialize.Params.AB_ACTION, "click");
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

    public ar ctd() {
        if (l.ae(this.eJQ)) {
            ar az = az(iAW, true);
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
        } else if (ctb()) {
            return IS(iAQ);
        } else {
            ar IS = IS(iAL);
            if (IS != null) {
                IS.dR("ab_tag", csP()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bln() != null) {
                    cb bln2 = bln();
                    if (bln2.getBaijiahaoData() != null) {
                        IS.dR("obj_param4", bln2.getBaijiahaoData().oriUgcNid);
                    }
                    IS.ap("obj_param5", ai(bln2));
                    IS.dR(IntentConfig.NID, bln2.bmo());
                    if (bln2.bpV()) {
                        IS.ap(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return IS;
                    }
                    IS.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return IS;
                }
                return IS;
            }
            return IS;
        }
    }

    public ar cte() {
        if (ctb()) {
            return IS(iAR);
        }
        ar IS = IS(iAM);
        if (IS != null) {
            IS.dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bln() != null) {
                cb bln = bln();
                if (bln.getBaijiahaoData() != null) {
                    IS.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                }
                IS.ap("obj_param5", ai(bln));
                return IS;
            }
            return IS;
        }
        return IS;
    }

    public ar ctf() {
        return IS(iAS);
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csW() {
        ar az = az(iAV, true);
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

    public ar IW(String str) {
        ar IS = IS(str);
        if (this.eJQ != null && this.eJQ.bnQ() != null) {
            IS.ap(TiebaInitialize.Params.AB_TYPE, this.eJQ.bnQ().hadConcerned() ? 1 : 0);
        }
        return IS;
    }

    public ar IX(String str) {
        return IS(str);
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
