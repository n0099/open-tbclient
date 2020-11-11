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
    public static String ibf = "";
    public static String ibg = "";
    public static String ibh = "";
    public static String ibi = "";
    public static String ibj = "";
    public static String ibk = "";
    public static String ibl = "";
    public static String ibm = "";
    public static String ibn = "";
    public static String ibo = "";
    public static String ibp = "";
    public static String ibq = "";
    public static String ibr = "";
    public static String ibs = "";
    public static String ibt = "";
    public static String ibu = "";
    public static String ibv = "";
    public static String ibw = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ibx = BdUniqueId.gen();
    public static final BdUniqueId eDU = BdUniqueId.gen();
    public static final BdUniqueId eEb = BdUniqueId.gen();
    public static final BdUniqueId eEc = BdUniqueId.gen();
    public static final BdUniqueId eEd = BdUniqueId.gen();
    public static final BdUniqueId eEe = BdUniqueId.gen();
    public static final BdUniqueId eEi = BdUniqueId.gen();
    public static final BdUniqueId eEj = BdUniqueId.gen();
    public static final BdUniqueId iby = BdUniqueId.gen();
    public static final BdUniqueId ibz = BdUniqueId.gen();
    public static final BdUniqueId eDE = BdUniqueId.gen();
    public static final BdUniqueId ibA = BdUniqueId.gen();
    public static final BdUniqueId ibB = BdUniqueId.gen();
    public static final BdUniqueId ibC = BdUniqueId.gen();
    public static final BdUniqueId ibD = BdUniqueId.gen();
    public static final BdUniqueId ibE = BdUniqueId.gen();
    public static final BdUniqueId ibF = BdUniqueId.gen();
    public static final BdUniqueId ibG = BdUniqueId.gen();
    public static final BdUniqueId eDQ = BdUniqueId.gen();
    public static final BdUniqueId eDS = BdUniqueId.gen();
    public static final BdUniqueId eDT = BdUniqueId.gen();
    public boolean ibH = false;
    public boolean isLinkThread = false;
    public boolean eDq = false;
    public boolean ibI = false;
    public boolean eDg = false;
    public boolean eDw = false;
    public boolean eDs = false;
    public boolean eDm = false;
    public boolean eDh = false;
    public boolean ibJ = false;
    public boolean eDk = false;
    public boolean eDl = false;
    public boolean eDn = false;
    public boolean ibK = false;
    public boolean eDu = false;
    public boolean eDv = false;
    public boolean ibL = false;
    public boolean foQ = true;

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.eDA || bwVar.getType() == bw.eDV || bwVar.getType() == bw.eDU || bwVar.getType() == bw.eEb || bwVar.getType() == bw.eEg;
    }

    public static boolean ad(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.eEi || bwVar.getType() == bw.eEj;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.exA == null) {
            return TYPE;
        }
        if (this.exA.threadType == 63) {
            return eEi;
        }
        if (this.exA.threadType == 64) {
            return eEj;
        }
        if (this.exA.isShareThread && this.exA.eGn != null) {
            if (this.exA.eGn.eBR) {
                OriginalThreadInfo originalThreadInfo = this.exA.eGn;
                if (originalThreadInfo.videoInfo != null) {
                    return eEe;
                }
                if (originalThreadInfo.bli()) {
                    return eEd;
                }
                return eEc;
            }
            return eEb;
        } else if (this.eDg) {
            return ibz;
        } else {
            if (this.eDh) {
                return ibA;
            }
            if (this.ibJ) {
                return ibB;
            }
            if (this.eDk) {
                return ibC;
            }
            if (this.eDl) {
                return ibD;
            }
            if (this.eDm) {
                return ibE;
            }
            if (this.eDn) {
                return ibG;
            }
            if (this.ibK) {
                return ibF;
            }
            if (this.eDw) {
                return eDE;
            }
            if (this.eDs) {
                return eDQ;
            }
            if (this.eDu) {
                return eDS;
            }
            if (this.eDv) {
                return eDT;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        if (this.exA == null) {
            return null;
        }
        if (this.exA.bmo() == 5) {
            return this.exA;
        }
        this.exA.oi(1);
        return this.exA;
    }

    public boolean coN() {
        return (this.exA == null || y.getCount(this.exA.bmN()) == 0) ? false : true;
    }

    public boolean coO() {
        return this.exA == null || this.exA.bnD();
    }

    public boolean blg() {
        return this.exA != null && this.exA.blg();
    }

    public aq coP() {
        SmartApp bnp;
        if (coN()) {
            aq Jd = Jd(ibk);
            if (Jd != null) {
                Jd.setPosition(this.position);
                if (bjZ() != null) {
                    bw bjZ = bjZ();
                    Jd.al("obj_name", bjZ.bod() != null && (bjZ.bod().dKb() != null || bjZ.bod().bFQ() != null) ? 1 : 0);
                    if (bjZ.bmA() != null) {
                        Jd.al(TiebaInitialize.Params.AB_TYPE, bjZ.bmA().hadConcerned() ? 1 : 0);
                    }
                    Jd.al("is_full", bjZ.boq() ? 1 : 0);
                }
            }
            return Jd;
        } else if (coO()) {
            aq Jd2 = Jd(ibq);
            if (Jd2 != null) {
                Jd2.setPosition(this.position);
                if (bjZ() != null && (bnp = bjZ().bnp()) != null) {
                    Jd2.dR("obj_type", bnp.id);
                    Jd2.dR("obj_name", bnp.name);
                    return Jd2;
                }
                return Jd2;
            }
            return Jd2;
        } else if (blg()) {
            return null;
        } else {
            aq Jd3 = Jd(ibf);
            if (Jd3 != null) {
                Jd3.setPosition(this.position);
                Jd3.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (bjZ() != null) {
                    bw bjZ2 = bjZ();
                    boolean z = (bjZ2.bod() == null || (bjZ2.bod().dKb() == null && bjZ2.bod().bFQ() == null)) ? false : true;
                    Jd3.al("obj_name", z ? 1 : 0);
                    if (z && bjZ2.bod().dKb() != null && bjZ2.bod().dKb().bFI() != null && bjZ2.bod().dKb().bFI().size() > 0) {
                        Jd3.al(TiebaInitialize.Params.OBJ_TO, bjZ2.bod().mXx ? 2 : 1);
                    }
                    if (bjZ2.bmA() != null) {
                        Jd3.al(TiebaInitialize.Params.AB_TYPE, bjZ2.bmA().hadConcerned() ? 1 : 0);
                    }
                    Jd3.al("is_full", bjZ2.boq() ? 1 : 0);
                    if (bjZ2.getBaijiahaoData() != null) {
                        Jd3.dR("obj_param4", bjZ2.getBaijiahaoData().oriUgcNid);
                    }
                    Jd3.al("obj_param5", af(bjZ2));
                    Jd3.dR("nid", bjZ2.getNid());
                    if (bjZ2.boC()) {
                        Jd3.al("obj_param6", 2);
                    } else {
                        Jd3.al("obj_param6", 1);
                    }
                }
            }
            return Jd3;
        }
    }

    public aq Jf(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.exA != null) {
            if (this.exA.getBaijiahaoData() == null) {
                aqVar.w("fid", this.exA.getFid());
                aqVar.dR("tid", this.exA.getTid());
            } else {
                aqVar.dR("tid", this.exA.getBaijiahaoData().oriUgcNid);
            }
            if (this.exA.blg()) {
                i = 2;
            } else if (this.exA.isLinkThread()) {
                i = 4;
            } else if (this.exA.isShareThread) {
                i = 5;
            } else if (this.exA.bli()) {
                i = 6;
            } else if (this.exA.bov()) {
                i = 7;
            } else if (this.exA.blj()) {
                i = 8;
            } else {
                i = this.exA.bow() ? 9 : 1;
            }
            aqVar.al("obj_type", i);
            aqVar.dR("obj_id", this.exA.bmA().getUserId());
            aqVar.al("obj_param1", coI() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Jg(String str) {
        aq Jd = Jd(str);
        if (Jd != null) {
            Jd.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (bjZ() != null) {
                bw bjZ = bjZ();
                boolean z = (bjZ.bod() == null || (bjZ.bod().dKb() == null && bjZ.bod().bFQ() == null)) ? false : true;
                Jd.al("obj_name", z ? 1 : 0);
                if (z && bjZ.bod().dKb() != null && bjZ.bod().dKb().bFI() != null && bjZ.bod().dKb().bFI().size() > 0) {
                    Jd.al(TiebaInitialize.Params.OBJ_TO, bjZ.bod().mXx ? 2 : 1);
                }
            }
        }
        return Jd;
    }

    public aq coQ() {
        aq Jd;
        SmartApp bnp;
        if (coN()) {
            Jd = Jd(ibl);
        } else if (coO()) {
            aq Jd2 = Jd(ibr);
            if (Jd2 != null && bjZ() != null && (bnp = bjZ().bnp()) != null) {
                Jd2.dR("obj_type", bnp.id);
                Jd2.dR("obj_name", bnp.name);
                return Jd2;
            }
            return Jd2;
        } else {
            Jd = Jd(ibg);
            if (Jd != null) {
                Jd.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bjZ() != null) {
                    bw bjZ = bjZ();
                    if (bjZ.getBaijiahaoData() != null) {
                        Jd.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                    }
                    Jd.al("obj_param5", af(bjZ));
                    Jd.dR("nid", bjZ.getNid());
                }
            }
        }
        if (Jd != null && bjZ() != null) {
            Jd.al("is_full", bjZ().boq() ? 1 : 0);
        }
        return Jd;
    }

    public aq coR() {
        if (coN()) {
            return Jd(ibm);
        }
        if (m.ab(this.exA)) {
            aq aI = aI(ibu, true);
            if (aI != null && bjZ() != null) {
                bw bjZ = bjZ();
                if (bjZ.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
                }
                aI.al("obj_param5", af(bjZ));
                aI.dR("nid", bjZ.getNid());
                return aI;
            }
            return aI;
        }
        aq aN = aN(ibh, 0);
        if (aN != null) {
            aN.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bjZ() != null) {
                bw bjZ2 = bjZ();
                if (bjZ2.getBaijiahaoData() != null) {
                    aN.dR("obj_param4", bjZ2.getBaijiahaoData().oriUgcNid);
                }
                aN.al("obj_param5", af(bjZ2));
                aN.dR("nid", bjZ2.getNid());
                return aN;
            }
            return aN;
        }
        return aN;
    }

    public aq coS() {
        if (m.ab(this.exA)) {
            aq aI = aI(ibt, true);
            if (aI != null && bjZ() != null) {
                bw bjZ = bjZ();
                if (bjZ.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
                }
                aI.al("obj_param5", af(bjZ));
                if (bjZ.boC()) {
                    aI.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aI;
                }
                aI.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aI;
            }
            return aI;
        } else if (coN()) {
            return Jd(ibn);
        } else {
            aq Jd = Jd(ibi);
            if (Jd != null) {
                Jd.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bjZ() != null) {
                    bw bjZ2 = bjZ();
                    if (bjZ2.getBaijiahaoData() != null) {
                        Jd.dR("obj_param4", bjZ2.getBaijiahaoData().oriUgcNid);
                    }
                    Jd.al("obj_param5", af(bjZ2));
                    Jd.dR("nid", bjZ2.getNid());
                    if (bjZ2.boC()) {
                        Jd.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Jd;
                    }
                    Jd.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Jd;
                }
                return Jd;
            }
            return Jd;
        }
    }

    public aq coT() {
        if (coN()) {
            return Jd(ibo);
        }
        aq Jd = Jd(ibj);
        if (Jd != null) {
            Jd.dR("ab_tag", coE()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bjZ() != null) {
                bw bjZ = bjZ();
                if (bjZ.getBaijiahaoData() != null) {
                    Jd.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                }
                Jd.al("obj_param5", af(bjZ));
                Jd.dR("nid", bjZ.getNid());
                return Jd;
            }
            return Jd;
        }
        return Jd;
    }

    public aq coU() {
        return Jd(ibp);
    }

    public aq coV() {
        aq aI = aI(ibs, true);
        if (bjZ() != null) {
            bw bjZ = bjZ();
            if (bjZ.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
            }
            aI.al("obj_param5", af(bjZ));
            aI.dR("nid", bjZ.getNid());
        }
        return aI;
    }

    public aq Jh(String str) {
        aq Jd = Jd(str);
        if (this.exA != null && this.exA.bmA() != null) {
            Jd.al(TiebaInitialize.Params.AB_TYPE, this.exA.bmA().hadConcerned() ? 1 : 0);
        }
        return Jd;
    }

    public aq Ji(String str) {
        return Jd(str);
    }

    public int ae(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bli()) {
            return 1;
        }
        if (bwVar.blg()) {
            return 2;
        }
        if (bwVar.bov()) {
            return 3;
        }
        return bwVar.bow() ? 4 : 0;
    }

    public int af(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        if (bwVar.bow() || bwVar.bov()) {
            return 2;
        }
        return (bwVar.bli() || bwVar.blj()) ? 3 : 1;
    }
}
