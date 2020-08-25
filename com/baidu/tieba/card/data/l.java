package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes15.dex */
public class l extends c {
    public static String hmJ = "";
    public static String hmK = "";
    public static String hmL = "";
    public static String hmM = "";
    public static String hmN = "";
    public static String hmO = "";
    public static String hmP = "";
    public static String hmQ = "";
    public static String hmR = "";
    public static String hmS = "";
    public static String hmT = "";
    public static String hmU = "";
    public static String hmV = "";
    public static String hmW = "";
    public static String hmX = "";
    public static String hmY = "";
    public static String hmZ = "";
    public static String hna = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hnb = BdUniqueId.gen();
    public static final BdUniqueId ebm = BdUniqueId.gen();
    public static final BdUniqueId ebs = BdUniqueId.gen();
    public static final BdUniqueId ebt = BdUniqueId.gen();
    public static final BdUniqueId ebu = BdUniqueId.gen();
    public static final BdUniqueId ebv = BdUniqueId.gen();
    public static final BdUniqueId ebz = BdUniqueId.gen();
    public static final BdUniqueId ebA = BdUniqueId.gen();
    public static final BdUniqueId hnc = BdUniqueId.gen();
    public static final BdUniqueId eaW = BdUniqueId.gen();
    public static final BdUniqueId hnd = BdUniqueId.gen();
    public static final BdUniqueId hne = BdUniqueId.gen();
    public static final BdUniqueId hnf = BdUniqueId.gen();
    public static final BdUniqueId hng = BdUniqueId.gen();
    public static final BdUniqueId hnh = BdUniqueId.gen();
    public static final BdUniqueId hni = BdUniqueId.gen();
    public static final BdUniqueId hnj = BdUniqueId.gen();
    public static final BdUniqueId ebi = BdUniqueId.gen();
    public static final BdUniqueId ebk = BdUniqueId.gen();
    public static final BdUniqueId ebl = BdUniqueId.gen();
    public boolean hnk = false;
    public boolean isLinkThread = false;
    public boolean eaI = false;
    public boolean hnl = false;
    public boolean eay = false;
    public boolean eaO = false;
    public boolean eaK = false;
    public boolean eaE = false;
    public boolean eaz = false;
    public boolean hnm = false;
    public boolean eaC = false;
    public boolean eaD = false;
    public boolean eaF = false;
    public boolean hnn = false;
    public boolean eaM = false;
    public boolean eaN = false;
    public boolean hno = false;
    public boolean eLX = true;

    public static boolean aa(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.eaS || bwVar.getType() == bw.ebn || bwVar.getType() == bw.ebm || bwVar.getType() == bw.ebs || bwVar.getType() == bw.ebx;
    }

