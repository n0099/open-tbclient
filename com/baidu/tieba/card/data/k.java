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
    public static String fMR = "";
    public static String fMS = "";
    public static String fMT = "";
    public static String fMU = "";
    public static String fMV = "";
    public static String fMW = "";
    public static String fMX = "";
    public static String fMY = "";
    public static String fMZ = "";
    public static String fNa = "";
    public static String fNb = "";
    public static String fNc = "";
    public static String fNd = "";
    public static String fNe = "";
    public static String fNf = "";
    public static String fNg = "";
    public static String fNh = "";
    public static String fNi = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fNj = BdUniqueId.gen();
    public static final BdUniqueId cRy = BdUniqueId.gen();
    public static final BdUniqueId cRE = BdUniqueId.gen();
    public static final BdUniqueId cRF = BdUniqueId.gen();
    public static final BdUniqueId cRG = BdUniqueId.gen();
    public static final BdUniqueId cRH = BdUniqueId.gen();
    public static final BdUniqueId fNk = BdUniqueId.gen();
    public static final BdUniqueId fNl = BdUniqueId.gen();
    public static final BdUniqueId fNm = BdUniqueId.gen();
    public static final BdUniqueId fNn = BdUniqueId.gen();
    public static final BdUniqueId fNo = BdUniqueId.gen();
    public static final BdUniqueId fNp = BdUniqueId.gen();
    public static final BdUniqueId fNq = BdUniqueId.gen();
    public static final BdUniqueId fNr = BdUniqueId.gen();
    public static final BdUniqueId fNs = BdUniqueId.gen();
    public static final BdUniqueId fNt = BdUniqueId.gen();
    public static final BdUniqueId fNu = BdUniqueId.gen();
    public static final BdUniqueId cRL = BdUniqueId.gen();
    public static final BdUniqueId cRM = BdUniqueId.gen();
    public boolean fNv = false;
    public boolean isLinkThread = false;
    public boolean fNw = false;
    public boolean cQV = false;
    public boolean cQW = false;
    public boolean fNx = false;
    public boolean cQZ = false;
    public boolean cRb = false;
    public boolean cRc = false;
    public boolean fNy = false;
    public boolean fNz = false;
    public boolean cRf = false;
    public boolean cRa = false;
    public boolean fNA = false;
    public boolean dyh = true;

    public static boolean aa(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRk || bjVar.getType() == bj.cRz || bjVar.getType() == bj.cRy || bjVar.getType() == bj.cRE || bjVar.getType() == bj.cRJ;
    }

    public static boolean ac(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRL || bjVar.getType() == bj.cRM;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRg == null) {
            return TYPE;
        }
        if (this.cRg.threadType == 63) {
            return cRL;
        }
        if (this.cRg.threadType == 64) {
            return cRM;
        }
        if (this.cRg.isShareThread && this.cRg.cTR != null) {
            if (this.cRg.cTR.cPN) {
                OriginalThreadInfo originalThreadInfo = this.cRg.cTR;
                if (originalThreadInfo.videoInfo != null) {
                    return cRH;
                }
                if (originalThreadInfo.aBd()) {
                    return cRG;
                }
                return cRF;
            }
            return cRE;
        } else if (this.cQV) {
            return fNl;
        } else {
            if (this.cQW) {
                return fNm;
            }
            if (this.fNx) {
                return fNo;
            }
            if (this.cQZ) {
                return fNp;
            }
            if (this.cRa) {
                return fNq;
            }
            if (this.cRb) {
                return fNu;
            }
            if (this.cRc) {
                return fNt;
            }
            if (this.fNy) {
                return fNr;
            }
            if (this.fNz) {
                return fNs;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        if (this.cRg == null) {
            return this.cRg;
        }
        if (this.cRg.aCc() == 5) {
            return this.cRg;
        }
        this.cRg.jI(1);
        return this.cRg;
    }

    public boolean bvA() {
        return (this.cRg == null || v.getCount(this.cRg.aCC()) == 0) ? false : true;
    }

    public boolean bvB() {
        return this.cRg == null || this.cRg.aDn();
    }

    public boolean aBb() {
        return this.cRg != null && this.cRg.aBb();
    }

    public an bvC() {
        SmartApp aDa;
        if (bvA()) {
            an zX = zX(fMW);
            if (zX != null) {
                zX.setPosition(this.position);
                if (aAg() != null) {
                    bj aAg = aAg();
                    zX.X("obj_name", aAg.aDM() != null && (aAg.aDM().cLd() != null || aAg.aDM().aUb() != null) ? 1 : 0);
                    if (aAg.aCo() != null) {
                        zX.X(TiebaInitialize.Params.AB_TYPE, aAg.aCo().hadConcerned() ? 1 : 0);
                    }
                    zX.X("is_full", aAg.aDZ() ? 1 : 0);
                }
            }
            return zX;
        } else if (bvB()) {
            an zX2 = zX(fNc);
            if (zX2 != null) {
                zX2.setPosition(this.position);
                if (aAg() != null && (aDa = aAg().aDa()) != null) {
                    zX2.cy("obj_type", aDa.id);
                    zX2.cy("obj_name", aDa.name);
                    return zX2;
                }
                return zX2;
            }
            return zX2;
        } else if (aBb()) {
            return null;
        } else {
            an zX3 = zX(fMR);
            if (zX3 != null) {
                zX3.setPosition(this.position);
                zX3.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "show");
                if (aAg() != null) {
                    bj aAg2 = aAg();
                    boolean z = (aAg2.aDM() == null || (aAg2.aDM().cLd() == null && aAg2.aDM().aUb() == null)) ? false : true;
                    zX3.X("obj_name", z ? 1 : 0);
                    if (z && aAg2.aDM().cLd() != null && aAg2.aDM().cLd().aTT() != null && aAg2.aDM().cLd().aTT().size() > 0) {
                        zX3.X(TiebaInitialize.Params.OBJ_TO, aAg2.aDM().khn ? 2 : 1);
                    }
                    if (aAg2.aCo() != null) {
                        zX3.X(TiebaInitialize.Params.AB_TYPE, aAg2.aCo().hadConcerned() ? 1 : 0);
                    }
                    zX3.X("is_full", aAg2.aDZ() ? 1 : 0);
                    if (aAg2.getBaijiahaoData() != null) {
                        zX3.cy("obj_param4", aAg2.getBaijiahaoData().oriUgcNid);
                    }
                    zX3.X("obj_param5", ae(aAg2));
                }
            }
            return zX3;
        }
    }

    public an zZ(String str) {
        int i;
        an anVar = new an(str);
        if (this.cRg != null) {
            if (this.cRg.getBaijiahaoData() == null) {
                anVar.s("fid", this.cRg.getFid());
                anVar.cy("tid", this.cRg.getTid());
            } else {
                anVar.cy("tid", this.cRg.getBaijiahaoData().oriUgcNid);
            }
            if (this.cRg.aBb()) {
                i = 2;
            } else if (this.cRg.isLinkThread()) {
                i = 4;
            } else if (this.cRg.isShareThread) {
                i = 5;
            } else if (this.cRg.aBd()) {
                i = 6;
            } else if (this.cRg.aEg()) {
                i = 7;
            } else if (this.cRg.aBe()) {
                i = 8;
            } else {
                i = this.cRg.aEh() ? 9 : 1;
            }
            anVar.X("obj_type", i);
            anVar.cy("obj_id", this.cRg.aCo().getUserId());
            anVar.X("obj_param1", bvw() ? 2 : 1);
        }
        return anVar;
    }

    public an Aa(String str) {
        an zX = zX(str);
        if (zX != null) {
            zX.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "show");
            if (aAg() != null) {
                bj aAg = aAg();
                boolean z = (aAg.aDM() == null || (aAg.aDM().cLd() == null && aAg.aDM().aUb() == null)) ? false : true;
                zX.X("obj_name", z ? 1 : 0);
                if (z && aAg.aDM().cLd() != null && aAg.aDM().cLd().aTT() != null && aAg.aDM().cLd().aTT().size() > 0) {
                    zX.X(TiebaInitialize.Params.OBJ_TO, aAg.aDM().khn ? 2 : 1);
                }
            }
        }
        return zX;
    }

    public an bvD() {
        an zX;
        SmartApp aDa;
        if (bvA()) {
            zX = zX(fMX);
        } else if (bvB()) {
            an zX2 = zX(fNd);
            if (zX2 != null && aAg() != null && (aDa = aAg().aDa()) != null) {
                zX2.cy("obj_type", aDa.id);
                zX2.cy("obj_name", aDa.name);
                return zX2;
            }
            return zX2;
        } else {
            zX = zX(fMS);
            if (zX != null) {
                zX.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAg() != null) {
                    bj aAg = aAg();
                    if (aAg.getBaijiahaoData() != null) {
                        zX.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                    }
                    zX.X("obj_param5", ae(aAg));
                }
            }
        }
        if (zX != null && aAg() != null) {
            zX.X("is_full", aAg().aDZ() ? 1 : 0);
        }
        return zX;
    }

    public an bvE() {
        if (bvA()) {
            return zX(fMY);
        }
        if (l.aa(this.cRg)) {
            an af = af(fNg, true);
            if (af != null && aAg() != null) {
                bj aAg = aAg();
                if (aAg.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAg));
                return af;
            }
            return af;
        }
        an ax = ax(fMT, 0);
        if (ax != null) {
            ax.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAg() != null) {
                bj aAg2 = aAg();
                if (aAg2.getBaijiahaoData() != null) {
                    ax.cy("obj_param4", aAg2.getBaijiahaoData().oriUgcNid);
                }
                ax.X("obj_param5", ae(aAg2));
                return ax;
            }
            return ax;
        }
        return ax;
    }

    public an bvF() {
        if (l.aa(this.cRg)) {
            an af = af(fNf, true);
            if (af != null && aAg() != null) {
                bj aAg = aAg();
                if (aAg.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAg));
                return af;
            }
            return af;
        } else if (bvA()) {
            return zX(fMZ);
        } else {
            an zX = zX(fMU);
            if (zX != null) {
                zX.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAg() != null) {
                    bj aAg2 = aAg();
                    if (aAg2.getBaijiahaoData() != null) {
                        zX.cy("obj_param4", aAg2.getBaijiahaoData().oriUgcNid);
                    }
                    zX.X("obj_param5", ae(aAg2));
                    return zX;
                }
                return zX;
            }
            return zX;
        }
    }

    public an bvG() {
        if (bvA()) {
            return zX(fNa);
        }
        an zX = zX(fMV);
        if (zX != null) {
            zX.cy(TiebaInitialize.Params.AB_TAG, bvs()).cy(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAg() != null) {
                bj aAg = aAg();
                if (aAg.getBaijiahaoData() != null) {
                    zX.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                }
                zX.X("obj_param5", ae(aAg));
                return zX;
            }
            return zX;
        }
        return zX;
    }

    public an bvH() {
        return zX(fNb);
    }

    public an bvI() {
        an af = af(fNe, true);
        if (aAg() != null) {
            bj aAg = aAg();
            if (aAg.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAg));
        }
        return af;
    }

    public an Ab(String str) {
        an zX = zX(str);
        if (this.cRg != null && this.cRg.aCo() != null) {
            zX.X(TiebaInitialize.Params.AB_TYPE, this.cRg.aCo().hadConcerned() ? 1 : 0);
        }
        return zX;
    }

    public an Ac(String str) {
        return zX(str);
    }

    public int ad(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBd()) {
            return 1;
        }
        if (bjVar.aBb()) {
            return 2;
        }
        if (bjVar.aEg()) {
            return 3;
        }
        return bjVar.aEh() ? 4 : 0;
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEh() || bjVar.aEg()) {
            return 2;
        }
        return (bjVar.aBd() || bjVar.aBe()) ? 3 : 1;
    }
}
