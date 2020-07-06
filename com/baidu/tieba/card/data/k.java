package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class k extends c {
    public static String gUm = "";
    public static String gUn = "";
    public static String gUo = "";
    public static String gUp = "";
    public static String gUq = "";
    public static String gUr = "";
    public static String gUs = "";
    public static String gUt = "";
    public static String gUu = "";
    public static String gUv = "";
    public static String gUw = "";
    public static String gUx = "";
    public static String gUy = "";
    public static String gUz = "";
    public static String gUA = "";
    public static String gUB = "";
    public static String gUC = "";
    public static String gUD = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId gUE = BdUniqueId.gen();
    public static final BdUniqueId dLF = BdUniqueId.gen();
    public static final BdUniqueId dLL = BdUniqueId.gen();
    public static final BdUniqueId dLM = BdUniqueId.gen();
    public static final BdUniqueId dLN = BdUniqueId.gen();
    public static final BdUniqueId dLO = BdUniqueId.gen();
    public static final BdUniqueId dLS = BdUniqueId.gen();
    public static final BdUniqueId dLT = BdUniqueId.gen();
    public static final BdUniqueId gUF = BdUniqueId.gen();
    public static final BdUniqueId gUG = BdUniqueId.gen();
    public static final BdUniqueId gUH = BdUniqueId.gen();
    public static final BdUniqueId gUI = BdUniqueId.gen();
    public static final BdUniqueId gUJ = BdUniqueId.gen();
    public static final BdUniqueId gUK = BdUniqueId.gen();
    public static final BdUniqueId gUL = BdUniqueId.gen();
    public static final BdUniqueId gUM = BdUniqueId.gen();
    public static final BdUniqueId gUN = BdUniqueId.gen();
    public static final BdUniqueId dLB = BdUniqueId.gen();
    public static final BdUniqueId dLD = BdUniqueId.gen();
    public static final BdUniqueId dLE = BdUniqueId.gen();
    public boolean gUO = false;
    public boolean isLinkThread = false;
    public boolean dLc = false;
    public boolean gUP = false;
    public boolean dKS = false;
    public boolean gUQ = false;
    public boolean dLe = false;
    public boolean dKY = false;
    public boolean dKT = false;
    public boolean gUR = false;
    public boolean dKW = false;
    public boolean dKX = false;
    public boolean dKZ = false;
    public boolean gUS = false;
    public boolean dLg = false;
    public boolean dLh = false;
    public boolean gUT = false;
    public boolean evf = true;

    public static boolean ad(bu buVar) {
        if (buVar == null) {
            return false;
        }
        return buVar.getType() == bu.dLm || buVar.getType() == bu.dLG || buVar.getType() == bu.dLF || buVar.getType() == bu.dLL || buVar.getType() == bu.dLQ;
    }

    public static boolean af(bu buVar) {
        if (buVar == null) {
            return false;
        }
        return buVar.getType() == bu.dLS || buVar.getType() == bu.dLT;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLi == null) {
            return TYPE;
        }
        if (this.dLi.threadType == 63) {
            return dLS;
        }
        if (this.dLi.threadType == 64) {
            return dLT;
        }
        if (this.dLi.isShareThread && this.dLi.dNX != null) {
            if (this.dLi.dNX.dJD) {
                OriginalThreadInfo originalThreadInfo = this.dLi.dNX;
                if (originalThreadInfo.videoInfo != null) {
                    return dLO;
                }
                if (originalThreadInfo.aQX()) {
                    return dLN;
                }
                return dLM;
            }
            return dLL;
        } else if (this.dKS) {
            return gUF;
        } else {
            if (this.dKT) {
                return gUH;
            }
            if (this.gUR) {
                return gUI;
            }
            if (this.dKW) {
                return gUJ;
            }
            if (this.dKX) {
                return gUK;
            }
            if (this.dKY) {
                return gUL;
            }
            if (this.dKZ) {
                return gUN;
            }
            if (this.gUS) {
                return gUM;
            }
            if (this.gUQ) {
                return gUG;
            }
            if (this.dLe) {
                return dLB;
            }
            if (this.dLg) {
                return dLD;
            }
            if (this.dLh) {
                return dLE;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        if (this.dLi == null) {
            return null;
        }
        if (this.dLi.aSd() == 5) {
            return this.dLi;
        }
        this.dLi.kF(1);
        return this.dLi;
    }

    public boolean bOW() {
        return (this.dLi == null || w.getCount(this.dLi.aSC()) == 0) ? false : true;
    }

    public boolean bOX() {
        return this.dLi == null || this.dLi.aTs();
    }

    public boolean aQV() {
        return this.dLi != null && this.dLi.aQV();
    }

    public ao bOY() {
        SmartApp aTe;
        if (bOW()) {
            ao DS = DS(gUr);
            if (DS != null) {
                DS.setPosition(this.position);
                if (aPS() != null) {
                    bu aPS = aPS();
                    DS.ag("obj_name", aPS.aTS() != null && (aPS.aTS().dib() != null || aPS.aTS().bkX() != null) ? 1 : 0);
                    if (aPS.aSp() != null) {
                        DS.ag(TiebaInitialize.Params.AB_TYPE, aPS.aSp().hadConcerned() ? 1 : 0);
                    }
                    DS.ag("is_full", aPS.aUf() ? 1 : 0);
                }
            }
            return DS;
        } else if (bOX()) {
            ao DS2 = DS(gUx);
            if (DS2 != null) {
                DS2.setPosition(this.position);
                if (aPS() != null && (aTe = aPS().aTe()) != null) {
                    DS2.dk("obj_type", aTe.id);
                    DS2.dk("obj_name", aTe.name);
                    return DS2;
                }
                return DS2;
            }
            return DS2;
        } else if (aQV()) {
            return null;
        } else {
            ao DS3 = DS(gUm);
            if (DS3 != null) {
                DS3.setPosition(this.position);
                DS3.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "show");
                if (aPS() != null) {
                    bu aPS2 = aPS();
                    boolean z = (aPS2.aTS() == null || (aPS2.aTS().dib() == null && aPS2.aTS().bkX() == null)) ? false : true;
                    DS3.ag("obj_name", z ? 1 : 0);
                    if (z && aPS2.aTS().dib() != null && aPS2.aTS().dib().bkP() != null && aPS2.aTS().dib().bkP().size() > 0) {
                        DS3.ag(TiebaInitialize.Params.OBJ_TO, aPS2.aTS().lGt ? 2 : 1);
                    }
                    if (aPS2.aSp() != null) {
                        DS3.ag(TiebaInitialize.Params.AB_TYPE, aPS2.aSp().hadConcerned() ? 1 : 0);
                    }
                    DS3.ag("is_full", aPS2.aUf() ? 1 : 0);
                    if (aPS2.getBaijiahaoData() != null) {
                        DS3.dk("obj_param4", aPS2.getBaijiahaoData().oriUgcNid);
                    }
                    DS3.ag("obj_param5", ah(aPS2));
                    DS3.dk("nid", aPS2.getNid());
                    if (aPS2.aUt()) {
                        DS3.ag("obj_param6", 2);
                    } else {
                        DS3.ag("obj_param6", 1);
                    }
                }
            }
            return DS3;
        }
    }

    public ao DU(String str) {
        int i;
        ao aoVar = new ao(str);
        if (this.dLi != null) {
            if (this.dLi.getBaijiahaoData() == null) {
                aoVar.s("fid", this.dLi.getFid());
                aoVar.dk("tid", this.dLi.getTid());
            } else {
                aoVar.dk("tid", this.dLi.getBaijiahaoData().oriUgcNid);
            }
            if (this.dLi.aQV()) {
                i = 2;
            } else if (this.dLi.isLinkThread()) {
                i = 4;
            } else if (this.dLi.isShareThread) {
                i = 5;
            } else if (this.dLi.aQX()) {
                i = 6;
            } else if (this.dLi.aUl()) {
                i = 7;
            } else if (this.dLi.aQY()) {
                i = 8;
            } else {
                i = this.dLi.aUm() ? 9 : 1;
            }
            aoVar.ag("obj_type", i);
            aoVar.dk("obj_id", this.dLi.aSp().getUserId());
            aoVar.ag("obj_param1", bOR() ? 2 : 1);
        }
        return aoVar;
    }

    public ao DV(String str) {
        ao DS = DS(str);
        if (DS != null) {
            DS.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "show");
            if (aPS() != null) {
                bu aPS = aPS();
                boolean z = (aPS.aTS() == null || (aPS.aTS().dib() == null && aPS.aTS().bkX() == null)) ? false : true;
                DS.ag("obj_name", z ? 1 : 0);
                if (z && aPS.aTS().dib() != null && aPS.aTS().dib().bkP() != null && aPS.aTS().dib().bkP().size() > 0) {
                    DS.ag(TiebaInitialize.Params.OBJ_TO, aPS.aTS().lGt ? 2 : 1);
                }
            }
        }
        return DS;
    }

    public ao bOZ() {
        ao DS;
        SmartApp aTe;
        if (bOW()) {
            DS = DS(gUs);
        } else if (bOX()) {
            ao DS2 = DS(gUy);
            if (DS2 != null && aPS() != null && (aTe = aPS().aTe()) != null) {
                DS2.dk("obj_type", aTe.id);
                DS2.dk("obj_name", aTe.name);
                return DS2;
            }
            return DS2;
        } else {
            DS = DS(gUn);
            if (DS != null) {
                DS.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "click");
                if (aPS() != null) {
                    bu aPS = aPS();
                    if (aPS.getBaijiahaoData() != null) {
                        DS.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                    }
                    DS.ag("obj_param5", ah(aPS));
                    DS.dk("nid", aPS.getNid());
                }
            }
        }
        if (DS != null && aPS() != null) {
            DS.ag("is_full", aPS().aUf() ? 1 : 0);
        }
        return DS;
    }

    public ao bPa() {
        if (bOW()) {
            return DS(gUt);
        }
        if (l.ad(this.dLi)) {
            ao aA = aA(gUB, true);
            if (aA != null && aPS() != null) {
                bu aPS = aPS();
                if (aPS.getBaijiahaoData() != null) {
                    aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                    aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
                }
                aA.ag("obj_param5", ah(aPS));
                aA.dk("nid", aPS.getNid());
                return aA;
            }
            return aA;
        }
        ao aH = aH(gUo, 0);
        if (aH != null) {
            aH.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "click");
            if (aPS() != null) {
                bu aPS2 = aPS();
                if (aPS2.getBaijiahaoData() != null) {
                    aH.dk("obj_param4", aPS2.getBaijiahaoData().oriUgcNid);
                }
                aH.ag("obj_param5", ah(aPS2));
                aH.dk("nid", aPS2.getNid());
                return aH;
            }
            return aH;
        }
        return aH;
    }

    public ao bPb() {
        if (l.ad(this.dLi)) {
            ao aA = aA(gUA, true);
            if (aA != null && aPS() != null) {
                bu aPS = aPS();
                if (aPS.getBaijiahaoData() != null) {
                    aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                    aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
                }
                aA.ag("obj_param5", ah(aPS));
                if (aPS.aUt()) {
                    aA.ag(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aA;
                }
                aA.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aA;
            }
            return aA;
        } else if (bOW()) {
            return DS(gUu);
        } else {
            ao DS = DS(gUp);
            if (DS != null) {
                DS.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "click");
                if (aPS() != null) {
                    bu aPS2 = aPS();
                    if (aPS2.getBaijiahaoData() != null) {
                        DS.dk("obj_param4", aPS2.getBaijiahaoData().oriUgcNid);
                    }
                    DS.ag("obj_param5", ah(aPS2));
                    DS.dk("nid", aPS2.getNid());
                    if (aPS2.aUt()) {
                        DS.ag(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return DS;
                    }
                    DS.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return DS;
                }
                return DS;
            }
            return DS;
        }
    }

    public ao bPc() {
        if (bOW()) {
            return DS(gUv);
        }
        ao DS = DS(gUq);
        if (DS != null) {
            DS.dk("ab_tag", bON()).dk(TiebaInitialize.Params.AB_ACTION, "click");
            if (aPS() != null) {
                bu aPS = aPS();
                if (aPS.getBaijiahaoData() != null) {
                    DS.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                }
                DS.ag("obj_param5", ah(aPS));
                DS.dk("nid", aPS.getNid());
                return DS;
            }
            return DS;
        }
        return DS;
    }

    public ao bPd() {
        return DS(gUw);
    }

    public ao bPe() {
        ao aA = aA(gUz, true);
        if (aPS() != null) {
            bu aPS = aPS();
            if (aPS.getBaijiahaoData() != null) {
                aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
            }
            aA.ag("obj_param5", ah(aPS));
            aA.dk("nid", aPS.getNid());
        }
        return aA;
    }

    public ao DW(String str) {
        ao DS = DS(str);
        if (this.dLi != null && this.dLi.aSp() != null) {
            DS.ag(TiebaInitialize.Params.AB_TYPE, this.dLi.aSp().hadConcerned() ? 1 : 0);
        }
        return DS;
    }

    public ao DX(String str) {
        return DS(str);
    }

    public int ag(bu buVar) {
        if (buVar == null) {
            return 0;
        }
        if (buVar.aQX()) {
            return 1;
        }
        if (buVar.aQV()) {
            return 2;
        }
        if (buVar.aUl()) {
            return 3;
        }
        return buVar.aUm() ? 4 : 0;
    }

    public int ah(bu buVar) {
        if (buVar == null) {
            return 1;
        }
        if (buVar.aUm() || buVar.aUl()) {
            return 2;
        }
        return (buVar.aQX() || buVar.aQY()) ? 3 : 1;
    }
}