    public static boolean ac(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.ebz || bwVar.getType() == bw.ebA;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUS == null) {
            return TYPE;
        }
        if (this.dUS.threadType == 63) {
            return ebz;
        }
        if (this.dUS.threadType == 64) {
            return ebA;
        }
        if (this.dUS.isShareThread && this.dUS.edE != null) {
            if (this.dUS.edE.dZi) {
                OriginalThreadInfo originalThreadInfo = this.dUS.edE;
                if (originalThreadInfo.videoInfo != null) {
                    return ebv;
                }
                if (originalThreadInfo.bdm()) {
                    return ebu;
                }
                return ebt;
            }
            return ebs;
        } else if (this.eay) {
            return hnc;
        } else {
            if (this.eaz) {
                return hnd;
            }
            if (this.hnm) {
                return hne;
            }
            if (this.eaC) {
                return hnf;
            }
            if (this.eaD) {
                return hng;
            }
            if (this.eaE) {
                return hnh;
            }
            if (this.eaF) {
                return hnj;
            }
            if (this.hnn) {
                return hni;
            }
            if (this.eaO) {
                return eaW;
            }
            if (this.eaK) {
                return ebi;
            }
            if (this.eaM) {
                return ebk;
            }
            if (this.eaN) {
                return ebl;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        if (this.dUS == null) {
            return null;
        }
        if (this.dUS.bes() == 5) {
            return this.dUS;
        }
        this.dUS.nf(1);
        return this.dUS;
    }

    public boolean cct() {
        return (this.dUS == null || y.getCount(this.dUS.beR()) == 0) ? false : true;
    }

    public boolean ccu() {
        return this.dUS == null || this.dUS.bfH();
    }

    public boolean bdk() {
        return this.dUS != null && this.dUS.bdk();
    }

    public aq ccv() {
        SmartApp bft;
        if (cct()) {
            aq Hc = Hc(hmO);
            if (Hc != null) {
                Hc.setPosition(this.position);
                if (bce() != null) {
                    bw bce = bce();
                    Hc.ai("obj_name", bce.bgh() != null && (bce.bgh().dwH() != null || bce.bgh().bxE() != null) ? 1 : 0);
                    if (bce.beE() != null) {
                        Hc.ai(TiebaInitialize.Params.AB_TYPE, bce.beE().hadConcerned() ? 1 : 0);
                    }
                    Hc.ai("is_full", bce.bgu() ? 1 : 0);
                }
            }
            return Hc;
        } else if (ccu()) {
            aq Hc2 = Hc(hmU);
            if (Hc2 != null) {
                Hc2.setPosition(this.position);
                if (bce() != null && (bft = bce().bft()) != null) {
                    Hc2.dD("obj_type", bft.id);
                    Hc2.dD("obj_name", bft.name);
                    return Hc2;
                }
                return Hc2;
            }
            return Hc2;
        } else if (bdk()) {
            return null;
        } else {
            aq Hc3 = Hc(hmJ);
            if (Hc3 != null) {
                Hc3.setPosition(this.position);
                Hc3.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "show");
                if (bce() != null) {
                    bw bce2 = bce();
                    boolean z = (bce2.bgh() == null || (bce2.bgh().dwH() == null && bce2.bgh().bxE() == null)) ? false : true;
                    Hc3.ai("obj_name", z ? 1 : 0);
                    if (z && bce2.bgh().dwH() != null && bce2.bgh().dwH().bxw() != null && bce2.bgh().dwH().bxw().size() > 0) {
                        Hc3.ai(TiebaInitialize.Params.OBJ_TO, bce2.bgh().mft ? 2 : 1);
                    }
                    if (bce2.beE() != null) {
                        Hc3.ai(TiebaInitialize.Params.AB_TYPE, bce2.beE().hadConcerned() ? 1 : 0);
                    }
                    Hc3.ai("is_full", bce2.bgu() ? 1 : 0);
                    if (bce2.getBaijiahaoData() != null) {
                        Hc3.dD("obj_param4", bce2.getBaijiahaoData().oriUgcNid);
                    }
                    Hc3.ai("obj_param5", ae(bce2));
                    Hc3.dD("nid", bce2.getNid());
                    if (bce2.bgG()) {
                        Hc3.ai("obj_param6", 2);
                    } else {
                        Hc3.ai("obj_param6", 1);
                    }
                }
            }
            return Hc3;
        }
    }

    public aq He(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.dUS != null) {
            if (this.dUS.getBaijiahaoData() == null) {
                aqVar.u("fid", this.dUS.getFid());
                aqVar.dD("tid", this.dUS.getTid());
            } else {
                aqVar.dD("tid", this.dUS.getBaijiahaoData().oriUgcNid);
            }
            if (this.dUS.bdk()) {
                i = 2;
            } else if (this.dUS.isLinkThread()) {
                i = 4;
            } else if (this.dUS.isShareThread) {
                i = 5;
            } else if (this.dUS.bdm()) {
                i = 6;
            } else if (this.dUS.bgz()) {
                i = 7;
            } else if (this.dUS.bdn()) {
                i = 8;
            } else {
                i = this.dUS.bgA() ? 9 : 1;
            }
            aqVar.ai("obj_type", i);
            aqVar.dD("obj_id", this.dUS.beE().getUserId());
            aqVar.ai("obj_param1", cco() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Hf(String str) {
        aq Hc = Hc(str);
        if (Hc != null) {
            Hc.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "show");
            if (bce() != null) {
                bw bce = bce();
                boolean z = (bce.bgh() == null || (bce.bgh().dwH() == null && bce.bgh().bxE() == null)) ? false : true;
                Hc.ai("obj_name", z ? 1 : 0);
                if (z && bce.bgh().dwH() != null && bce.bgh().dwH().bxw() != null && bce.bgh().dwH().bxw().size() > 0) {
                    Hc.ai(TiebaInitialize.Params.OBJ_TO, bce.bgh().mft ? 2 : 1);
                }
            }
        }
        return Hc;
    }

    public aq ccw() {
        aq Hc;
        SmartApp bft;
        if (cct()) {
            Hc = Hc(hmP);
        } else if (ccu()) {
            aq Hc2 = Hc(hmV);
            if (Hc2 != null && bce() != null && (bft = bce().bft()) != null) {
                Hc2.dD("obj_type", bft.id);
                Hc2.dD("obj_name", bft.name);
                return Hc2;
            }
            return Hc2;
        } else {
            Hc = Hc(hmK);
            if (Hc != null) {
                Hc.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "click");
                if (bce() != null) {
                    bw bce = bce();
                    if (bce.getBaijiahaoData() != null) {
                        Hc.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                    }
                    Hc.ai("obj_param5", ae(bce));
                    Hc.dD("nid", bce.getNid());
                }
            }
        }
        if (Hc != null && bce() != null) {
            Hc.ai("is_full", bce().bgu() ? 1 : 0);
        }
        return Hc;
    }

