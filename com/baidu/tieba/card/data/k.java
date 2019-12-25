package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class k extends c {
    public static String fGW = "";
    public static String fGX = "";
    public static String fGY = "";
    public static String fGZ = "";
    public static String fHa = "";
    public static String fHb = "";
    public static String fHc = "";
    public static String fHd = "";
    public static String fHe = "";
    public static String fHf = "";
    public static String fHg = "";
    public static String fHh = "";
    public static String fHi = "";
    public static String fHj = "";
    public static String fHk = "";
    public static String fHl = "";
    public static String fHm = "";
    public static String fHn = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fHo = BdUniqueId.gen();
    public static final BdUniqueId cNj = BdUniqueId.gen();
    public static final BdUniqueId cNp = BdUniqueId.gen();
    public static final BdUniqueId cNq = BdUniqueId.gen();
    public static final BdUniqueId cNr = BdUniqueId.gen();
    public static final BdUniqueId cNs = BdUniqueId.gen();
    public static final BdUniqueId fHp = BdUniqueId.gen();
    public static final BdUniqueId fHq = BdUniqueId.gen();
    public static final BdUniqueId fHr = BdUniqueId.gen();
    public static final BdUniqueId fHs = BdUniqueId.gen();
    public static final BdUniqueId fHt = BdUniqueId.gen();
    public static final BdUniqueId fHu = BdUniqueId.gen();
    public static final BdUniqueId fHv = BdUniqueId.gen();
    public static final BdUniqueId fHw = BdUniqueId.gen();
    public static final BdUniqueId fHx = BdUniqueId.gen();
    public static final BdUniqueId fHy = BdUniqueId.gen();
    public static final BdUniqueId fHz = BdUniqueId.gen();
    public static final BdUniqueId cNw = BdUniqueId.gen();
    public static final BdUniqueId cNx = BdUniqueId.gen();
    public boolean fHA = false;
    public boolean isLinkThread = false;
    public boolean fHB = false;
    public boolean cMG = false;
    public boolean cMH = false;
    public boolean fHC = false;
    public boolean cMK = false;
    public boolean cMM = false;
    public boolean cMN = false;
    public boolean fHD = false;
    public boolean fHE = false;
    public boolean cMQ = false;
    public boolean cML = false;
    public boolean fHF = false;
    public boolean dtC = true;

    public static boolean Y(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cMV || bjVar.getType() == bj.cNk || bjVar.getType() == bj.cNj || bjVar.getType() == bj.cNp || bjVar.getType() == bj.cNu;
    }

    public static boolean aa(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cNw || bjVar.getType() == bj.cNx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cMR == null) {
            return TYPE;
        }
        if (this.cMR.threadType == 63) {
            return cNw;
        }
        if (this.cMR.threadType == 64) {
            return cNx;
        }
        if (this.cMR.isShareThread && this.cMR.cPD != null) {
            if (this.cMR.cPD.cLy) {
                OriginalThreadInfo originalThreadInfo = this.cMR.cPD;
                if (originalThreadInfo.videoInfo != null) {
                    return cNs;
                }
                if (originalThreadInfo.ays()) {
                    return cNr;
                }
                return cNq;
            }
            return cNp;
        } else if (this.cMG) {
            return fHq;
        } else {
            if (this.cMH) {
                return fHr;
            }
            if (this.fHC) {
                return fHt;
            }
            if (this.cMK) {
                return fHu;
            }
            if (this.cML) {
                return fHv;
            }
            if (this.cMM) {
                return fHz;
            }
            if (this.cMN) {
                return fHy;
            }
            if (this.fHD) {
                return fHw;
            }
            if (this.fHE) {
                return fHx;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        if (this.cMR == null) {
            return this.cMR;
        }
        if (this.cMR.azs() == 5) {
            return this.cMR;
        }
        this.cMR.jr(1);
        return this.cMR;
    }

    public boolean bsR() {
        return (this.cMR == null || v.getCount(this.cMR.azS()) == 0) ? false : true;
    }

    public boolean bsS() {
        return this.cMR == null || this.cMR.aAF();
    }

    public boolean aAE() {
        return this.cMR != null && this.cMR.aAE();
    }

    public an bsT() {
        SmartApp aAq;
        if (bsR()) {
            an zw = zw(fHb);
            if (zw != null) {
                zw.setPosition(this.position);
                if (axx() != null) {
                    bj axx = axx();
                    zw.Z("obj_name", axx.aBe() != null && (axx.aBe().cIv() != null || axx.aBe().aRn() != null) ? 1 : 0);
                    if (axx.azE() != null) {
                        zw.Z(TiebaInitialize.Params.AB_TYPE, axx.azE().hadConcerned() ? 1 : 0);
                    }
                    zw.Z("is_full", axx.aBs() ? 1 : 0);
                }
            }
            return zw;
        } else if (bsS()) {
            an zw2 = zw(fHh);
            if (zw2 != null) {
                zw2.setPosition(this.position);
                if (axx() != null && (aAq = axx().aAq()) != null) {
                    zw2.cp("obj_type", aAq.id);
                    zw2.cp("obj_name", aAq.name);
                    return zw2;
                }
                return zw2;
            }
            return zw2;
        } else if (aAE()) {
            return null;
        } else {
            an zw3 = zw(fGW);
            if (zw3 != null) {
                zw3.setPosition(this.position);
                zw3.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "show");
                if (axx() != null) {
                    bj axx2 = axx();
                    boolean z = (axx2.aBe() == null || (axx2.aBe().cIv() == null && axx2.aBe().aRn() == null)) ? false : true;
                    zw3.Z("obj_name", z ? 1 : 0);
                    if (z && axx2.aBe().cIv() != null && axx2.aBe().cIv().aRf() != null && axx2.aBe().cIv().aRf().size() > 0) {
                        zw3.Z(TiebaInitialize.Params.OBJ_TO, axx2.aBe().kcq ? 2 : 1);
                    }
                    if (axx2.azE() != null) {
                        zw3.Z(TiebaInitialize.Params.AB_TYPE, axx2.azE().hadConcerned() ? 1 : 0);
                    }
                    zw3.Z("is_full", axx2.aBs() ? 1 : 0);
                    if (axx2.getBaijiahaoData() != null) {
                        zw3.cp("obj_param4", axx2.getBaijiahaoData().oriUgcNid);
                    }
                    zw3.Z("obj_param5", ac(axx2));
                }
            }
            return zw3;
        }
    }

    public an zy(String str) {
        int i;
        an anVar = new an(str);
        if (this.cMR != null) {
            if (this.cMR.getBaijiahaoData() == null) {
                anVar.s("fid", this.cMR.getFid());
                anVar.cp("tid", this.cMR.getTid());
            } else {
                anVar.cp("tid", this.cMR.getBaijiahaoData().oriUgcNid);
            }
            if (this.cMR.aAE()) {
                i = 2;
            } else if (this.cMR.isLinkThread()) {
                i = 4;
            } else if (this.cMR.isShareThread) {
                i = 5;
            } else if (this.cMR.ays()) {
                i = 6;
            } else if (this.cMR.aBA()) {
                i = 7;
            } else if (this.cMR.aBz()) {
                i = 8;
            } else {
                i = this.cMR.aBB() ? 9 : 1;
            }
            anVar.Z("obj_type", i);
            anVar.cp("obj_id", this.cMR.azE().getUserId());
            anVar.Z("obj_param1", bsN() ? 2 : 1);
        }
        return anVar;
    }

    public an zz(String str) {
        an zw = zw(str);
        if (zw != null) {
            zw.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "show");
            if (axx() != null) {
                bj axx = axx();
                boolean z = (axx.aBe() == null || (axx.aBe().cIv() == null && axx.aBe().aRn() == null)) ? false : true;
                zw.Z("obj_name", z ? 1 : 0);
                if (z && axx.aBe().cIv() != null && axx.aBe().cIv().aRf() != null && axx.aBe().cIv().aRf().size() > 0) {
                    zw.Z(TiebaInitialize.Params.OBJ_TO, axx.aBe().kcq ? 2 : 1);
                }
            }
        }
        return zw;
    }

    public an bsU() {
        an zw;
        SmartApp aAq;
        if (bsR()) {
            zw = zw(fHc);
        } else if (bsS()) {
            an zw2 = zw(fHi);
            if (zw2 != null && axx() != null && (aAq = axx().aAq()) != null) {
                zw2.cp("obj_type", aAq.id);
                zw2.cp("obj_name", aAq.name);
                return zw2;
            }
            return zw2;
        } else {
            zw = zw(fGX);
            if (zw != null) {
                zw.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "click");
                if (axx() != null) {
                    bj axx = axx();
                    if (axx.getBaijiahaoData() != null) {
                        zw.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                    }
                    zw.Z("obj_param5", ac(axx));
                }
            }
        }
        if (zw != null && axx() != null) {
            zw.Z("is_full", axx().aBs() ? 1 : 0);
        }
        return zw;
    }

    public an bsV() {
        if (bsR()) {
            return zw(fHd);
        }
        if (l.Y(this.cMR)) {
            an af = af(fHl, true);
            if (af != null && axx() != null) {
                bj axx = axx();
                if (axx.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ac(axx));
                return af;
            }
            return af;
        }
        an ay = ay(fGY, 0);
        if (ay != null) {
            ay.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "click");
            if (axx() != null) {
                bj axx2 = axx();
                if (axx2.getBaijiahaoData() != null) {
                    ay.cp("obj_param4", axx2.getBaijiahaoData().oriUgcNid);
                }
                ay.Z("obj_param5", ac(axx2));
                return ay;
            }
            return ay;
        }
        return ay;
    }

    public an bsW() {
        if (l.Y(this.cMR)) {
            an af = af(fHk, true);
            if (af != null && axx() != null) {
                bj axx = axx();
                if (axx.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ac(axx));
                return af;
            }
            return af;
        } else if (bsR()) {
            return zw(fHe);
        } else {
            an zw = zw(fGZ);
            if (zw != null) {
                zw.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "click");
                if (axx() != null) {
                    bj axx2 = axx();
                    if (axx2.getBaijiahaoData() != null) {
                        zw.cp("obj_param4", axx2.getBaijiahaoData().oriUgcNid);
                    }
                    zw.Z("obj_param5", ac(axx2));
                    return zw;
                }
                return zw;
            }
            return zw;
        }
    }

    public an bsX() {
        if (bsR()) {
            return zw(fHf);
        }
        an zw = zw(fHa);
        if (zw != null) {
            zw.cp(TiebaInitialize.Params.AB_TAG, bsJ()).cp(TiebaInitialize.Params.AB_ACTION, "click");
            if (axx() != null) {
                bj axx = axx();
                if (axx.getBaijiahaoData() != null) {
                    zw.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                }
                zw.Z("obj_param5", ac(axx));
                return zw;
            }
            return zw;
        }
        return zw;
    }

    public an bsY() {
        return zw(fHg);
    }

    public an bsZ() {
        an af = af(fHj, true);
        if (axx() != null) {
            bj axx = axx();
            if (axx.getBaijiahaoData() != null) {
                af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ac(axx));
        }
        return af;
    }

    public an zA(String str) {
        an zw = zw(str);
        if (this.cMR != null && this.cMR.azE() != null) {
            zw.Z(TiebaInitialize.Params.AB_TYPE, this.cMR.azE().hadConcerned() ? 1 : 0);
        }
        return zw;
    }

    public an zB(String str) {
        return zw(str);
    }

    public int ab(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.ays()) {
            return 1;
        }
        if (bjVar.aAE()) {
            return 2;
        }
        if (bjVar.aBA()) {
            return 3;
        }
        return bjVar.aBB() ? 4 : 0;
    }

    public int ac(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aBB() || bjVar.aBA()) {
            return 2;
        }
        return (bjVar.ays() || bjVar.aBz()) ? 3 : 1;
    }
}
