package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes21.dex */
public class l extends c {
    public static String hVi = "";
    public static String hVj = "";
    public static String hVk = "";
    public static String hVl = "";
    public static String hVm = "";
    public static String hVn = "";
    public static String hVo = "";
    public static String hVp = "";
    public static String hVq = "";
    public static String hVr = "";
    public static String hVs = "";
    public static String hVt = "";
    public static String hVu = "";
    public static String hVv = "";
    public static String hVw = "";
    public static String hVx = "";
    public static String hVy = "";
    public static String hVz = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hVA = BdUniqueId.gen();
    public static final BdUniqueId eyd = BdUniqueId.gen();
    public static final BdUniqueId eyl = BdUniqueId.gen();
    public static final BdUniqueId eyn = BdUniqueId.gen();
    public static final BdUniqueId eyo = BdUniqueId.gen();
    public static final BdUniqueId eyp = BdUniqueId.gen();
    public static final BdUniqueId eyt = BdUniqueId.gen();
    public static final BdUniqueId eyu = BdUniqueId.gen();
    public static final BdUniqueId hVB = BdUniqueId.gen();
    public static final BdUniqueId hVC = BdUniqueId.gen();
    public static final BdUniqueId exN = BdUniqueId.gen();
    public static final BdUniqueId hVD = BdUniqueId.gen();
    public static final BdUniqueId hVE = BdUniqueId.gen();
    public static final BdUniqueId hVF = BdUniqueId.gen();
    public static final BdUniqueId hVG = BdUniqueId.gen();
    public static final BdUniqueId hVH = BdUniqueId.gen();
    public static final BdUniqueId hVI = BdUniqueId.gen();
    public static final BdUniqueId hVJ = BdUniqueId.gen();
    public static final BdUniqueId exZ = BdUniqueId.gen();
    public static final BdUniqueId eyb = BdUniqueId.gen();
    public static final BdUniqueId eyc = BdUniqueId.gen();
    public boolean hVK = false;
    public boolean isLinkThread = false;
    public boolean exz = false;
    public boolean hVL = false;
    public boolean exo = false;
    public boolean exF = false;
    public boolean exB = false;
    public boolean exv = false;
    public boolean exp = false;
    public boolean hVM = false;
    public boolean exs = false;
    public boolean exu = false;
    public boolean exw = false;
    public boolean hVN = false;
    public boolean exD = false;
    public boolean exE = false;
    public boolean hVO = false;
    public boolean fiZ = true;

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.exJ || bwVar.getType() == bw.eyf || bwVar.getType() == bw.eyd || bwVar.getType() == bw.eyl || bwVar.getType() == bw.eyr;
    }

    public static boolean ad(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.eyt || bwVar.getType() == bw.eyu;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.erH == null) {
            return TYPE;
        }
        if (this.erH.threadType == 63) {
            return eyt;
        }
        if (this.erH.threadType == 64) {
            return eyu;
        }
        if (this.erH.isShareThread && this.erH.eAy != null) {
            if (this.erH.eAy.evY) {
                OriginalThreadInfo originalThreadInfo = this.erH.eAy;
                if (originalThreadInfo.videoInfo != null) {
                    return eyp;
                }
                if (originalThreadInfo.biI()) {
                    return eyo;
                }
                return eyn;
            }
            return eyl;
        } else if (this.exo) {
            return hVC;
        } else {
            if (this.exp) {
                return hVD;
            }
            if (this.hVM) {
                return hVE;
            }
            if (this.exs) {
                return hVF;
            }
            if (this.exu) {
                return hVG;
            }
            if (this.exv) {
                return hVH;
            }
            if (this.exw) {
                return hVJ;
            }
            if (this.hVN) {
                return hVI;
            }
            if (this.exF) {
                return exN;
            }
            if (this.exB) {
                return exZ;
            }
            if (this.exD) {
                return eyb;
            }
            if (this.exE) {
                return eyc;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        if (this.erH == null) {
            return null;
        }
        if (this.erH.bjO() == 5) {
            return this.erH;
        }
        this.erH.nY(1);
        return this.erH;
    }

    public boolean cmm() {
        return (this.erH == null || y.getCount(this.erH.bkn()) == 0) ? false : true;
    }

    public boolean cmn() {
        return this.erH == null || this.erH.bld();
    }

    public boolean biG() {
        return this.erH != null && this.erH.biG();
    }

    public aq cmo() {
        SmartApp bkP;
        if (cmm()) {
            aq IM = IM(hVn);
            if (IM != null) {
                IM.setPosition(this.position);
                if (bhz() != null) {
                    bw bhz = bhz();
                    IM.aj("obj_name", bhz.blD() != null && (bhz.blD().dHz() != null || bhz.blD().bDr() != null) ? 1 : 0);
                    if (bhz.bka() != null) {
                        IM.aj(TiebaInitialize.Params.AB_TYPE, bhz.bka().hadConcerned() ? 1 : 0);
                    }
                    IM.aj("is_full", bhz.blQ() ? 1 : 0);
                }
            }
            return IM;
        } else if (cmn()) {
            aq IM2 = IM(hVt);
            if (IM2 != null) {
                IM2.setPosition(this.position);
                if (bhz() != null && (bkP = bhz().bkP()) != null) {
                    IM2.dR("obj_type", bkP.id);
                    IM2.dR("obj_name", bkP.name);
                    return IM2;
                }
                return IM2;
            }
            return IM2;
        } else if (biG()) {
            return null;
        } else {
            aq IM3 = IM(hVi);
            if (IM3 != null) {
                IM3.setPosition(this.position);
                IM3.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (bhz() != null) {
                    bw bhz2 = bhz();
                    boolean z = (bhz2.blD() == null || (bhz2.blD().dHz() == null && bhz2.blD().bDr() == null)) ? false : true;
                    IM3.aj("obj_name", z ? 1 : 0);
                    if (z && bhz2.blD().dHz() != null && bhz2.blD().dHz().bDj() != null && bhz2.blD().dHz().bDj().size() > 0) {
                        IM3.aj(TiebaInitialize.Params.OBJ_TO, bhz2.blD().mRu ? 2 : 1);
                    }
                    if (bhz2.bka() != null) {
                        IM3.aj(TiebaInitialize.Params.AB_TYPE, bhz2.bka().hadConcerned() ? 1 : 0);
                    }
                    IM3.aj("is_full", bhz2.blQ() ? 1 : 0);
                    if (bhz2.getBaijiahaoData() != null) {
                        IM3.dR("obj_param4", bhz2.getBaijiahaoData().oriUgcNid);
                    }
                    IM3.aj("obj_param5", af(bhz2));
                    IM3.dR("nid", bhz2.getNid());
                    if (bhz2.bmc()) {
                        IM3.aj("obj_param6", 2);
                    } else {
                        IM3.aj("obj_param6", 1);
                    }
                }
            }
            return IM3;
        }
    }

    public aq IO(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.erH != null) {
            if (this.erH.getBaijiahaoData() == null) {
                aqVar.w("fid", this.erH.getFid());
                aqVar.dR("tid", this.erH.getTid());
            } else {
                aqVar.dR("tid", this.erH.getBaijiahaoData().oriUgcNid);
            }
            if (this.erH.biG()) {
                i = 2;
            } else if (this.erH.isLinkThread()) {
                i = 4;
            } else if (this.erH.isShareThread) {
                i = 5;
            } else if (this.erH.biI()) {
                i = 6;
            } else if (this.erH.blV()) {
                i = 7;
            } else if (this.erH.biJ()) {
                i = 8;
            } else {
                i = this.erH.blW() ? 9 : 1;
            }
            aqVar.aj("obj_type", i);
            aqVar.dR("obj_id", this.erH.bka().getUserId());
            aqVar.aj("obj_param1", cmh() ? 2 : 1);
        }
        return aqVar;
    }

    public aq IP(String str) {
        aq IM = IM(str);
        if (IM != null) {
            IM.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (bhz() != null) {
                bw bhz = bhz();
                boolean z = (bhz.blD() == null || (bhz.blD().dHz() == null && bhz.blD().bDr() == null)) ? false : true;
                IM.aj("obj_name", z ? 1 : 0);
                if (z && bhz.blD().dHz() != null && bhz.blD().dHz().bDj() != null && bhz.blD().dHz().bDj().size() > 0) {
                    IM.aj(TiebaInitialize.Params.OBJ_TO, bhz.blD().mRu ? 2 : 1);
                }
            }
        }
        return IM;
    }

    public aq cmp() {
        aq IM;
        SmartApp bkP;
        if (cmm()) {
            IM = IM(hVo);
        } else if (cmn()) {
            aq IM2 = IM(hVu);
            if (IM2 != null && bhz() != null && (bkP = bhz().bkP()) != null) {
                IM2.dR("obj_type", bkP.id);
                IM2.dR("obj_name", bkP.name);
                return IM2;
            }
            return IM2;
        } else {
            IM = IM(hVj);
            if (IM != null) {
                IM.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bhz() != null) {
                    bw bhz = bhz();
                    if (bhz.getBaijiahaoData() != null) {
                        IM.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                    }
                    IM.aj("obj_param5", af(bhz));
                    IM.dR("nid", bhz.getNid());
                }
            }
        }
        if (IM != null && bhz() != null) {
            IM.aj("is_full", bhz().blQ() ? 1 : 0);
        }
        return IM;
    }

    public aq cmq() {
        if (cmm()) {
            return IM(hVp);
        }
        if (m.ab(this.erH)) {
            aq aI = aI(hVx, true);
            if (aI != null && bhz() != null) {
                bw bhz = bhz();
                if (bhz.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
                }
                aI.aj("obj_param5", af(bhz));
                aI.dR("nid", bhz.getNid());
                return aI;
            }
            return aI;
        }
        aq aL = aL(hVk, 0);
        if (aL != null) {
            aL.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bhz() != null) {
                bw bhz2 = bhz();
                if (bhz2.getBaijiahaoData() != null) {
                    aL.dR("obj_param4", bhz2.getBaijiahaoData().oriUgcNid);
                }
                aL.aj("obj_param5", af(bhz2));
                aL.dR("nid", bhz2.getNid());
                return aL;
            }
            return aL;
        }
        return aL;
    }

    public aq cmr() {
        if (m.ab(this.erH)) {
            aq aI = aI(hVw, true);
            if (aI != null && bhz() != null) {
                bw bhz = bhz();
                if (bhz.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
                }
                aI.aj("obj_param5", af(bhz));
                if (bhz.bmc()) {
                    aI.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aI;
                }
                aI.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aI;
            }
            return aI;
        } else if (cmm()) {
            return IM(hVq);
        } else {
            aq IM = IM(hVl);
            if (IM != null) {
                IM.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bhz() != null) {
                    bw bhz2 = bhz();
                    if (bhz2.getBaijiahaoData() != null) {
                        IM.dR("obj_param4", bhz2.getBaijiahaoData().oriUgcNid);
                    }
                    IM.aj("obj_param5", af(bhz2));
                    IM.dR("nid", bhz2.getNid());
                    if (bhz2.bmc()) {
                        IM.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return IM;
                    }
                    IM.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return IM;
                }
                return IM;
            }
            return IM;
        }
    }

    public aq cms() {
        if (cmm()) {
            return IM(hVr);
        }
        aq IM = IM(hVm);
        if (IM != null) {
            IM.dR("ab_tag", cmd()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bhz() != null) {
                bw bhz = bhz();
                if (bhz.getBaijiahaoData() != null) {
                    IM.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                }
                IM.aj("obj_param5", af(bhz));
                IM.dR("nid", bhz.getNid());
                return IM;
            }
            return IM;
        }
        return IM;
    }

    public aq cmt() {
        return IM(hVs);
    }

    public aq cmu() {
        aq aI = aI(hVv, true);
        if (bhz() != null) {
            bw bhz = bhz();
            if (bhz.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
            }
            aI.aj("obj_param5", af(bhz));
            aI.dR("nid", bhz.getNid());
        }
        return aI;
    }

    public aq IQ(String str) {
        aq IM = IM(str);
        if (this.erH != null && this.erH.bka() != null) {
            IM.aj(TiebaInitialize.Params.AB_TYPE, this.erH.bka().hadConcerned() ? 1 : 0);
        }
        return IM;
    }

    public aq IR(String str) {
        return IM(str);
    }

    public int ae(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.biI()) {
            return 1;
        }
        if (bwVar.biG()) {
            return 2;
        }
        if (bwVar.blV()) {
            return 3;
        }
        return bwVar.blW() ? 4 : 0;
    }

    public int af(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        if (bwVar.blW() || bwVar.blV()) {
            return 2;
        }
        return (bwVar.biI() || bwVar.biJ()) ? 3 : 1;
    }
}