    public aq ccx() {
        if (cct()) {
            return Hc(hmQ);
        }
        if (m.aa(this.dUS)) {
            aq aC = aC(hmY, true);
            if (aC != null && bce() != null) {
                bw bce = bce();
                if (bce.getBaijiahaoData() != null) {
                    aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                    aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", ae(bce));
                aC.dD("nid", bce.getNid());
                return aC;
            }
            return aC;
        }
        aq aJ = aJ(hmL, 0);
        if (aJ != null) {
            aJ.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "click");
            if (bce() != null) {
                bw bce2 = bce();
                if (bce2.getBaijiahaoData() != null) {
                    aJ.dD("obj_param4", bce2.getBaijiahaoData().oriUgcNid);
                }
                aJ.ai("obj_param5", ae(bce2));
                aJ.dD("nid", bce2.getNid());
                return aJ;
            }
            return aJ;
        }
        return aJ;
    }

    public aq ccy() {
        if (m.aa(this.dUS)) {
            aq aC = aC(hmX, true);
            if (aC != null && bce() != null) {
                bw bce = bce();
                if (bce.getBaijiahaoData() != null) {
                    aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                    aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", ae(bce));
                if (bce.bgG()) {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aC;
                }
                aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aC;
            }
            return aC;
        } else if (cct()) {
            return Hc(hmR);
        } else {
            aq Hc = Hc(hmM);
            if (Hc != null) {
                Hc.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "click");
                if (bce() != null) {
                    bw bce2 = bce();
                    if (bce2.getBaijiahaoData() != null) {
                        Hc.dD("obj_param4", bce2.getBaijiahaoData().oriUgcNid);
                    }
                    Hc.ai("obj_param5", ae(bce2));
                    Hc.dD("nid", bce2.getNid());
                    if (bce2.bgG()) {
                        Hc.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Hc;
                    }
                    Hc.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Hc;
                }
                return Hc;
            }
            return Hc;
        }
    }

    public aq ccz() {
        if (cct()) {
            return Hc(hmS);
        }
        aq Hc = Hc(hmN);
        if (Hc != null) {
            Hc.dD("ab_tag", cck()).dD(TiebaInitialize.Params.AB_ACTION, "click");
            if (bce() != null) {
                bw bce = bce();
                if (bce.getBaijiahaoData() != null) {
                    Hc.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                }
                Hc.ai("obj_param5", ae(bce));
                Hc.dD("nid", bce.getNid());
                return Hc;
            }
            return Hc;
        }
        return Hc;
    }

    public aq ccA() {
        return Hc(hmT);
    }

    public aq ccB() {
        aq aC = aC(hmW, true);
        if (bce() != null) {
            bw bce = bce();
            if (bce.getBaijiahaoData() != null) {
                aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
            }
            aC.ai("obj_param5", ae(bce));
            aC.dD("nid", bce.getNid());
        }
        return aC;
    }

    public aq Hg(String str) {
        aq Hc = Hc(str);
        if (this.dUS != null && this.dUS.beE() != null) {
            Hc.ai(TiebaInitialize.Params.AB_TYPE, this.dUS.beE().hadConcerned() ? 1 : 0);
        }
        return Hc;
    }

    public aq Hh(String str) {
        return Hc(str);
    }

    public int ad(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bdm()) {
            return 1;
        }
        if (bwVar.bdk()) {
            return 2;
        }
        if (bwVar.bgz()) {
            return 3;
        }
        return bwVar.bgA() ? 4 : 0;
    }

    public int ae(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        if (bwVar.bgA() || bwVar.bgz()) {
            return 2;
        }
        return (bwVar.bdm() || bwVar.bdn()) ? 3 : 1;
    }
}
