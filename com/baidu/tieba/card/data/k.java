package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class k extends c {
    public static String fNz = "";
    public static String fNA = "";
    public static String fNB = "";
    public static String fNC = "";
    public static String fND = "";
    public static String fNE = "";
    public static String fNF = "";
    public static String fNG = "";
    public static String fNH = "";
    public static String fNI = "";
    public static String fNJ = "";
    public static String fNK = "";
    public static String fNL = "";
    public static String fNM = "";
    public static String fNN = "";
    public static String fNO = "";
    public static String fNP = "";
    public static String fNQ = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fNR = BdUniqueId.gen();
    public static final BdUniqueId cRL = BdUniqueId.gen();
    public static final BdUniqueId cRR = BdUniqueId.gen();
    public static final BdUniqueId cRS = BdUniqueId.gen();
    public static final BdUniqueId cRT = BdUniqueId.gen();
    public static final BdUniqueId cRU = BdUniqueId.gen();
    public static final BdUniqueId fNS = BdUniqueId.gen();
    public static final BdUniqueId fNT = BdUniqueId.gen();
    public static final BdUniqueId fNU = BdUniqueId.gen();
    public static final BdUniqueId fNV = BdUniqueId.gen();
    public static final BdUniqueId fNW = BdUniqueId.gen();
    public static final BdUniqueId fNX = BdUniqueId.gen();
    public static final BdUniqueId fNY = BdUniqueId.gen();
    public static final BdUniqueId fNZ = BdUniqueId.gen();
    public static final BdUniqueId fOa = BdUniqueId.gen();
    public static final BdUniqueId fOb = BdUniqueId.gen();
    public static final BdUniqueId fOc = BdUniqueId.gen();
    public static final BdUniqueId cRY = BdUniqueId.gen();
    public static final BdUniqueId cRZ = BdUniqueId.gen();
    public boolean fOd = false;
    public boolean isLinkThread = false;
    public boolean fOe = false;
    public boolean cRi = false;
    public boolean cRj = false;
    public boolean fOf = false;
    public boolean cRm = false;
    public boolean cRo = false;
    public boolean cRp = false;
    public boolean fOg = false;
    public boolean fOh = false;
    public boolean cRs = false;
    public boolean cRn = false;
    public boolean fOi = false;
    public boolean dyu = true;

    public static boolean ab(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRx || bjVar.getType() == bj.cRM || bjVar.getType() == bj.cRL || bjVar.getType() == bj.cRR || bjVar.getType() == bj.cRW;
    }

    public static boolean ad(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRY || bjVar.getType() == bj.cRZ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRt == null) {
            return TYPE;
        }
        if (this.cRt.threadType == 63) {
            return cRY;
        }
        if (this.cRt.threadType == 64) {
            return cRZ;
        }
        if (this.cRt.isShareThread && this.cRt.cUe != null) {
            if (this.cRt.cUe.cQa) {
                OriginalThreadInfo originalThreadInfo = this.cRt.cUe;
                if (originalThreadInfo.videoInfo != null) {
                    return cRU;
                }
                if (originalThreadInfo.aBg()) {
                    return cRT;
                }
                return cRS;
            }
            return cRR;
        } else if (this.cRi) {
            return fNT;
        } else {
            if (this.cRj) {
                return fNU;
            }
            if (this.fOf) {
                return fNW;
            }
            if (this.cRm) {
                return fNX;
            }
            if (this.cRn) {
                return fNY;
            }
            if (this.cRo) {
                return fOc;
            }
            if (this.cRp) {
                return fOb;
            }
            if (this.fOg) {
                return fNZ;
            }
            if (this.fOh) {
                return fOa;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAj() {
        if (this.cRt == null) {
            return this.cRt;
        }
        if (this.cRt.aCf() == 5) {
            return this.cRt;
        }
        this.cRt.jI(1);
        return this.cRt;
    }

    public boolean bvF() {
        return (this.cRt == null || v.getCount(this.cRt.aCF()) == 0) ? false : true;
    }

    public boolean bvG() {
        return this.cRt == null || this.cRt.aDr();
    }

    public boolean aBe() {
        return this.cRt != null && this.cRt.aBe();
    }

    public an bvH() {
        SmartApp aDd;
        if (bvF()) {
            an zY = zY(fNE);
            if (zY != null) {
                zY.setPosition(this.position);
                if (aAj() != null) {
                    bj aAj = aAj();
                    zY.X("obj_name", aAj.aDQ() != null && (aAj.aDQ().cLx() != null || aAj.aDQ().aUf() != null) ? 1 : 0);
                    if (aAj.aCr() != null) {
                        zY.X(TiebaInitialize.Params.AB_TYPE, aAj.aCr().hadConcerned() ? 1 : 0);
                    }
                    zY.X("is_full", aAj.aEd() ? 1 : 0);
                }
            }
            return zY;
        } else if (bvG()) {
            an zY2 = zY(fNK);
            if (zY2 != null) {
                zY2.setPosition(this.position);
                if (aAj() != null && (aDd = aAj().aDd()) != null) {
                    zY2.cx("obj_type", aDd.id);
                    zY2.cx("obj_name", aDd.name);
                    return zY2;
                }
                return zY2;
            }
            return zY2;
        } else if (aBe()) {
            return null;
        } else {
            an zY3 = zY(fNz);
            if (zY3 != null) {
                zY3.setPosition(this.position);
                zY3.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "show");
                if (aAj() != null) {
                    bj aAj2 = aAj();
                    boolean z = (aAj2.aDQ() == null || (aAj2.aDQ().cLx() == null && aAj2.aDQ().aUf() == null)) ? false : true;
                    zY3.X("obj_name", z ? 1 : 0);
                    if (z && aAj2.aDQ().cLx() != null && aAj2.aDQ().cLx().aTX() != null && aAj2.aDQ().cLx().aTX().size() > 0) {
                        zY3.X(TiebaInitialize.Params.OBJ_TO, aAj2.aDQ().kiQ ? 2 : 1);
                    }
                    if (aAj2.aCr() != null) {
                        zY3.X(TiebaInitialize.Params.AB_TYPE, aAj2.aCr().hadConcerned() ? 1 : 0);
                    }
                    zY3.X("is_full", aAj2.aEd() ? 1 : 0);
                    if (aAj2.getBaijiahaoData() != null) {
                        zY3.cx("obj_param4", aAj2.getBaijiahaoData().oriUgcNid);
                    }
                    zY3.X("obj_param5", af(aAj2));
                }
            }
            return zY3;
        }
    }

    public an Aa(String str) {
        int i;
        an anVar = new an(str);
        if (this.cRt != null) {
            if (this.cRt.getBaijiahaoData() == null) {
                anVar.s("fid", this.cRt.getFid());
                anVar.cx("tid", this.cRt.getTid());
            } else {
                anVar.cx("tid", this.cRt.getBaijiahaoData().oriUgcNid);
            }
            if (this.cRt.aBe()) {
                i = 2;
            } else if (this.cRt.isLinkThread()) {
                i = 4;
            } else if (this.cRt.isShareThread) {
                i = 5;
            } else if (this.cRt.aBg()) {
                i = 6;
            } else if (this.cRt.aEk()) {
                i = 7;
            } else if (this.cRt.aBh()) {
                i = 8;
            } else {
                i = this.cRt.aEl() ? 9 : 1;
            }
            anVar.X("obj_type", i);
            anVar.cx("obj_id", this.cRt.aCr().getUserId());
            anVar.X("obj_param1", bvB() ? 2 : 1);
        }
        return anVar;
    }

    public an Ab(String str) {
        an zY = zY(str);
        if (zY != null) {
            zY.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "show");
            if (aAj() != null) {
                bj aAj = aAj();
                boolean z = (aAj.aDQ() == null || (aAj.aDQ().cLx() == null && aAj.aDQ().aUf() == null)) ? false : true;
                zY.X("obj_name", z ? 1 : 0);
                if (z && aAj.aDQ().cLx() != null && aAj.aDQ().cLx().aTX() != null && aAj.aDQ().cLx().aTX().size() > 0) {
                    zY.X(TiebaInitialize.Params.OBJ_TO, aAj.aDQ().kiQ ? 2 : 1);
                }
            }
        }
        return zY;
    }

    public an bvI() {
        an zY;
        SmartApp aDd;
        if (bvF()) {
            zY = zY(fNF);
        } else if (bvG()) {
            an zY2 = zY(fNL);
            if (zY2 != null && aAj() != null && (aDd = aAj().aDd()) != null) {
                zY2.cx("obj_type", aDd.id);
                zY2.cx("obj_name", aDd.name);
                return zY2;
            }
            return zY2;
        } else {
            zY = zY(fNA);
            if (zY != null) {
                zY.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAj() != null) {
                    bj aAj = aAj();
                    if (aAj.getBaijiahaoData() != null) {
                        zY.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                    }
                    zY.X("obj_param5", af(aAj));
                }
            }
        }
        if (zY != null && aAj() != null) {
            zY.X("is_full", aAj().aEd() ? 1 : 0);
        }
        return zY;
    }

    public an bvJ() {
        if (bvF()) {
            return zY(fNG);
        }
        if (l.ab(this.cRt)) {
            an af = af(fNO, true);
            if (af != null && aAj() != null) {
                bj aAj = aAj();
                if (aAj.getBaijiahaoData() != null) {
                    af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                    af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", af(aAj));
                return af;
            }
            return af;
        }
        an ax = ax(fNB, 0);
        if (ax != null) {
            ax.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAj() != null) {
                bj aAj2 = aAj();
                if (aAj2.getBaijiahaoData() != null) {
                    ax.cx("obj_param4", aAj2.getBaijiahaoData().oriUgcNid);
                }
                ax.X("obj_param5", af(aAj2));
                return ax;
            }
            return ax;
        }
        return ax;
    }

    public an bvK() {
        if (l.ab(this.cRt)) {
            an af = af(fNN, true);
            if (af != null && aAj() != null) {
                bj aAj = aAj();
                if (aAj.getBaijiahaoData() != null) {
                    af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                    af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", af(aAj));
                return af;
            }
            return af;
        } else if (bvF()) {
            return zY(fNH);
        } else {
            an zY = zY(fNC);
            if (zY != null) {
                zY.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAj() != null) {
                    bj aAj2 = aAj();
                    if (aAj2.getBaijiahaoData() != null) {
                        zY.cx("obj_param4", aAj2.getBaijiahaoData().oriUgcNid);
                    }
                    zY.X("obj_param5", af(aAj2));
                    return zY;
                }
                return zY;
            }
            return zY;
        }
    }

    public an bvL() {
        if (bvF()) {
            return zY(fNI);
        }
        an zY = zY(fND);
        if (zY != null) {
            zY.cx(TiebaInitialize.Params.AB_TAG, bvx()).cx(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAj() != null) {
                bj aAj = aAj();
                if (aAj.getBaijiahaoData() != null) {
                    zY.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                }
                zY.X("obj_param5", af(aAj));
                return zY;
            }
            return zY;
        }
        return zY;
    }

    public an bvM() {
        return zY(fNJ);
    }

    public an bvN() {
        an af = af(fNM, true);
        if (aAj() != null) {
            bj aAj = aAj();
            if (aAj.getBaijiahaoData() != null) {
                af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", af(aAj));
        }
        return af;
    }

    public an Ac(String str) {
        an zY = zY(str);
        if (this.cRt != null && this.cRt.aCr() != null) {
            zY.X(TiebaInitialize.Params.AB_TYPE, this.cRt.aCr().hadConcerned() ? 1 : 0);
        }
        return zY;
    }

    public an Ad(String str) {
        return zY(str);
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBg()) {
            return 1;
        }
        if (bjVar.aBe()) {
            return 2;
        }
        if (bjVar.aEk()) {
            return 3;
        }
        return bjVar.aEl() ? 4 : 0;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEl() || bjVar.aEk()) {
            return 2;
        }
        return (bjVar.aBg() || bjVar.aBh()) ? 3 : 1;
    }
}
