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
    public static String fMC = "";
    public static String fMD = "";
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
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fMU = BdUniqueId.gen();
    public static final BdUniqueId cRw = BdUniqueId.gen();
    public static final BdUniqueId cRC = BdUniqueId.gen();
    public static final BdUniqueId cRD = BdUniqueId.gen();
    public static final BdUniqueId cRE = BdUniqueId.gen();
    public static final BdUniqueId cRF = BdUniqueId.gen();
    public static final BdUniqueId fMV = BdUniqueId.gen();
    public static final BdUniqueId fMW = BdUniqueId.gen();
    public static final BdUniqueId fMX = BdUniqueId.gen();
    public static final BdUniqueId fMY = BdUniqueId.gen();
    public static final BdUniqueId fMZ = BdUniqueId.gen();
    public static final BdUniqueId fNa = BdUniqueId.gen();
    public static final BdUniqueId fNb = BdUniqueId.gen();
    public static final BdUniqueId fNc = BdUniqueId.gen();
    public static final BdUniqueId fNd = BdUniqueId.gen();
    public static final BdUniqueId fNe = BdUniqueId.gen();
    public static final BdUniqueId fNf = BdUniqueId.gen();
    public static final BdUniqueId cRJ = BdUniqueId.gen();
    public static final BdUniqueId cRK = BdUniqueId.gen();
    public boolean fNg = false;
    public boolean isLinkThread = false;
    public boolean fNh = false;
    public boolean cQT = false;
    public boolean cQU = false;
    public boolean fNi = false;
    public boolean cQX = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    public boolean fNj = false;
    public boolean fNk = false;
    public boolean cRd = false;
    public boolean cQY = false;
    public boolean fNl = false;
    public boolean dxT = true;

    public static boolean aa(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRi || bjVar.getType() == bj.cRx || bjVar.getType() == bj.cRw || bjVar.getType() == bj.cRC || bjVar.getType() == bj.cRH;
    }

    public static boolean ac(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cRJ || bjVar.getType() == bj.cRK;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRe == null) {
            return TYPE;
        }
        if (this.cRe.threadType == 63) {
            return cRJ;
        }
        if (this.cRe.threadType == 64) {
            return cRK;
        }
        if (this.cRe.isShareThread && this.cRe.cTP != null) {
            if (this.cRe.cTP.cPL) {
                OriginalThreadInfo originalThreadInfo = this.cRe.cTP;
                if (originalThreadInfo.videoInfo != null) {
                    return cRF;
                }
                if (originalThreadInfo.aBb()) {
                    return cRE;
                }
                return cRD;
            }
            return cRC;
        } else if (this.cQT) {
            return fMW;
        } else {
            if (this.cQU) {
                return fMX;
            }
            if (this.fNi) {
                return fMZ;
            }
            if (this.cQX) {
                return fNa;
            }
            if (this.cQY) {
                return fNb;
            }
            if (this.cQZ) {
                return fNf;
            }
            if (this.cRa) {
                return fNe;
            }
            if (this.fNj) {
                return fNc;
            }
            if (this.fNk) {
                return fNd;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAe() {
        if (this.cRe == null) {
            return this.cRe;
        }
        if (this.cRe.aCa() == 5) {
            return this.cRe;
        }
        this.cRe.jI(1);
        return this.cRe;
    }

    public boolean bvx() {
        return (this.cRe == null || v.getCount(this.cRe.aCA()) == 0) ? false : true;
    }

    public boolean bvy() {
        return this.cRe == null || this.cRe.aDl();
    }

    public boolean aAZ() {
        return this.cRe != null && this.cRe.aAZ();
    }

    public an bvz() {
        SmartApp aCY;
        if (bvx()) {
            an zW = zW(fMH);
            if (zW != null) {
                zW.setPosition(this.position);
                if (aAe() != null) {
                    bj aAe = aAe();
                    zW.X("obj_name", aAe.aDK() != null && (aAe.aDK().cLa() != null || aAe.aDK().aTY() != null) ? 1 : 0);
                    if (aAe.aCm() != null) {
                        zW.X(TiebaInitialize.Params.AB_TYPE, aAe.aCm().hadConcerned() ? 1 : 0);
                    }
                    zW.X("is_full", aAe.aDX() ? 1 : 0);
                }
            }
            return zW;
        } else if (bvy()) {
            an zW2 = zW(fMN);
            if (zW2 != null) {
                zW2.setPosition(this.position);
                if (aAe() != null && (aCY = aAe().aCY()) != null) {
                    zW2.cy("obj_type", aCY.id);
                    zW2.cy("obj_name", aCY.name);
                    return zW2;
                }
                return zW2;
            }
            return zW2;
        } else if (aAZ()) {
            return null;
        } else {
            an zW3 = zW(fMC);
            if (zW3 != null) {
                zW3.setPosition(this.position);
                zW3.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "show");
                if (aAe() != null) {
                    bj aAe2 = aAe();
                    boolean z = (aAe2.aDK() == null || (aAe2.aDK().cLa() == null && aAe2.aDK().aTY() == null)) ? false : true;
                    zW3.X("obj_name", z ? 1 : 0);
                    if (z && aAe2.aDK().cLa() != null && aAe2.aDK().cLa().aTQ() != null && aAe2.aDK().cLa().aTQ().size() > 0) {
                        zW3.X(TiebaInitialize.Params.OBJ_TO, aAe2.aDK().kgZ ? 2 : 1);
                    }
                    if (aAe2.aCm() != null) {
                        zW3.X(TiebaInitialize.Params.AB_TYPE, aAe2.aCm().hadConcerned() ? 1 : 0);
                    }
                    zW3.X("is_full", aAe2.aDX() ? 1 : 0);
                    if (aAe2.getBaijiahaoData() != null) {
                        zW3.cy("obj_param4", aAe2.getBaijiahaoData().oriUgcNid);
                    }
                    zW3.X("obj_param5", ae(aAe2));
                }
            }
            return zW3;
        }
    }

    public an zY(String str) {
        int i;
        an anVar = new an(str);
        if (this.cRe != null) {
            if (this.cRe.getBaijiahaoData() == null) {
                anVar.s("fid", this.cRe.getFid());
                anVar.cy("tid", this.cRe.getTid());
            } else {
                anVar.cy("tid", this.cRe.getBaijiahaoData().oriUgcNid);
            }
            if (this.cRe.aAZ()) {
                i = 2;
            } else if (this.cRe.isLinkThread()) {
                i = 4;
            } else if (this.cRe.isShareThread) {
                i = 5;
            } else if (this.cRe.aBb()) {
                i = 6;
            } else if (this.cRe.aEe()) {
                i = 7;
            } else if (this.cRe.aBc()) {
                i = 8;
            } else {
                i = this.cRe.aEf() ? 9 : 1;
            }
            anVar.X("obj_type", i);
            anVar.cy("obj_id", this.cRe.aCm().getUserId());
            anVar.X("obj_param1", bvt() ? 2 : 1);
        }
        return anVar;
    }

    public an zZ(String str) {
        an zW = zW(str);
        if (zW != null) {
            zW.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "show");
            if (aAe() != null) {
                bj aAe = aAe();
                boolean z = (aAe.aDK() == null || (aAe.aDK().cLa() == null && aAe.aDK().aTY() == null)) ? false : true;
                zW.X("obj_name", z ? 1 : 0);
                if (z && aAe.aDK().cLa() != null && aAe.aDK().cLa().aTQ() != null && aAe.aDK().cLa().aTQ().size() > 0) {
                    zW.X(TiebaInitialize.Params.OBJ_TO, aAe.aDK().kgZ ? 2 : 1);
                }
            }
        }
        return zW;
    }

    public an bvA() {
        an zW;
        SmartApp aCY;
        if (bvx()) {
            zW = zW(fMI);
        } else if (bvy()) {
            an zW2 = zW(fMO);
            if (zW2 != null && aAe() != null && (aCY = aAe().aCY()) != null) {
                zW2.cy("obj_type", aCY.id);
                zW2.cy("obj_name", aCY.name);
                return zW2;
            }
            return zW2;
        } else {
            zW = zW(fMD);
            if (zW != null) {
                zW.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAe() != null) {
                    bj aAe = aAe();
                    if (aAe.getBaijiahaoData() != null) {
                        zW.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                    }
                    zW.X("obj_param5", ae(aAe));
                }
            }
        }
        if (zW != null && aAe() != null) {
            zW.X("is_full", aAe().aDX() ? 1 : 0);
        }
        return zW;
    }

    public an bvB() {
        if (bvx()) {
            return zW(fMJ);
        }
        if (l.aa(this.cRe)) {
            an af = af(fMR, true);
            if (af != null && aAe() != null) {
                bj aAe = aAe();
                if (aAe.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAe));
                return af;
            }
            return af;
        }
        an ax = ax(fME, 0);
        if (ax != null) {
            ax.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAe() != null) {
                bj aAe2 = aAe();
                if (aAe2.getBaijiahaoData() != null) {
                    ax.cy("obj_param4", aAe2.getBaijiahaoData().oriUgcNid);
                }
                ax.X("obj_param5", ae(aAe2));
                return ax;
            }
            return ax;
        }
        return ax;
    }

    public an bvC() {
        if (l.aa(this.cRe)) {
            an af = af(fMQ, true);
            if (af != null && aAe() != null) {
                bj aAe = aAe();
                if (aAe.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAe));
                return af;
            }
            return af;
        } else if (bvx()) {
            return zW(fMK);
        } else {
            an zW = zW(fMF);
            if (zW != null) {
                zW.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "click");
                if (aAe() != null) {
                    bj aAe2 = aAe();
                    if (aAe2.getBaijiahaoData() != null) {
                        zW.cy("obj_param4", aAe2.getBaijiahaoData().oriUgcNid);
                    }
                    zW.X("obj_param5", ae(aAe2));
                    return zW;
                }
                return zW;
            }
            return zW;
        }
    }

    public an bvD() {
        if (bvx()) {
            return zW(fML);
        }
        an zW = zW(fMG);
        if (zW != null) {
            zW.cy(TiebaInitialize.Params.AB_TAG, bvp()).cy(TiebaInitialize.Params.AB_ACTION, "click");
            if (aAe() != null) {
                bj aAe = aAe();
                if (aAe.getBaijiahaoData() != null) {
                    zW.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                }
                zW.X("obj_param5", ae(aAe));
                return zW;
            }
            return zW;
        }
        return zW;
    }

    public an bvE() {
        return zW(fMM);
    }

    public an bvF() {
        an af = af(fMP, true);
        if (aAe() != null) {
            bj aAe = aAe();
            if (aAe.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAe));
        }
        return af;
    }

    public an Aa(String str) {
        an zW = zW(str);
        if (this.cRe != null && this.cRe.aCm() != null) {
            zW.X(TiebaInitialize.Params.AB_TYPE, this.cRe.aCm().hadConcerned() ? 1 : 0);
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
        if (bjVar.aBb()) {
            return 1;
        }
        if (bjVar.aAZ()) {
            return 2;
        }
        if (bjVar.aEe()) {
            return 3;
        }
        return bjVar.aEf() ? 4 : 0;
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEf() || bjVar.aEe()) {
            return 2;
        }
        return (bjVar.aBb() || bjVar.aBc()) ? 3 : 1;
    }
}
