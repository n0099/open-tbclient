package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes15.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId ebs = BdUniqueId.gen();
    public static String hnb = "";
    public static String hnc = "";
    public static String hnt = "";
    public static String hna = "";
    public static String hnu = "";
    public static String hnv = "";
    public static String hnw = "";
    public boolean hns = false;
    public boolean hnx = true;
    public boolean eaC = false;
    public boolean hny = false;
    public boolean eaI = false;
    public boolean eaJ = false;
    public boolean hnr = false;
    public boolean eaS = false;
    public boolean eaO = false;
    public boolean eaQ = false;
    public boolean eaR = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.dUW = bwVar;
    }

    public static boolean aa(bw bwVar) {
        return (bwVar == null || bwVar.beW() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUW == null) {
            return l.TYPE;
        }
        if (this.eaC) {
            return l.hng;
        }
        if (this.hny) {
            return ebs;
        }
        if (this.eaI) {
            return l.hnl;
        }
        if (this.eaJ) {
            return l.hnn;
        }
        if (this.hnr) {
            return l.hnm;
        }
        if (this.eaS) {
            return l.eba;
        }
        if (this.eaO) {
            return l.ebm;
        }
        if (this.eaQ) {
            return l.ebo;
        }
        if (this.eaR) {
            return l.ebp;
        }
        return ebs;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        if (this.dUW == null) {
            return null;
        }
        if (this.dUW.bes() != 5) {
            this.dUW.nf(1);
        }
        return this.dUW;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcf() {
        if (this.dUW == null) {
            return null;
        }
        return this.dUW.edo;
    }

    public aq Hf(String str) {
        aq aqVar = new aq(str);
        if (this.dUW != null) {
            aqVar.u("fid", this.dUW.getFid());
            aqVar.dD("tid", this.dUW.getTid());
            if (this.dUW.bdn()) {
                aqVar.ai("obj_type", 8);
            } else if (this.dUW.bgA()) {
                aqVar.ai("obj_type", 9);
            } else if (this.dUW.bdk()) {
                aqVar.ai("obj_type", 2);
            }
            aqVar.ai("obj_param1", ccp() ? 2 : 1);
            if (this.dUW.beE() != null) {
                aqVar.dD("obj_id", this.dUW.beE().getUserId());
            }
        }
        return aqVar;
    }

    public aq ccw() {
        aq aC = aC(hnt, true);
        if (aC != null && bce() != null) {
            bw bce = bce();
            aC.ai("obj_name", bce.bgh() != null && (bce.bgh().dwM() != null || bce.bgh().bxF() != null) ? 1 : 0);
            if (bce.beE() != null) {
                aC.ai(TiebaInitialize.Params.AB_TYPE, bce.beE().hadConcerned() ? 1 : 0);
            }
            if (bce.getBaijiahaoData() != null) {
                aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
            }
            aC.ai("obj_param5", ae(bce));
            if (bce.bgG()) {
                aC.ai(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aC.ai(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aC;
    }

    public aq b(bw bwVar, int i) {
        aq aC = aC(hna, true);
        if (aC != null) {
            if (i != -1) {
                aC.ai("click_locate", i);
            }
            if (bce() != null) {
                bw bce = bce();
                if (bce.getBaijiahaoData() != null) {
                    aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                    aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
                }
                aC.ai("obj_param5", ae(bce));
            }
        }
        return aC;
    }

    public aq af(bw bwVar) {
        return b(bwVar, -1);
    }

    public aq ccD() {
        aq aC = aC(hnw, true);
        if (aC != null && bce() != null) {
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

    public aq ag(bw bwVar) {
        aq aC = aC(hnb, true);
        if (aC != null && bce() != null) {
            bw bce = bce();
            if (bce.getBaijiahaoData() != null) {
                aC.dD("obj_param4", bce.getBaijiahaoData().oriUgcNid);
                aC.dD("obj_param6", bce.getBaijiahaoData().oriUgcVid);
                if (bce.bgG()) {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aC.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aC.ai("obj_param5", ae(bce));
        }
        return aC;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dUW == null || this.dUW.beW() == null || this.dUW.beW().video_url == null) {
            return null;
        }
        return this.dUW.beW().video_url;
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
