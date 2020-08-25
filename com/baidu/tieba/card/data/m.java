package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes15.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId ebo = BdUniqueId.gen();
    public static String hmX = "";
    public static String hmY = "";
    public static String hnp = "";
    public static String hmW = "";
    public static String hnq = "";
    public static String hnr = "";
    public static String hns = "";
    public boolean hno = false;
    public boolean hnt = true;
    public boolean eay = false;
    public boolean hnu = false;
    public boolean eaE = false;
    public boolean eaF = false;
    public boolean hnn = false;
    public boolean eaO = false;
    public boolean eaK = false;
    public boolean eaM = false;
    public boolean eaN = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.dUS = bwVar;
    }

    public static boolean aa(bw bwVar) {
        return (bwVar == null || bwVar.beW() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dUS == null) {
            return l.TYPE;
        }
        if (this.eay) {
            return l.hnc;
        }
        if (this.hnu) {
            return ebo;
        }
        if (this.eaE) {
            return l.hnh;
        }
        if (this.eaF) {
            return l.hnj;
        }
        if (this.hnn) {
            return l.hni;
        }
        if (this.eaO) {
            return l.eaW;
        }
        if (this.eaK) {
            return l.ebi;
        }
        if (this.eaM) {
            return l.ebk;
        }
        if (this.eaN) {
            return l.ebl;
        }
        return ebo;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        if (this.dUS == null) {
            return null;
        }
        if (this.dUS.bes() != 5) {
            this.dUS.nf(1);
        }
        return this.dUS;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcf() {
        if (this.dUS == null) {
            return null;
        }
        return this.dUS.edk;
    }

    public aq He(String str) {
        aq aqVar = new aq(str);
        if (this.dUS != null) {
            aqVar.u("fid", this.dUS.getFid());
            aqVar.dD("tid", this.dUS.getTid());
            if (this.dUS.bdn()) {
                aqVar.ai("obj_type", 8);
            } else if (this.dUS.bgA()) {
                aqVar.ai("obj_type", 9);
            } else if (this.dUS.bdk()) {
                aqVar.ai("obj_type", 2);
            }
            aqVar.ai("obj_param1", cco() ? 2 : 1);
            if (this.dUS.beE() != null) {
                aqVar.dD("obj_id", this.dUS.beE().getUserId());
            }
        }
        return aqVar;
    }

    public aq ccv() {
        aq aC = aC(hnp, true);
        if (aC != null && bce() != null) {
            bw bce = bce();
            aC.ai("obj_name", bce.bgh() != null && (bce.bgh().dwH() != null || bce.bgh().bxE() != null) ? 1 : 0);
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
        aq aC = aC(hmW, true);
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

    public aq ccC() {
        aq aC = aC(hns, true);
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
        aq aC = aC(hmX, true);
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
        if (this.dUS == null || this.dUS.beW() == null || this.dUS.beW().video_url == null) {
            return null;
        }
        return this.dUS.beW().video_url;
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
