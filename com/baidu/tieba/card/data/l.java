package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes20.dex */
public class l extends c {
    public static String htQ = "";
    public static String htR = "";
    public static String htS = "";
    public static String htT = "";
    public static String htU = "";
    public static String htV = "";
    public static String htW = "";
    public static String htX = "";
    public static String htY = "";
    public static String htZ = "";
    public static String hua = "";
    public static String hub = "";
    public static String huc = "";
    public static String hud = "";
    public static String hue = "";
    public static String huf = "";
    public static String hug = "";
    public static String huh = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hui = BdUniqueId.gen();
    public static final BdUniqueId edA = BdUniqueId.gen();
    public static final BdUniqueId edG = BdUniqueId.gen();
    public static final BdUniqueId edH = BdUniqueId.gen();
    public static final BdUniqueId edI = BdUniqueId.gen();
    public static final BdUniqueId edJ = BdUniqueId.gen();
    public static final BdUniqueId edN = BdUniqueId.gen();
    public static final BdUniqueId edO = BdUniqueId.gen();
    public static final BdUniqueId huj = BdUniqueId.gen();
    public static final BdUniqueId huk = BdUniqueId.gen();
    public static final BdUniqueId edk = BdUniqueId.gen();
    public static final BdUniqueId hul = BdUniqueId.gen();
    public static final BdUniqueId hum = BdUniqueId.gen();
    public static final BdUniqueId hun = BdUniqueId.gen();
    public static final BdUniqueId huo = BdUniqueId.gen();
    public static final BdUniqueId hup = BdUniqueId.gen();
    public static final BdUniqueId huq = BdUniqueId.gen();
    public static final BdUniqueId hur = BdUniqueId.gen();
    public static final BdUniqueId edw = BdUniqueId.gen();
    public static final BdUniqueId edy = BdUniqueId.gen();
    public static final BdUniqueId edz = BdUniqueId.gen();
    public boolean hus = false;
    public boolean isLinkThread = false;
    public boolean ecW = false;
    public boolean hut = false;
    public boolean ecM = false;
    public boolean edc = false;
    public boolean ecY = false;
    public boolean ecS = false;
    public boolean ecN = false;
    public boolean huu = false;
    public boolean ecQ = false;
    public boolean ecR = false;
    public boolean ecT = false;
    public boolean huv = false;
    public boolean eda = false;
    public boolean edb = false;
    public boolean huw = false;
    public boolean eOt = true;

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.edg || bwVar.getType() == bw.edB || bwVar.getType() == bw.edA || bwVar.getType() == bw.edG || bwVar.getType() == bw.edL;
    }

    public static boolean ad(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.edN || bwVar.getType() == bw.edO;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dXg == null) {
            return TYPE;
        }
        if (this.dXg.threadType == 63) {
            return edN;
        }
        if (this.dXg.threadType == 64) {
            return edO;
        }
        if (this.dXg.isShareThread && this.dXg.efS != null) {
            if (this.dXg.efS.ebw) {
                OriginalThreadInfo originalThreadInfo = this.dXg.efS;
                if (originalThreadInfo.videoInfo != null) {
                    return edJ;
                }
                if (originalThreadInfo.beg()) {
                    return edI;
                }
                return edH;
            }
            return edG;
        } else if (this.ecM) {
            return huk;
        } else {
            if (this.ecN) {
                return hul;
            }
            if (this.huu) {
                return hum;
            }
            if (this.ecQ) {
                return hun;
            }
            if (this.ecR) {
                return huo;
            }
            if (this.ecS) {
                return hup;
            }
            if (this.ecT) {
                return hur;
            }
            if (this.huv) {
                return huq;
            }
            if (this.edc) {
                return edk;
            }
            if (this.ecY) {
                return edw;
            }
            if (this.eda) {
                return edy;
            }
            if (this.edb) {
                return edz;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        if (this.dXg == null) {
            return null;
        }
        if (this.dXg.bfm() == 5) {
            return this.dXg;
        }
        this.dXg.nq(1);
        return this.dXg;
    }

    public boolean cfJ() {
        return (this.dXg == null || y.getCount(this.dXg.bfL()) == 0) ? false : true;
    }

    public boolean cfK() {
        return this.dXg == null || this.dXg.bgB();
    }

    public boolean bee() {
        return this.dXg != null && this.dXg.bee();
    }

    public aq cfL() {
        SmartApp bgn;
        if (cfJ()) {
            aq HA = HA(htV);
            if (HA != null) {
                HA.setPosition(this.position);
                if (bcY() != null) {
                    bw bcY = bcY();
                    HA.ai("obj_name", bcY.bhb() != null && (bcY.bhb().dAF() != null || bcY.bhb().byO() != null) ? 1 : 0);
                    if (bcY.bfy() != null) {
                        HA.ai(TiebaInitialize.Params.AB_TYPE, bcY.bfy().hadConcerned() ? 1 : 0);
                    }
                    HA.ai("is_full", bcY.bho() ? 1 : 0);
                }
            }
            return HA;
        } else if (cfK()) {
            aq HA2 = HA(hub);
            if (HA2 != null) {
                HA2.setPosition(this.position);
                if (bcY() != null && (bgn = bcY().bgn()) != null) {
                    HA2.dF("obj_type", bgn.id);
                    HA2.dF("obj_name", bgn.name);
                    return HA2;
                }
                return HA2;
            }
            return HA2;
        } else if (bee()) {
            return null;
        } else {
            aq HA3 = HA(htQ);
            if (HA3 != null) {
                HA3.setPosition(this.position);
                HA3.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "show");
                if (bcY() != null) {
                    bw bcY2 = bcY();
                    boolean z = (bcY2.bhb() == null || (bcY2.bhb().dAF() == null && bcY2.bhb().byO() == null)) ? false : true;
                    HA3.ai("obj_name", z ? 1 : 0);
                    if (z && bcY2.bhb().dAF() != null && bcY2.bhb().dAF().byG() != null && bcY2.bhb().dAF().byG().size() > 0) {
                        HA3.ai(TiebaInitialize.Params.OBJ_TO, bcY2.bhb().mph ? 2 : 1);
                    }
                    if (bcY2.bfy() != null) {
                        HA3.ai(TiebaInitialize.Params.AB_TYPE, bcY2.bfy().hadConcerned() ? 1 : 0);
                    }
                    HA3.ai("is_full", bcY2.bho() ? 1 : 0);
                    if (bcY2.getBaijiahaoData() != null) {
                        HA3.dF("obj_param4", bcY2.getBaijiahaoData().oriUgcNid);
                    }
                    HA3.ai("obj_param5", af(bcY2));
                    HA3.dF("nid", bcY2.getNid());
                    if (bcY2.bhA()) {
                        HA3.ai("obj_param6", 2);
                    } else {
                        HA3.ai("obj_param6", 1);
                    }
                }
            }
            return HA3;
        }
    }

    public aq HC(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.dXg != null) {
            if (this.dXg.getBaijiahaoData() == null) {
                aqVar.u("fid", this.dXg.getFid());
                aqVar.dF("tid", this.dXg.getTid());
            } else {
                aqVar.dF("tid", this.dXg.getBaijiahaoData().oriUgcNid);
            }
            if (this.dXg.bee()) {
                i = 2;
            } else if (this.dXg.isLinkThread()) {
                i = 4;
            } else if (this.dXg.isShareThread) {
                i = 5;
            } else if (this.dXg.beg()) {
                i = 6;
            } else if (this.dXg.bht()) {
                i = 7;
            } else if (this.dXg.beh()) {
                i = 8;
            } else {
                i = this.dXg.bhu() ? 9 : 1;
            }
            aqVar.ai("obj_type", i);
            aqVar.dF("obj_id", this.dXg.bfy().getUserId());
            aqVar.ai("obj_param1", cfE() ? 2 : 1);
        }
        return aqVar;
    }

    public aq HD(String str) {
        aq HA = HA(str);
        if (HA != null) {
            HA.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "show");
            if (bcY() != null) {
                bw bcY = bcY();
                boolean z = (bcY.bhb() == null || (bcY.bhb().dAF() == null && bcY.bhb().byO() == null)) ? false : true;
                HA.ai("obj_name", z ? 1 : 0);
                if (z && bcY.bhb().dAF() != null && bcY.bhb().dAF().byG() != null && bcY.bhb().dAF().byG().size() > 0) {
                    HA.ai(TiebaInitialize.Params.OBJ_TO, bcY.bhb().mph ? 2 : 1);
                }
            }
        }
        return HA;
    }

    public aq cfM() {
        aq HA;
        SmartApp bgn;
        if (cfJ()) {
            HA = HA(htW);
        } else if (cfK()) {
            aq HA2 = HA(huc);
            if (HA2 != null && bcY() != null && (bgn = bcY().bgn()) != null) {
                HA2.dF("obj_type", bgn.id);
                HA2.dF("obj_name", bgn.name);
                return HA2;
            }
            return HA2;
        } else {
            HA = HA(htR);
            if (HA != null) {
                HA.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "click");
                if (bcY() != null) {
                    bw bcY = bcY();
                    if (bcY.getBaijiahaoData() != null) {
                        HA.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                    }
                    HA.ai("obj_param5", af(bcY));
                    HA.dF("nid", bcY.getNid());
                }
            }
        }
        if (HA != null && bcY() != null) {
            HA.ai("is_full", bcY().bho() ? 1 : 0);
        }
        return HA;
    }

    public aq cfN() {
        if (cfJ()) {
            return HA(htX);
        }
        if (m.ab(this.dXg)) {
            aq aC = aC(huf, true);
            if (aC != null && bcY() != null) {
                bw bcY = bcY();
                if (bcY.getBaijiahaoData() != null) {
                    aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                    aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", af(bcY));
                aC.dF("nid", bcY.getNid());
                return aC;
            }
            return aC;
        }
        aq aJ = aJ(htS, 0);
        if (aJ != null) {
            aJ.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "click");
            if (bcY() != null) {
                bw bcY2 = bcY();
                if (bcY2.getBaijiahaoData() != null) {
                    aJ.dF("obj_param4", bcY2.getBaijiahaoData().oriUgcNid);
                }
                aJ.ai("obj_param5", af(bcY2));
                aJ.dF("nid", bcY2.getNid());
                return aJ;
            }
            return aJ;
        }
        return aJ;
    }

    public aq cfO() {
        if (m.ab(this.dXg)) {
            aq aC = aC(hue, true);
            if (aC != null && bcY() != null) {
                bw bcY = bcY();
                if (bcY.getBaijiahaoData() != null) {
                    aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                    aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", af(bcY));
                if (bcY.bhA()) {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aC;
                }
                aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aC;
            }
            return aC;
        } else if (cfJ()) {
            return HA(htY);
        } else {
            aq HA = HA(htT);
            if (HA != null) {
                HA.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "click");
                if (bcY() != null) {
                    bw bcY2 = bcY();
                    if (bcY2.getBaijiahaoData() != null) {
                        HA.dF("obj_param4", bcY2.getBaijiahaoData().oriUgcNid);
                    }
                    HA.ai("obj_param5", af(bcY2));
                    HA.dF("nid", bcY2.getNid());
                    if (bcY2.bhA()) {
                        HA.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return HA;
                    }
                    HA.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return HA;
                }
                return HA;
            }
            return HA;
        }
    }

    public aq cfP() {
        if (cfJ()) {
            return HA(htZ);
        }
        aq HA = HA(htU);
        if (HA != null) {
            HA.dF("ab_tag", cfA()).dF(TiebaInitialize.Params.AB_ACTION, "click");
            if (bcY() != null) {
                bw bcY = bcY();
                if (bcY.getBaijiahaoData() != null) {
                    HA.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                }
                HA.ai("obj_param5", af(bcY));
                HA.dF("nid", bcY.getNid());
                return HA;
            }
            return HA;
        }
        return HA;
    }

    public aq cfQ() {
        return HA(hua);
    }

    public aq cfR() {
        aq aC = aC(hud, true);
        if (bcY() != null) {
            bw bcY = bcY();
            if (bcY.getBaijiahaoData() != null) {
                aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
            }
            aC.ai("obj_param5", af(bcY));
            aC.dF("nid", bcY.getNid());
        }
        return aC;
    }

    public aq HE(String str) {
        aq HA = HA(str);
        if (this.dXg != null && this.dXg.bfy() != null) {
            HA.ai(TiebaInitialize.Params.AB_TYPE, this.dXg.bfy().hadConcerned() ? 1 : 0);
        }
        return HA;
    }

    public aq HF(String str) {
        return HA(str);
    }

    public int ae(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.beg()) {
            return 1;
        }
        if (bwVar.bee()) {
            return 2;
        }
        if (bwVar.bht()) {
            return 3;
        }
        return bwVar.bhu() ? 4 : 0;
    }

    public int af(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        if (bwVar.bhu() || bwVar.bht()) {
            return 2;
        }
        return (bwVar.beg() || bwVar.beh()) ? 3 : 1;
    }
}
