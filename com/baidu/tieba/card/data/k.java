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
    public static String fME = "";
    public static String fMF = "";
    public static String fMG = "";
    public static String fMH = "";
    public static String fMI = "";
    public static String fMJ = "";
    public static String fMK = "";
    public static String fML = "";
    public static String fMM = "";
    public static String fMN = "";
    public static String fMO = "";
    public static String fMP = "";
    public static String fMQ = "";
    public static String fMR = "";
    public static String fMS = "";
    public static String fMT = "";
    public static String fMU = "";
    public static String fMV = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fMW = BdUniqueId.gen();
    public static final BdUniqueId cRx = BdUniqueId.gen();
    public static final BdUniqueId cRD = BdUniqueId.gen();
    public static final BdUniqueId cRE = BdUniqueId.gen();
    public static final BdUniqueId cRF = BdUniqueId.gen();
    public static final BdUniqueId cRG = BdUniqueId.gen();
    public static final BdUniqueId fMX = BdUniqueId.gen();
    public static final BdUniqueId fMY = BdUniqueId.gen();
    public static final BdUniqueId fMZ = BdUniqueId.gen();
    public static final BdUniqueId fNa = BdUniqueId.gen();
    public static final BdUniqueId fNb = BdUniqueId.gen();
    public static final BdUniqueId fNc = BdUniqueId.gen();
    public static final BdUniqueId fNd = BdUniqueId.gen();
    public static final BdUniqueId fNe = BdUniqueId.gen();
    public static final BdUniqueId fNf = BdUniqueId.gen();
    public static final BdUniqueId fNg = BdUniqueId.gen();
    public static final BdUniqueId fNh = BdUniqueId.gen();
    public static final BdUniqueId cRK = BdUniqueId.gen();
    public static final BdUniqueId cRL = BdUniqueId.gen();
    public boolean fNi = false;
    public boolean isLinkThread = false;
    public boolean fNj = false;
    public boolean cQU = false;
    public boolean cQV = false;
    public boolean fNk = false;
    public boolean cQY = false;
    public boolean cRa = false;
    public boolean cRb = false;
    public boolean fNl = false;
    public boolean fNm = false;
    public boolean cRe = false;
    public boolean cQZ = false;
    public boolean fNn = false;
    public boolean dxU = true;

    public static boolean aa(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRj || bjVar.getType() == bj.cRy || bjVar.getType() == bj.cRx || bjVar.getType() == bj.cRD || bjVar.getType() == bj.cRI;
    }

    public static boolean ac(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRK || bjVar.getType() == bj.cRL;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRf == null) {
            return TYPE;
        }
        if (this.cRf.threadType == 63) {
            return cRK;
        }
        if (this.cRf.threadType == 64) {
            return cRL;
        }
        if (this.cRf.isShareThread && this.cRf.cTQ != null) {
            if (this.cRf.cTQ.cPM) {
                OriginalThreadInfo originalThreadInfo = this.cRf.cTQ;
                if (originalThreadInfo.videoInfo != null) {
                    return cRG;
                }
                if (originalThreadInfo.aBd()) {
                    return cRF;
                }
                return cRE;
            }
            return cRD;
        } else if (this.cQU) {
            return fMY;
        } else {
            if (this.cQV) {
                return fMZ;
            }
            if (this.fNk) {
                return fNb;
            }
            if (this.cQY) {
                return fNc;
            }
            if (this.cQZ) {
                return fNd;
            }
            if (this.cRa) {
                return fNh;
            }
            if (this.cRb) {
                return fNg;
            }
            if (this.fNl) {
                return fNe;
            }
            if (this.fNm) {
                return fNf;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        if (this.cRf == null) {
            return this.cRf;
        }
        if (this.cRf.aCc() == 5) {
            return this.cRf;
        }
        this.cRf.jI(1);
        return this.cRf;
    }

    public boolean bvz() {
        return (this.cRf == null || v.getCount(this.cRf.aCC()) == 0) ? false : true;
    }

    public boolean bvA() {
        return this.cRf == null || this.cRf.aDn();
    }

    public boolean aBb() {
        return this.cRf != null && this.cRf.aBb();
    }

    public an bvB() {
        SmartApp aDa;
        if (bvz()) {
            an zW = zW(fMJ);
            if (zW != null) {
                zW.setPosition(this.position);
                if (aAg() != null) {
                    bj aAg = aAg();
                    zW.X("obj_name", aAg.aDM() != null && (aAg.aDM().cLc() != null || aAg.aDM().aUa() != null) ? 1 : 0);
                    if (aAg.aCo() != null) {
                        zW.X(TiebaInitialize.Params.AB_TYPE, aAg.aCo().hadConcerned() ? 1 : 0);
                    }
                    zW.X("is_full", aAg.aDZ() ? 1 : 0);
                }
            }
            return zW;
        } else if (bvA()) {
            an zW2 = zW(fMP);
            if (zW2 != null) {
                zW2.setPosition(this.position);
                if (aAg() != null && (aDa = aAg().aDa()) != null) {
                    zW2.cy("obj_type", aDa.id);
                    zW2.cy("obj_name", aDa.name);
                    return zW2;
                }
                return zW2;
            }
            return zW2;
        } else if (aBb()) {
            return null;
        } else {
            an zW3 = zW(fME);
            if (zW3 != null) {
                zW3.setPosition(this.position);
                zW3.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "show");
                if (aAg() != null) {
                    bj aAg2 = aAg();
                    boolean z = (aAg2.aDM() == null || (aAg2.aDM().cLc() == null && aAg2.aDM().aUa() == null)) ? false : true;
                    zW3.X("obj_name", z ? 1 : 0);
                    if (z && aAg2.aDM().cLc() != null && aAg2.aDM().cLc().aTS() != null && aAg2.aDM().cLc().aTS().size() > 0) {
                        zW3.X(TiebaInitialize.Params.OBJ_TO, aAg2.aDM().khb ? 2 : 1);
                    }
                    if (aAg2.aCo() != null) {
                        zW3.X(TiebaInitialize.Params.AB_TYPE, aAg2.aCo().hadConcerned() ? 1 : 0);
                    }
                    zW3.X("is_full", aAg2.aDZ() ? 1 : 0);
                    if (aAg2.getBaijiahaoData() != null) {
                        zW3.cy("obj_param4", aAg2.getBaijiahaoData().oriUgcNid);
                    }
                    zW3.X("obj_param5", ae(aAg2));
                }
            }
            return zW3;
        }
    }

    public an zY(String str) {
        int i;
        an anVar = new an(str);
        if (this.cRf != null) {
            if (this.cRf.getBaijiahaoData() == null) {
                anVar.s("fid", this.cRf.getFid());
                anVar.cy("tid", this.cRf.getTid());
            } else {
                anVar.cy("tid", this.cRf.getBaijiahaoData().oriUgcNid);
            }
            if (this.cRf.aBb()) {
                i = 2;
            } else if (this.cRf.isLinkThread()) {
                i = 4;
            } else if (this.cRf.isShareThread) {
                i = 5;
            } else if (this.cRf.aBd()) {
                i = 6;
            } else if (this.cRf.aEg()) {
                i = 7;
            } else if (this.cRf.aBe()) {
                i = 8;
            } else {
                i = this.cRf.aEh() ? 9 : 1;
            }
            anVar.X("obj_type", i);
            anVar.cy("obj_id", this.cRf.aCo().getUserId());
            anVar.X("obj_param1", bvv() ? 2 : 1);
        }
        return anVar;
    }

    public an zZ(String str) {
        an zW = zW(str);
        if (zW != null) {
            zW.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "show");
            if (aAg() != null) {
                bj aAg = aAg();
                boolean z = (aAg.aDM() == null || (aAg.aDM().cLc() == null && aAg.aDM().aUa() == null)) ? false : true;
                zW.X("obj_name", z ? 1 : 0);
                if (z && aAg.aDM().cLc() != null && aAg.aDM().cLc().aTS() != null && aAg.aDM().cLc().aTS().size() > 0) {
                    zW.X(TiebaInitialize.Params.OBJ_TO, aAg.aDM().khb ? 2 : 1);
                }
            }
        }
        return zW;
    }

    public an bvC() {
        an zW;
        SmartApp aDa;
        if (bvz()) {
            zW = zW(fMK);
        } else if (bvA()) {
            an zW2 = zW(fMQ);
            if (zW2 != null && aAg() != null && (aDa = aAg().aDa()) != null) {
                zW2.cy("obj_type", aDa.id);
                zW2.cy("obj_name", aDa.name);
                return zW2;
            }
            return zW2;
        } else {
            zW = zW(fMF);
            if (zW != null) {
                zW.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAg() != null) {
                    bj aAg = aAg();
                    if (aAg.getBaijiahaoData() != null) {
                        zW.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                    }
                    zW.X("obj_param5", ae(aAg));
                }
            }
        }
        if (zW != null && aAg() != null) {
            zW.X("is_full", aAg().aDZ() ? 1 : 0);
        }
        return zW;
    }

    public an bvD() {
        if (bvz()) {
            return zW(fML);
        }
        if (l.aa(this.cRf)) {
            an af = af(fMT, true);
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
        an ax = ax(fMG, 0);
        if (ax != null) {
            ax.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "click");
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

    public an bvE() {
        if (l.aa(this.cRf)) {
            an af = af(fMS, true);
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
        } else if (bvz()) {
            return zW(fMM);
        } else {
            an zW = zW(fMH);
            if (zW != null) {
                zW.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAg() != null) {
                    bj aAg2 = aAg();
                    if (aAg2.getBaijiahaoData() != null) {
                        zW.cy("obj_param4", aAg2.getBaijiahaoData().oriUgcNid);
                    }
                    zW.X("obj_param5", ae(aAg2));
                    return zW;
                }
                return zW;
            }
            return zW;
        }
    }

    public an bvF() {
        if (bvz()) {
            return zW(fMN);
        }
        an zW = zW(fMI);
        if (zW != null) {
            zW.cy(TiebaInitialize.Params.AB_TAG, bvr()).cy(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAg() != null) {
                bj aAg = aAg();
                if (aAg.getBaijiahaoData() != null) {
                    zW.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                }
                zW.X("obj_param5", ae(aAg));
                return zW;
            }
            return zW;
        }
        return zW;
    }

    public an bvG() {
        return zW(fMO);
    }

    public an bvH() {
        an af = af(fMR, true);
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

    public an Aa(String str) {
        an zW = zW(str);
        if (this.cRf != null && this.cRf.aCo() != null) {
            zW.X(TiebaInitialize.Params.AB_TYPE, this.cRf.aCo().hadConcerned() ? 1 : 0);
        }
        return zW;
    }

    public an Ab(String str) {
        return zW(str);
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
