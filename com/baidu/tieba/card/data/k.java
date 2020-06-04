package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class k extends c {
    public static String gHm = "";
    public static String gHn = "";
    public static String gHo = "";
    public static String gHp = "";
    public static String gHq = "";
    public static String gHr = "";
    public static String gHs = "";
    public static String gHt = "";
    public static String gHu = "";
    public static String gHv = "";
    public static String gHw = "";
    public static String gHx = "";
    public static String gHy = "";
    public static String gHz = "";
    public static String gHA = "";
    public static String gHB = "";
    public static String gHC = "";
    public static String gHD = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId gHE = BdUniqueId.gen();
    public static final BdUniqueId dET = BdUniqueId.gen();
    public static final BdUniqueId dEZ = BdUniqueId.gen();
    public static final BdUniqueId dFa = BdUniqueId.gen();
    public static final BdUniqueId dFb = BdUniqueId.gen();
    public static final BdUniqueId dFc = BdUniqueId.gen();
    public static final BdUniqueId dFg = BdUniqueId.gen();
    public static final BdUniqueId dFh = BdUniqueId.gen();
    public static final BdUniqueId gHF = BdUniqueId.gen();
    public static final BdUniqueId gHG = BdUniqueId.gen();
    public static final BdUniqueId gHH = BdUniqueId.gen();
    public static final BdUniqueId gHI = BdUniqueId.gen();
    public static final BdUniqueId gHJ = BdUniqueId.gen();
    public static final BdUniqueId gHK = BdUniqueId.gen();
    public static final BdUniqueId gHL = BdUniqueId.gen();
    public static final BdUniqueId gHM = BdUniqueId.gen();
    public static final BdUniqueId gHN = BdUniqueId.gen();
    public boolean gHO = false;
    public boolean isLinkThread = false;
    public boolean dEy = false;
    public boolean gHP = false;
    public boolean dEo = false;
    public boolean gHQ = false;
    public boolean dEu = false;
    public boolean dEp = false;
    public boolean gHR = false;
    public boolean dEs = false;
    public boolean dEt = false;
    public boolean dEv = false;
    public boolean gHS = false;
    public boolean gHT = false;
    public boolean emp = true;

    public static boolean ac(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        return bkVar.getType() == bk.dEE || bkVar.getType() == bk.dEU || bkVar.getType() == bk.dET || bkVar.getType() == bk.dEZ || bkVar.getType() == bk.dFe;
    }

    public static boolean ae(bk bkVar) {
        if (bkVar == null) {
            return false;
        }
        return bkVar.getType() == bk.dFg || bkVar.getType() == bk.dFh;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.dEA == null) {
            return TYPE;
        }
        if (this.dEA.threadType == 63) {
            return dFg;
        }
        if (this.dEA.threadType == 64) {
            return dFh;
        }
        if (this.dEA.isShareThread && this.dEA.dHm != null) {
            if (this.dEA.dHm.dDi) {
                OriginalThreadInfo originalThreadInfo = this.dEA.dHm;
                if (originalThreadInfo.videoInfo != null) {
                    return dFc;
                }
                if (originalThreadInfo.aPm()) {
                    return dFb;
                }
                return dFa;
            }
            return dEZ;
        } else if (this.dEo) {
            return gHF;
        } else {
            if (this.dEp) {
                return gHH;
            }
            if (this.gHR) {
                return gHI;
            }
            if (this.dEs) {
                return gHJ;
            }
            if (this.dEt) {
                return gHK;
            }
            if (this.dEu) {
                return gHL;
            }
            if (this.dEv) {
                return gHN;
            }
            if (this.gHS) {
                return gHM;
            }
            if (this.gHQ) {
                return gHG;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        if (this.dEA == null) {
            return null;
        }
        if (this.dEA.aQl() == 5) {
            return this.dEA;
        }
        this.dEA.kr(1);
        return this.dEA;
    }

    public boolean bLL() {
        return (this.dEA == null || v.getCount(this.dEA.aQL()) == 0) ? false : true;
    }

    public boolean bLM() {
        return this.dEA == null || this.dEA.aRB();
    }

    public boolean aPk() {
        return this.dEA != null && this.dEA.aPk();
    }

    public an bLN() {
        SmartApp aRn;
        if (bLL()) {
            an Dr = Dr(gHr);
            if (Dr != null) {
                Dr.setPosition(this.position);
                if (aOi() != null) {
                    bk aOi = aOi();
                    Dr.ag("obj_name", aOi.aSb() != null && (aOi.aSb().ddL() != null || aOi.aSb().biA() != null) ? 1 : 0);
                    if (aOi.aQx() != null) {
                        Dr.ag(TiebaInitialize.Params.AB_TYPE, aOi.aQx().hadConcerned() ? 1 : 0);
                    }
                    Dr.ag("is_full", aOi.aSo() ? 1 : 0);
                }
            }
            return Dr;
        } else if (bLM()) {
            an Dr2 = Dr(gHx);
            if (Dr2 != null) {
                Dr2.setPosition(this.position);
                if (aOi() != null && (aRn = aOi().aRn()) != null) {
                    Dr2.dh("obj_type", aRn.id);
                    Dr2.dh("obj_name", aRn.name);
                    return Dr2;
                }
                return Dr2;
            }
            return Dr2;
        } else if (aPk()) {
            return null;
        } else {
            an Dr3 = Dr(gHm);
            if (Dr3 != null) {
                Dr3.setPosition(this.position);
                Dr3.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "show");
                if (aOi() != null) {
                    bk aOi2 = aOi();
                    boolean z = (aOi2.aSb() == null || (aOi2.aSb().ddL() == null && aOi2.aSb().biA() == null)) ? false : true;
                    Dr3.ag("obj_name", z ? 1 : 0);
                    if (z && aOi2.aSb().ddL() != null && aOi2.aSb().ddL().bis() != null && aOi2.aSb().ddL().bis().size() > 0) {
                        Dr3.ag(TiebaInitialize.Params.OBJ_TO, aOi2.aSb().lmA ? 2 : 1);
                    }
                    if (aOi2.aQx() != null) {
                        Dr3.ag(TiebaInitialize.Params.AB_TYPE, aOi2.aQx().hadConcerned() ? 1 : 0);
                    }
                    Dr3.ag("is_full", aOi2.aSo() ? 1 : 0);
                    if (aOi2.getBaijiahaoData() != null) {
                        Dr3.dh("obj_param4", aOi2.getBaijiahaoData().oriUgcNid);
                    }
                    Dr3.ag("obj_param5", ag(aOi2));
                    Dr3.dh("nid", aOi2.getNid());
                }
            }
            return Dr3;
        }
    }

    public an Dt(String str) {
        int i;
        an anVar = new an(str);
        if (this.dEA != null) {
            if (this.dEA.getBaijiahaoData() == null) {
                anVar.s("fid", this.dEA.getFid());
                anVar.dh("tid", this.dEA.getTid());
            } else {
                anVar.dh("tid", this.dEA.getBaijiahaoData().oriUgcNid);
            }
            if (this.dEA.aPk()) {
                i = 2;
            } else if (this.dEA.isLinkThread()) {
                i = 4;
            } else if (this.dEA.isShareThread) {
                i = 5;
            } else if (this.dEA.aPm()) {
                i = 6;
            } else if (this.dEA.aSv()) {
                i = 7;
            } else if (this.dEA.aPn()) {
                i = 8;
            } else {
                i = this.dEA.aSw() ? 9 : 1;
            }
            anVar.ag("obj_type", i);
            anVar.dh("obj_id", this.dEA.aQx().getUserId());
            anVar.ag("obj_param1", bLG() ? 2 : 1);
        }
        return anVar;
    }

    public an Du(String str) {
        an Dr = Dr(str);
        if (Dr != null) {
            Dr.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "show");
            if (aOi() != null) {
                bk aOi = aOi();
                boolean z = (aOi.aSb() == null || (aOi.aSb().ddL() == null && aOi.aSb().biA() == null)) ? false : true;
                Dr.ag("obj_name", z ? 1 : 0);
                if (z && aOi.aSb().ddL() != null && aOi.aSb().ddL().bis() != null && aOi.aSb().ddL().bis().size() > 0) {
                    Dr.ag(TiebaInitialize.Params.OBJ_TO, aOi.aSb().lmA ? 2 : 1);
                }
            }
        }
        return Dr;
    }

    public an bLO() {
        an Dr;
        SmartApp aRn;
        if (bLL()) {
            Dr = Dr(gHs);
        } else if (bLM()) {
            an Dr2 = Dr(gHy);
            if (Dr2 != null && aOi() != null && (aRn = aOi().aRn()) != null) {
                Dr2.dh("obj_type", aRn.id);
                Dr2.dh("obj_name", aRn.name);
                return Dr2;
            }
            return Dr2;
        } else {
            Dr = Dr(gHn);
            if (Dr != null) {
                Dr.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "click");
                if (aOi() != null) {
                    bk aOi = aOi();
                    if (aOi.getBaijiahaoData() != null) {
                        Dr.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                    }
                    Dr.ag("obj_param5", ag(aOi));
                    Dr.dh("nid", aOi.getNid());
                }
            }
        }
        if (Dr != null && aOi() != null) {
            Dr.ag("is_full", aOi().aSo() ? 1 : 0);
        }
        return Dr;
    }

    public an bLP() {
        if (bLL()) {
            return Dr(gHt);
        }
        if (l.ac(this.dEA)) {
            an ay = ay(gHB, true);
            if (ay != null && aOi() != null) {
                bk aOi = aOi();
                if (aOi.getBaijiahaoData() != null) {
                    ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                    ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
                }
                ay.ag("obj_param5", ag(aOi));
                ay.dh("nid", aOi.getNid());
                return ay;
            }
            return ay;
        }
        an aI = aI(gHo, 0);
        if (aI != null) {
            aI.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "click");
            if (aOi() != null) {
                bk aOi2 = aOi();
                if (aOi2.getBaijiahaoData() != null) {
                    aI.dh("obj_param4", aOi2.getBaijiahaoData().oriUgcNid);
                }
                aI.ag("obj_param5", ag(aOi2));
                aI.dh("nid", aOi2.getNid());
                return aI;
            }
            return aI;
        }
        return aI;
    }

    public an bLQ() {
        if (l.ac(this.dEA)) {
            an ay = ay(gHA, true);
            if (ay != null && aOi() != null) {
                bk aOi = aOi();
                if (aOi.getBaijiahaoData() != null) {
                    ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                    ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
                }
                ay.ag("obj_param5", ag(aOi));
                return ay;
            }
            return ay;
        } else if (bLL()) {
            return Dr(gHu);
        } else {
            an Dr = Dr(gHp);
            if (Dr != null) {
                Dr.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "click");
                if (aOi() != null) {
                    bk aOi2 = aOi();
                    if (aOi2.getBaijiahaoData() != null) {
                        Dr.dh("obj_param4", aOi2.getBaijiahaoData().oriUgcNid);
                    }
                    Dr.ag("obj_param5", ag(aOi2));
                    Dr.dh("nid", aOi2.getNid());
                    return Dr;
                }
                return Dr;
            }
            return Dr;
        }
    }

    public an bLR() {
        if (bLL()) {
            return Dr(gHv);
        }
        an Dr = Dr(gHq);
        if (Dr != null) {
            Dr.dh("ab_tag", bLC()).dh(TiebaInitialize.Params.AB_ACTION, "click");
            if (aOi() != null) {
                bk aOi = aOi();
                if (aOi.getBaijiahaoData() != null) {
                    Dr.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                }
                Dr.ag("obj_param5", ag(aOi));
                Dr.dh("nid", aOi.getNid());
                return Dr;
            }
            return Dr;
        }
        return Dr;
    }

    public an bLS() {
        return Dr(gHw);
    }

    public an bLT() {
        an ay = ay(gHz, true);
        if (aOi() != null) {
            bk aOi = aOi();
            if (aOi.getBaijiahaoData() != null) {
                ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
            }
            ay.ag("obj_param5", ag(aOi));
            ay.dh("nid", aOi.getNid());
        }
        return ay;
    }

    public an Dv(String str) {
        an Dr = Dr(str);
        if (this.dEA != null && this.dEA.aQx() != null) {
            Dr.ag(TiebaInitialize.Params.AB_TYPE, this.dEA.aQx().hadConcerned() ? 1 : 0);
        }
        return Dr;
    }

    public an Dw(String str) {
        return Dr(str);
    }

    public int af(bk bkVar) {
        if (bkVar == null) {
            return 0;
        }
        if (bkVar.aPm()) {
            return 1;
        }
        if (bkVar.aPk()) {
            return 2;
        }
        if (bkVar.aSv()) {
            return 3;
        }
        return bkVar.aSw() ? 4 : 0;
    }

    public int ag(bk bkVar) {
        if (bkVar == null) {
            return 1;
        }
        if (bkVar.aSw() || bkVar.aSv()) {
            return 2;
        }
        return (bkVar.aPm() || bkVar.aPn()) ? 3 : 1;
    }
}
