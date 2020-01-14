package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class k extends c {
    public static String fKg = "";
    public static String fKh = "";
    public static String fKi = "";
    public static String fKj = "";
    public static String fKk = "";
    public static String fKl = "";
    public static String fKm = "";
    public static String fKn = "";
    public static String fKo = "";
    public static String fKp = "";
    public static String fKq = "";
    public static String fKr = "";
    public static String fKs = "";
    public static String fKt = "";
    public static String fKu = "";
    public static String fKv = "";
    public static String fKw = "";
    public static String fKx = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId fKy = BdUniqueId.gen();
    public static final BdUniqueId cNt = BdUniqueId.gen();
    public static final BdUniqueId cNz = BdUniqueId.gen();
    public static final BdUniqueId cNA = BdUniqueId.gen();
    public static final BdUniqueId cNB = BdUniqueId.gen();
    public static final BdUniqueId cNC = BdUniqueId.gen();
    public static final BdUniqueId fKz = BdUniqueId.gen();
    public static final BdUniqueId fKA = BdUniqueId.gen();
    public static final BdUniqueId fKB = BdUniqueId.gen();
    public static final BdUniqueId fKC = BdUniqueId.gen();
    public static final BdUniqueId fKD = BdUniqueId.gen();
    public static final BdUniqueId fKE = BdUniqueId.gen();
    public static final BdUniqueId fKF = BdUniqueId.gen();
    public static final BdUniqueId fKG = BdUniqueId.gen();
    public static final BdUniqueId fKH = BdUniqueId.gen();
    public static final BdUniqueId fKI = BdUniqueId.gen();
    public static final BdUniqueId fKJ = BdUniqueId.gen();
    public static final BdUniqueId cNG = BdUniqueId.gen();
    public static final BdUniqueId cNH = BdUniqueId.gen();
    public boolean fKK = false;
    public boolean isLinkThread = false;
    public boolean fKL = false;
    public boolean cMQ = false;
    public boolean cMR = false;
    public boolean fKM = false;
    public boolean cMU = false;
    public boolean cMW = false;
    public boolean cMX = false;
    public boolean fKN = false;
    public boolean fKO = false;
    public boolean cNa = false;
    public boolean cMV = false;
    public boolean fKP = false;
    public boolean dtN = true;

    public static boolean Z(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cNf || bjVar.getType() == bj.cNu || bjVar.getType() == bj.cNt || bjVar.getType() == bj.cNz || bjVar.getType() == bj.cNE;
    }

    public static boolean ab(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.cNG || bjVar.getType() == bj.cNH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cNb == null) {
            return TYPE;
        }
        if (this.cNb.threadType == 63) {
            return cNG;
        }
        if (this.cNb.threadType == 64) {
            return cNH;
        }
        if (this.cNb.isShareThread && this.cNb.cPN != null) {
            if (this.cNb.cPN.cLI) {
                OriginalThreadInfo originalThreadInfo = this.cNb.cPN;
                if (originalThreadInfo.videoInfo != null) {
                    return cNC;
                }
                if (originalThreadInfo.ayL()) {
                    return cNB;
                }
                return cNA;
            }
            return cNz;
        } else if (this.cMQ) {
            return fKA;
        } else {
            if (this.cMR) {
                return fKB;
            }
            if (this.fKM) {
                return fKD;
            }
            if (this.cMU) {
                return fKE;
            }
            if (this.cMV) {
                return fKF;
            }
            if (this.cMW) {
                return fKJ;
            }
            if (this.cMX) {
                return fKI;
            }
            if (this.fKN) {
                return fKG;
            }
            if (this.fKO) {
                return fKH;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axQ() {
        if (this.cNb == null) {
            return this.cNb;
        }
        if (this.cNb.azL() == 5) {
            return this.cNb;
        }
        this.cNb.jr(1);
        return this.cNb;
    }

    public boolean btT() {
        return (this.cNb == null || v.getCount(this.cNb.aAl()) == 0) ? false : true;
    }

    public boolean btU() {
        return this.cNb == null || this.cNb.aAY();
    }

    public boolean aAX() {
        return this.cNb != null && this.cNb.aAX();
    }

    public an btV() {
        SmartApp aAJ;
        if (btT()) {
            an zG = zG(fKl);
            if (zG != null) {
                zG.setPosition(this.position);
                if (axQ() != null) {
                    bj axQ = axQ();
                    zG.Z("obj_name", axQ.aBx() != null && (axQ.aBx().cJB() != null || axQ.aBx().aRH() != null) ? 1 : 0);
                    if (axQ.azX() != null) {
                        zG.Z(TiebaInitialize.Params.AB_TYPE, axQ.azX().hadConcerned() ? 1 : 0);
                    }
                    zG.Z("is_full", axQ.aBL() ? 1 : 0);
                }
            }
            return zG;
        } else if (btU()) {
            an zG2 = zG(fKr);
            if (zG2 != null) {
                zG2.setPosition(this.position);
                if (axQ() != null && (aAJ = axQ().aAJ()) != null) {
                    zG2.cp("obj_type", aAJ.id);
                    zG2.cp("obj_name", aAJ.name);
                    return zG2;
                }
                return zG2;
            }
            return zG2;
        } else if (aAX()) {
            return null;
        } else {
            an zG3 = zG(fKg);
            if (zG3 != null) {
                zG3.setPosition(this.position);
                zG3.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "show");
                if (axQ() != null) {
                    bj axQ2 = axQ();
                    boolean z = (axQ2.aBx() == null || (axQ2.aBx().cJB() == null && axQ2.aBx().aRH() == null)) ? false : true;
                    zG3.Z("obj_name", z ? 1 : 0);
                    if (z && axQ2.aBx().cJB() != null && axQ2.aBx().cJB().aRz() != null && axQ2.aBx().cJB().aRz().size() > 0) {
                        zG3.Z(TiebaInitialize.Params.OBJ_TO, axQ2.aBx().kfY ? 2 : 1);
                    }
                    if (axQ2.azX() != null) {
                        zG3.Z(TiebaInitialize.Params.AB_TYPE, axQ2.azX().hadConcerned() ? 1 : 0);
                    }
                    zG3.Z("is_full", axQ2.aBL() ? 1 : 0);
                    if (axQ2.getBaijiahaoData() != null) {
                        zG3.cp("obj_param4", axQ2.getBaijiahaoData().oriUgcNid);
                    }
                    zG3.Z("obj_param5", ad(axQ2));
                }
            }
            return zG3;
        }
    }

    public an zI(String str) {
        int i;
        an anVar = new an(str);
        if (this.cNb != null) {
            if (this.cNb.getBaijiahaoData() == null) {
                anVar.s("fid", this.cNb.getFid());
                anVar.cp("tid", this.cNb.getTid());
            } else {
                anVar.cp("tid", this.cNb.getBaijiahaoData().oriUgcNid);
            }
            if (this.cNb.aAX()) {
                i = 2;
            } else if (this.cNb.isLinkThread()) {
                i = 4;
            } else if (this.cNb.isShareThread) {
                i = 5;
            } else if (this.cNb.ayL()) {
                i = 6;
            } else if (this.cNb.aBT()) {
                i = 7;
            } else if (this.cNb.aBS()) {
                i = 8;
            } else {
                i = this.cNb.aBU() ? 9 : 1;
            }
            anVar.Z("obj_type", i);
            anVar.cp("obj_id", this.cNb.azX().getUserId());
            anVar.Z("obj_param1", btP() ? 2 : 1);
        }
        return anVar;
    }

    public an zJ(String str) {
        an zG = zG(str);
        if (zG != null) {
            zG.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "show");
            if (axQ() != null) {
                bj axQ = axQ();
                boolean z = (axQ.aBx() == null || (axQ.aBx().cJB() == null && axQ.aBx().aRH() == null)) ? false : true;
                zG.Z("obj_name", z ? 1 : 0);
                if (z && axQ.aBx().cJB() != null && axQ.aBx().cJB().aRz() != null && axQ.aBx().cJB().aRz().size() > 0) {
                    zG.Z(TiebaInitialize.Params.OBJ_TO, axQ.aBx().kfY ? 2 : 1);
                }
            }
        }
        return zG;
    }

    public an btW() {
        an zG;
        SmartApp aAJ;
        if (btT()) {
            zG = zG(fKm);
        } else if (btU()) {
            an zG2 = zG(fKs);
            if (zG2 != null && axQ() != null && (aAJ = axQ().aAJ()) != null) {
                zG2.cp("obj_type", aAJ.id);
                zG2.cp("obj_name", aAJ.name);
                return zG2;
            }
            return zG2;
        } else {
            zG = zG(fKh);
            if (zG != null) {
                zG.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "click");
                if (axQ() != null) {
                    bj axQ = axQ();
                    if (axQ.getBaijiahaoData() != null) {
                        zG.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                    }
                    zG.Z("obj_param5", ad(axQ));
                }
            }
        }
        if (zG != null && axQ() != null) {
            zG.Z("is_full", axQ().aBL() ? 1 : 0);
        }
        return zG;
    }

    public an btX() {
        if (btT()) {
            return zG(fKn);
        }
        if (l.Z(this.cNb)) {
            an af = af(fKv, true);
            if (af != null && axQ() != null) {
                bj axQ = axQ();
                if (axQ.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ad(axQ));
                return af;
            }
            return af;
        }
        an az = az(fKi, 0);
        if (az != null) {
            az.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "click");
            if (axQ() != null) {
                bj axQ2 = axQ();
                if (axQ2.getBaijiahaoData() != null) {
                    az.cp("obj_param4", axQ2.getBaijiahaoData().oriUgcNid);
                }
                az.Z("obj_param5", ad(axQ2));
                return az;
            }
            return az;
        }
        return az;
    }

    public an btY() {
        if (l.Z(this.cNb)) {
            an af = af(fKu, true);
            if (af != null && axQ() != null) {
                bj axQ = axQ();
                if (axQ.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ad(axQ));
                return af;
            }
            return af;
        } else if (btT()) {
            return zG(fKo);
        } else {
            an zG = zG(fKj);
            if (zG != null) {
                zG.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "click");
                if (axQ() != null) {
                    bj axQ2 = axQ();
                    if (axQ2.getBaijiahaoData() != null) {
                        zG.cp("obj_param4", axQ2.getBaijiahaoData().oriUgcNid);
                    }
                    zG.Z("obj_param5", ad(axQ2));
                    return zG;
                }
                return zG;
            }
            return zG;
        }
    }

    public an btZ() {
        if (btT()) {
            return zG(fKp);
        }
        an zG = zG(fKk);
        if (zG != null) {
            zG.cp(TiebaInitialize.Params.AB_TAG, btL()).cp(TiebaInitialize.Params.AB_ACTION, "click");
            if (axQ() != null) {
                bj axQ = axQ();
                if (axQ.getBaijiahaoData() != null) {
                    zG.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                }
                zG.Z("obj_param5", ad(axQ));
                return zG;
            }
            return zG;
        }
        return zG;
    }

    public an bua() {
        return zG(fKq);
    }

    public an bub() {
        an af = af(fKt, true);
        if (axQ() != null) {
            bj axQ = axQ();
            if (axQ.getBaijiahaoData() != null) {
                af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ad(axQ));
        }
        return af;
    }

    public an zK(String str) {
        an zG = zG(str);
        if (this.cNb != null && this.cNb.azX() != null) {
            zG.Z(TiebaInitialize.Params.AB_TYPE, this.cNb.azX().hadConcerned() ? 1 : 0);
        }
        return zG;
    }

    public an zL(String str) {
        return zG(str);
    }

    public int ac(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.ayL()) {
            return 1;
        }
        if (bjVar.aAX()) {
            return 2;
        }
        if (bjVar.aBT()) {
            return 3;
        }
        return bjVar.aBU() ? 4 : 0;
    }

    public int ad(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aBU() || bjVar.aBT()) {
            return 2;
        }
        return (bjVar.ayL() || bjVar.aBS()) ? 3 : 1;
    }
}
