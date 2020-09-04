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
    public static String hnb = "";
    public static String hnc = "";
    public static String hnd = "";
    public static String hne = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hnf = BdUniqueId.gen();
    public static final BdUniqueId ebq = BdUniqueId.gen();
    public static final BdUniqueId ebw = BdUniqueId.gen();
    public static final BdUniqueId ebx = BdUniqueId.gen();
    public static final BdUniqueId eby = BdUniqueId.gen();
    public static final BdUniqueId ebz = BdUniqueId.gen();
    public static final BdUniqueId ebD = BdUniqueId.gen();
    public static final BdUniqueId ebE = BdUniqueId.gen();
    public static final BdUniqueId hng = BdUniqueId.gen();
    public static final BdUniqueId eba = BdUniqueId.gen();
    public static final BdUniqueId hnh = BdUniqueId.gen();
    public static final BdUniqueId hni = BdUniqueId.gen();
    public static final BdUniqueId hnj = BdUniqueId.gen();
    public static final BdUniqueId hnk = BdUniqueId.gen();
    public static final BdUniqueId hnl = BdUniqueId.gen();
    public static final BdUniqueId hnm = BdUniqueId.gen();
    public static final BdUniqueId hnn = BdUniqueId.gen();
    public static final BdUniqueId ebm = BdUniqueId.gen();
    public static final BdUniqueId ebo = BdUniqueId.gen();
    public static final BdUniqueId ebp = BdUniqueId.gen();
    public boolean hno = false;
    public boolean isLinkThread = false;
    public boolean eaM = false;
    public boolean hnp = false;
    public boolean eaC = false;
    public boolean eaS = false;
    public boolean eaO = false;
    public boolean eaI = false;
    public boolean eaD = false;
    public boolean hnq = false;
    public boolean eaG = false;
    public boolean eaH = false;
    public boolean eaJ = false;
    public boolean hnr = false;
    public boolean eaQ = false;
    public boolean eaR = false;
    public boolean hns = false;
    public boolean eMb = true;

    public static boolean aa(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.eaW || bwVar.getType() == bw.ebr || bwVar.getType() == bw.ebq || bwVar.getType() == bw.ebw || bwVar.getType() == bw.ebB;
    }

    public static boolean ac(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.ebD || bwVar.getType() == bw.ebE;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUW == null) {
            return TYPE;
        }
        if (this.dUW.threadType == 63) {
            return ebD;
        }
        if (this.dUW.threadType == 64) {
            return ebE;
        }
        if (this.dUW.isShareThread && this.dUW.edI != null) {
            if (this.dUW.edI.dZm) {
                OriginalThreadInfo originalThreadInfo = this.dUW.edI;
                if (originalThreadInfo.videoInfo != null) {
                    return ebz;
                }
                if (originalThreadInfo.bdm()) {
                    return eby;
                }
                return ebx;
            }
            return ebw;
        } else if (this.eaC) {
            return hng;
        } else {
            if (this.eaD) {
                return hnh;
            }
            if (this.hnq) {
                return hni;
            }
            if (this.eaG) {
                return hnj;
            }
            if (this.eaH) {
                return hnk;
            }
            if (this.eaI) {
                return hnl;
            }
            if (this.eaJ) {
                return hnn;
            }
            if (this.hnr) {
                return hnm;
            }
            if (this.eaS) {
                return eba;
            }
            if (this.eaO) {
                return ebm;
            }
            if (this.eaQ) {
                return ebo;
            }
            if (this.eaR) {
                return ebp;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        if (this.dUW == null) {
            return null;
        }
        if (this.dUW.bes() == 5) {
            return this.dUW;
        }
        this.dUW.nf(1);
        return this.dUW;
    }

    public boolean ccu() {
        return (this.dUW == null || y.getCount(this.dUW.beR()) == 0) ? false : true;
    }

    public boolean ccv() {
        return this.dUW == null || this.dUW.bfH();
    }

    public boolean bdk() {
        return this.dUW != null && this.dUW.bdk();
    }

    public aq ccw() {
        SmartApp bft;
        if (ccu()) {
            aq Hd = Hd(hmS);
            if (Hd != null) {
                Hd.setPosition(this.position);
                if (bce() != null) {
                    bw bce = bce();
                    Hd.ai("obj_name", bce.bgh() != null && (bce.bgh().dwM() != null || bce.bgh().bxF() != null) ? 1 : 0);
                    if (bce.beE() != null) {
                        Hd.ai(TiebaInitialize.Params.AB_TYPE, bce.beE().hadConcerned() ? 1 : 0);
                    }
                    Hd.ai("is_full", bce.bgu() ? 1 : 0);
                }
            }
            return Hd;
        } else if (ccv()) {
            aq Hd2 = Hd(hmY);
            if (Hd2 != null) {
                Hd2.setPosition(this.position);
                if (bce() != null && (bft = bce().bft()) != null) {
                    Hd2.dD("obj_type", bft.id);
                    Hd2.dD("obj_name", bft.name);
                    return Hd2;
                }
                return Hd2;
            }
            return Hd2;
        } else if (bdk()) {
            return null;
        } else {
            aq Hd3 = Hd(hmN);
            if (Hd3 != null) {
                Hd3.setPosition(this.position);
                Hd3.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "show");
                if (bce() != null) {
                    bw bce2 = bce();
                    boolean z = (bce2.bgh() == null || (bce2.bgh().dwM() == null && bce2.bgh().bxF() == null)) ? false : true;
                    Hd3.ai("obj_name", z ? 1 : 0);
                    if (z && bce2.bgh().dwM() != null && bce2.bgh().dwM().bxx() != null && bce2.bgh().dwM().bxx().size() > 0) {
                        Hd3.ai(TiebaInitialize.Params.OBJ_TO, bce2.bgh().mfI ? 2 : 1);
                    }
                    if (bce2.beE() != null) {
                        Hd3.ai(TiebaInitialize.Params.AB_TYPE, bce2.beE().hadConcerned() ? 1 : 0);
                    }
                    Hd3.ai("is_full", bce2.bgu() ? 1 : 0);
                    if (bce2.getBaijiahaoData() != null) {
                        Hd3.dD("obj_param4", bce2.getBaijiahaoData().oriUgcNid);
                    }
                    Hd3.ai("obj_param5", ae(bce2));
                    Hd3.dD("nid", bce2.getNid());
                    if (bce2.bgG()) {
                        Hd3.ai("obj_param6", 2);
                    } else {
                        Hd3.ai("obj_param6", 1);
                    }
                }
            }
            return Hd3;
        }
    }

    public aq Hf(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.dUW != null) {
            if (this.dUW.getBaijiahaoData() == null) {
                aqVar.u("fid", this.dUW.getFid());
                aqVar.dD("tid", this.dUW.getTid());
            } else {
                aqVar.dD("tid", this.dUW.getBaijiahaoData().oriUgcNid);
            }
            if (this.dUW.bdk()) {
                i = 2;
            } else if (this.dUW.isLinkThread()) {
                i = 4;
            } else if (this.dUW.isShareThread) {
                i = 5;
            } else if (this.dUW.bdm()) {
                i = 6;
            } else if (this.dUW.bgz()) {
                i = 7;
            } else if (this.dUW.bdn()) {
                i = 8;
            } else {
                i = this.dUW.bgA() ? 9 : 1;
            }
            aqVar.ai("obj_type", i);
            aqVar.dD("obj_id", this.dUW.beE().getUserId());
            aqVar.ai("obj_param1", ccp() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Hg(String str) {
        aq Hd = Hd(str);
        if (Hd != null) {
            Hd.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "show");
            if (bce() != null) {
                bw bce = bce();
                boolean z = (bce.bgh() == null || (bce.bgh().dwM() == null && bce.bgh().bxF() == null)) ? false : true;
                Hd.ai("obj_name", z ? 1 : 0);
                if (z && bce.bgh().dwM() != null && bce.bgh().dwM().bxx() != null && bce.bgh().dwM().bxx().size() > 0) {
                    Hd.ai(TiebaInitialize.Params.OBJ_TO, bce.bgh().mfI ? 2 : 1);
                }
            }
        }
        return Hd;
    }

    public aq ccx() {
        aq Hd;
        SmartApp bft;
        if (ccu()) {
            Hd = Hd(hmT);
        } else if (ccv()) {
            aq Hd2 = Hd(hmZ);
            if (Hd2 != null && bce() != null && (bft = bce().bft()) != null) {
                Hd2.dD("obj_type", bft.id);
                Hd2.dD("obj_name", bft.name);
                return Hd2;
            }
            return Hd2;
        } else {
            Hd = Hd(hmO);
            if (Hd != null) {
                Hd.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "click");
                if (bce() != null) {
                    bw bce = bce();
                    if (bce.getBaijiahaoData() != null) {
                        Hd.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                    }
                    Hd.ai("obj_param5", ae(bce));
                    Hd.dD("nid", bce.getNid());
                }
            }
        }
        if (Hd != null && bce() != null) {
            Hd.ai("is_full", bce().bgu() ? 1 : 0);
        }
        return Hd;
    }

    public aq ccy() {
        if (ccu()) {
            return Hd(hmU);
        }
        if (m.aa(this.dUW)) {
            aq aC = aC(hnc, true);
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
        aq aJ = aJ(hmP, 0);
        if (aJ != null) {
            aJ.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "click");
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

    public aq ccz() {
        if (m.aa(this.dUW)) {
            aq aC = aC(hnb, true);
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
        } else if (ccu()) {
            return Hd(hmV);
        } else {
            aq Hd = Hd(hmQ);
            if (Hd != null) {
                Hd.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "click");
                if (bce() != null) {
                    bw bce2 = bce();
                    if (bce2.getBaijiahaoData() != null) {
                        Hd.dD("obj_param4", bce2.getBaijiahaoData().oriUgcNid);
                    }
                    Hd.ai("obj_param5", ae(bce2));
                    Hd.dD("nid", bce2.getNid());
                    if (bce2.bgG()) {
                        Hd.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Hd;
                    }
                    Hd.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Hd;
                }
                return Hd;
            }
            return Hd;
        }
    }

    public aq ccA() {
        if (ccu()) {
            return Hd(hmW);
        }
        aq Hd = Hd(hmR);
        if (Hd != null) {
            Hd.dD("ab_tag", ccl()).dD(TiebaInitialize.Params.AB_ACTION, "click");
            if (bce() != null) {
                bw bce = bce();
                if (bce.getBaijiahaoData() != null) {
                    Hd.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                }
                Hd.ai("obj_param5", ae(bce));
                Hd.dD("nid", bce.getNid());
                return Hd;
            }
            return Hd;
        }
        return Hd;
    }

    public aq ccB() {
        return Hd(hmX);
    }

    public aq ccC() {
        aq aC = aC(hna, true);
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

    public aq Hh(String str) {
        aq Hd = Hd(str);
        if (this.dUW != null && this.dUW.beE() != null) {
            Hd.ai(TiebaInitialize.Params.AB_TYPE, this.dUW.beE().hadConcerned() ? 1 : 0);
        }
        return Hd;
    }

    public aq Hi(String str) {
        return Hd(str);
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
