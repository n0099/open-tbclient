package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class l extends b implements com.baidu.tbadk.core.util.g.a {
    public boolean ivn = false;
    public boolean ivs = true;
    public int sourceType = 0;
    public static final BdUniqueId eOy = BdUniqueId.gen();
    public static String iuY = "";
    public static String iuZ = "";
    public static String ivo = "";
    public static String iuX = "";
    public static String ivp = "";
    public static String ivq = "";
    public static String ivr = "";

    public l(bz bzVar) {
        this.eHK = bzVar;
    }

    public static boolean ad(bz bzVar) {
        return (bzVar == null || bzVar.bnO() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eHK == null) {
            return k.TYPE;
        }
        if (this.iuC) {
            if (this.eNW) {
                return bz.eOb;
            }
            return this.eHK.getType();
        } else if (this.eNF) {
            return k.ivd;
        } else {
            if (this.iuA) {
                return eOy;
            }
            if (this.eNL) {
                return k.ivi;
            }
            if (this.eNM) {
                return k.ivk;
            }
            if (this.iuB) {
                return k.ivj;
            }
            if (this.eNW) {
                return k.eOf;
            }
            if (this.eNS) {
                return k.eOr;
            }
            if (this.eNU) {
                return k.eOt;
            }
            if (this.eNV) {
                return k.eOu;
            }
            return eOy;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz bkV() {
        if (this.eHK == null) {
            return null;
        }
        if (this.eHK.bnl() != 5) {
            this.eHK.ng(1);
        }
        return this.eHK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bkW() {
        if (this.eHK == null) {
            return null;
        }
        return this.eHK.eQw;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq Ih(String str) {
        aq aqVar = new aq(str);
        if (this.eHK != null) {
            aqVar.w("fid", this.eHK.getFid());
            aqVar.dW("tid", this.eHK.getTid());
            if (this.eHK.bmf()) {
                aqVar.an("obj_type", 8);
            } else if (this.eHK.bpw()) {
                aqVar.an("obj_type", 9);
            } else if (this.eHK.bmc()) {
                aqVar.an("obj_type", 2);
            }
            aqVar.an("obj_param1", crA() ? 2 : 1);
            if (this.eHK.bnx() != null) {
                aqVar.dW("obj_id", this.eHK.bnx().getUserId());
            }
        }
        return aqVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crE() {
        aq aA = aA(ivo, true);
        if (aA != null && bkV() != null) {
            bz bkV = bkV();
            aA.an("obj_name", bkV.bpd() != null && (bkV.bpd().dLo() != null || bkV.bpd().bHn() != null) ? 1 : 0);
            if (bkV.bnx() != null) {
                aA.an(TiebaInitialize.Params.AB_TYPE, bkV.bnx().hadConcerned() ? 1 : 0);
            }
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(bkV));
            if (bkV.bpD()) {
                aA.an(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aA.an(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aA;
    }

    public aq b(bz bzVar, int i) {
        aq aA = aA(iuX, true);
        if (aA != null) {
            if (i != -1) {
                aA.an("click_locate", i);
            }
            if (bkV() != null) {
                bz bkV = bkV();
                if (bkV.getBaijiahaoData() != null) {
                    aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                    aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(bkV));
            }
        }
        return aA;
    }

    public aq ai(bz bzVar) {
        return b(bzVar, -1);
    }

    public aq crN() {
        aq aA = aA(ivr, true);
        if (aA != null && bkV() != null) {
            bz bkV = bkV();
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(bkV));
        }
        return aA;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crB() {
        aq aA = aA(iuZ, true);
        if (aA != null && bkV() != null) {
            bz bkV = bkV();
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(bkV));
        }
        return aA;
    }

    public aq aj(bz bzVar) {
        aq aA = aA(iuY, true);
        if (aA != null && bkV() != null) {
            bz bkV = bkV();
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
                if (bkV.bpD()) {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aA.an("obj_param5", ah(bkV));
        }
        return aA;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eHK == null || this.eHK.bnO() == null || this.eHK.bnO().video_url == null) {
            return null;
        }
        return this.eHK.bnO().video_url;
    }

    public int ah(bz bzVar) {
        if (bzVar == null) {
            return 1;
        }
        if (bzVar.bpw() || bzVar.bpv()) {
            return 2;
        }
        return (bzVar.bme() || bzVar.bmf()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmc() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crD() {
        aq aA = aA(iuX, true);
        if (bkV() != null) {
            bz bkV = bkV();
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(bkV));
            aA.dW(IntentConfig.NID, bkV.blV());
        }
        return aA;
    }
}
