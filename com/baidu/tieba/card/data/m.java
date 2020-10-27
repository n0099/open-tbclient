package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId eyg = BdUniqueId.gen();
    public static String hVw = "";
    public static String hVx = "";
    public static String hVP = "";
    public static String hVv = "";
    public static String hVQ = "";
    public static String hVR = "";
    public static String hVS = "";
    public boolean hVO = false;
    public boolean hVT = true;
    public boolean exo = false;
    public boolean hVU = false;
    public boolean exv = false;
    public boolean exw = false;
    public boolean hVN = false;
    public boolean exF = false;
    public boolean exB = false;
    public boolean exD = false;
    public boolean exE = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.erH = bwVar;
    }

    public static boolean ab(bw bwVar) {
        return (bwVar == null || bwVar.bks() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.erH == null) {
            return l.TYPE;
        }
        if (this.exo) {
            return l.hVC;
        }
        if (this.hVU) {
            return eyg;
        }
        if (this.exv) {
            return l.hVH;
        }
        if (this.exw) {
            return l.hVJ;
        }
        if (this.hVN) {
            return l.hVI;
        }
        if (this.exF) {
            return l.exN;
        }
        if (this.exB) {
            return l.exZ;
        }
        if (this.exD) {
            return l.eyb;
        }
        if (this.exE) {
            return l.eyc;
        }
        return eyg;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        if (this.erH == null) {
            return null;
        }
        if (this.erH.bjO() != 5) {
            this.erH.nY(1);
        }
        return this.erH;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bhA() {
        if (this.erH == null) {
            return null;
        }
        return this.erH.eAe;
    }

    public aq IO(String str) {
        aq aqVar = new aq(str);
        if (this.erH != null) {
            aqVar.w("fid", this.erH.getFid());
            aqVar.dR("tid", this.erH.getTid());
            if (this.erH.biJ()) {
                aqVar.aj("obj_type", 8);
            } else if (this.erH.blW()) {
                aqVar.aj("obj_type", 9);
            } else if (this.erH.biG()) {
                aqVar.aj("obj_type", 2);
            }
            aqVar.aj("obj_param1", cmh() ? 2 : 1);
            if (this.erH.bka() != null) {
                aqVar.dR("obj_id", this.erH.bka().getUserId());
            }
        }
        return aqVar;
    }

    public aq cmo() {
        aq aI = aI(hVP, true);
        if (aI != null && bhz() != null) {
            bw bhz = bhz();
            aI.aj("obj_name", bhz.blD() != null && (bhz.blD().dHz() != null || bhz.blD().bDr() != null) ? 1 : 0);
            if (bhz.bka() != null) {
                aI.aj(TiebaInitialize.Params.AB_TYPE, bhz.bka().hadConcerned() ? 1 : 0);
            }
            if (bhz.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
            }
            aI.aj("obj_param5", af(bhz));
            if (bhz.bmc()) {
                aI.aj(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aI.aj(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aI;
    }

    public aq b(bw bwVar, int i) {
        aq aI = aI(hVv, true);
        if (aI != null) {
            if (i != -1) {
                aI.aj("click_locate", i);
            }
            if (bhz() != null) {
                bw bhz = bhz();
                if (bhz.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
                }
                aI.aj("obj_param5", af(bhz));
            }
        }
        return aI;
    }

    public aq ag(bw bwVar) {
        return b(bwVar, -1);
    }

    public aq cmv() {
        aq aI = aI(hVS, true);
        if (aI != null && bhz() != null) {
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

    public aq ah(bw bwVar) {
        aq aI = aI(hVw, true);
        if (aI != null && bhz() != null) {
            bw bhz = bhz();
            if (bhz.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bhz.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bhz.getBaijiahaoData().oriUgcVid);
                if (bhz.bmc()) {
                    aI.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aI.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aI.aj("obj_param5", af(bhz));
        }
        return aI;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.erH == null || this.erH.bks() == null || this.erH.bks().video_url == null) {
            return null;
        }
        return this.erH.bks().video_url;
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
