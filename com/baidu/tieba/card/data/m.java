package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes20.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId edC = BdUniqueId.gen();
    public static String hue = "";
    public static String huf = "";
    public static String hux = "";
    public static String hud = "";
    public static String huy = "";
    public static String huz = "";
    public static String huA = "";
    public boolean huw = false;
    public boolean huB = true;
    public boolean ecM = false;
    public boolean huC = false;
    public boolean ecS = false;
    public boolean ecT = false;
    public boolean huv = false;
    public boolean edc = false;
    public boolean ecY = false;
    public boolean eda = false;
    public boolean edb = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.dXg = bwVar;
    }

    public static boolean ab(bw bwVar) {
        return (bwVar == null || bwVar.bfQ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dXg == null) {
            return l.TYPE;
        }
        if (this.ecM) {
            return l.huk;
        }
        if (this.huC) {
            return edC;
        }
        if (this.ecS) {
            return l.hup;
        }
        if (this.ecT) {
            return l.hur;
        }
        if (this.huv) {
            return l.huq;
        }
        if (this.edc) {
            return l.edk;
        }
        if (this.ecY) {
            return l.edw;
        }
        if (this.eda) {
            return l.edy;
        }
        if (this.edb) {
            return l.edz;
        }
        return edC;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        if (this.dXg == null) {
            return null;
        }
        if (this.dXg.bfm() != 5) {
            this.dXg.nq(1);
        }
        return this.dXg;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcZ() {
        if (this.dXg == null) {
            return null;
        }
        return this.dXg.efy;
    }

    public aq HC(String str) {
        aq aqVar = new aq(str);
        if (this.dXg != null) {
            aqVar.u("fid", this.dXg.getFid());
            aqVar.dF("tid", this.dXg.getTid());
            if (this.dXg.beh()) {
                aqVar.ai("obj_type", 8);
            } else if (this.dXg.bhu()) {
                aqVar.ai("obj_type", 9);
            } else if (this.dXg.bee()) {
                aqVar.ai("obj_type", 2);
            }
            aqVar.ai("obj_param1", cfE() ? 2 : 1);
            if (this.dXg.bfy() != null) {
                aqVar.dF("obj_id", this.dXg.bfy().getUserId());
            }
        }
        return aqVar;
    }

    public aq cfL() {
        aq aC = aC(hux, true);
        if (aC != null && bcY() != null) {
            bw bcY = bcY();
            aC.ai("obj_name", bcY.bhb() != null && (bcY.bhb().dAF() != null || bcY.bhb().byO() != null) ? 1 : 0);
            if (bcY.bfy() != null) {
                aC.ai(TiebaInitialize.Params.AB_TYPE, bcY.bfy().hadConcerned() ? 1 : 0);
            }
            if (bcY.getBaijiahaoData() != null) {
                aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
            }
            aC.ai("obj_param5", af(bcY));
            if (bcY.bhA()) {
                aC.ai(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aC.ai(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aC;
    }

    public aq b(bw bwVar, int i) {
        aq aC = aC(hud, true);
        if (aC != null) {
            if (i != -1) {
                aC.ai("click_locate", i);
            }
            if (bcY() != null) {
                bw bcY = bcY();
                if (bcY.getBaijiahaoData() != null) {
                    aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                    aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", af(bcY));
            }
        }
        return aC;
    }

    public aq ag(bw bwVar) {
        return b(bwVar, -1);
    }

    public aq cfS() {
        aq aC = aC(huA, true);
        if (aC != null && bcY() != null) {
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

    public aq ah(bw bwVar) {
        aq aC = aC(hue, true);
        if (aC != null && bcY() != null) {
            bw bcY = bcY();
            if (bcY.getBaijiahaoData() != null) {
                aC.dF("obj_param4", bcY.getBaijiahaoData().oriUgcNid);
                aC.dF("obj_param6", bcY.getBaijiahaoData().oriUgcVid);
                if (bcY.bhA()) {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aC.ai("obj_param5", af(bcY));
        }
        return aC;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dXg == null || this.dXg.bfQ() == null || this.dXg.bfQ().video_url == null) {
            return null;
        }
        return this.dXg.bfQ().video_url;
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
