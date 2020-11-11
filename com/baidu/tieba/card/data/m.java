package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId eDW = BdUniqueId.gen();
    public static String ibt = "";
    public static String ibu = "";
    public static String ibM = "";
    public static String ibs = "";
    public static String ibN = "";
    public static String ibO = "";
    public static String ibP = "";
    public boolean ibL = false;
    public boolean ibQ = true;
    public boolean eDg = false;
    public boolean ibR = false;
    public boolean eDm = false;
    public boolean eDn = false;
    public boolean ibK = false;
    public boolean eDw = false;
    public boolean eDs = false;
    public boolean eDu = false;
    public boolean eDv = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.exA = bwVar;
    }

    public static boolean ab(bw bwVar) {
        return (bwVar == null || bwVar.bmS() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.exA == null) {
            return l.TYPE;
        }
        if (this.eDg) {
            return l.ibz;
        }
        if (this.ibR) {
            return eDW;
        }
        if (this.eDm) {
            return l.ibE;
        }
        if (this.eDn) {
            return l.ibG;
        }
        if (this.ibK) {
            return l.ibF;
        }
        if (this.eDw) {
            return l.eDE;
        }
        if (this.eDs) {
            return l.eDQ;
        }
        if (this.eDu) {
            return l.eDS;
        }
        if (this.eDv) {
            return l.eDT;
        }
        return eDW;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        if (this.exA == null) {
            return null;
        }
        if (this.exA.bmo() != 5) {
            this.exA.oi(1);
        }
        return this.exA;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bka() {
        if (this.exA == null) {
            return null;
        }
        return this.exA.eFT;
    }

    public aq Jf(String str) {
        aq aqVar = new aq(str);
        if (this.exA != null) {
            aqVar.w("fid", this.exA.getFid());
            aqVar.dR("tid", this.exA.getTid());
            if (this.exA.blj()) {
                aqVar.al("obj_type", 8);
            } else if (this.exA.bow()) {
                aqVar.al("obj_type", 9);
            } else if (this.exA.blg()) {
                aqVar.al("obj_type", 2);
            }
            aqVar.al("obj_param1", coI() ? 2 : 1);
            if (this.exA.bmA() != null) {
                aqVar.dR("obj_id", this.exA.bmA().getUserId());
            }
        }
        return aqVar;
    }

    public aq coP() {
        aq aI = aI(ibM, true);
        if (aI != null && bjZ() != null) {
            bw bjZ = bjZ();
            aI.al("obj_name", bjZ.bod() != null && (bjZ.bod().dKb() != null || bjZ.bod().bFQ() != null) ? 1 : 0);
            if (bjZ.bmA() != null) {
                aI.al(TiebaInitialize.Params.AB_TYPE, bjZ.bmA().hadConcerned() ? 1 : 0);
            }
            if (bjZ.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
            }
            aI.al("obj_param5", af(bjZ));
            if (bjZ.boC()) {
                aI.al(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aI.al(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aI;
    }

    public aq b(bw bwVar, int i) {
        aq aI = aI(ibs, true);
        if (aI != null) {
            if (i != -1) {
                aI.al("click_locate", i);
            }
            if (bjZ() != null) {
                bw bjZ = bjZ();
                if (bjZ.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
                }
                aI.al("obj_param5", af(bjZ));
            }
        }
        return aI;
    }

    public aq ag(bw bwVar) {
        return b(bwVar, -1);
    }

    public aq coW() {
        aq aI = aI(ibP, true);
        if (aI != null && bjZ() != null) {
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

    public aq ah(bw bwVar) {
        aq aI = aI(ibt, true);
        if (aI != null && bjZ() != null) {
            bw bjZ = bjZ();
            if (bjZ.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjZ.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjZ.getBaijiahaoData().oriUgcVid);
                if (bjZ.boC()) {
                    aI.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aI.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aI.al("obj_param5", af(bjZ));
        }
        return aI;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.exA == null || this.exA.bmS() == null || this.exA.bmS().video_url == null) {
            return null;
        }
        return this.exA.bmS().video_url;
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
