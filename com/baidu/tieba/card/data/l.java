package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class l extends b implements com.baidu.tbadk.core.util.g.a {
    public boolean iAX = false;
    public boolean iBc = true;
    public int sourceType = 0;
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public static String iAI = "";
    public static String iAJ = "";
    public static String iAY = "";
    public static String iAH = "";
    public static String iAZ = "";
    public static String iBa = "";
    public static String iBb = "";

    public l(cb cbVar) {
        this.eJQ = cbVar;
    }

    public static boolean ae(cb cbVar) {
        return (cbVar == null || cbVar.boh() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eJQ == null) {
            return k.TYPE;
        }
        if (this.iAm) {
            if (this.eQi) {
                return cb.eQn;
            }
            return this.eJQ.getType();
        } else if (this.ePR) {
            return k.iAN;
        } else {
            if (this.iAk) {
                return eQK;
            }
            if (this.ePX) {
                return k.iAS;
            }
            if (this.ePY) {
                return k.iAU;
            }
            if (this.iAl) {
                return k.iAT;
            }
            if (this.eQi) {
                return k.eQr;
            }
            if (this.eQe) {
                return k.eQD;
            }
            if (this.eQg) {
                return k.eQF;
            }
            if (this.eQh) {
                return k.eQG;
            }
            return eQK;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        if (this.eJQ == null) {
            return null;
        }
        if (this.eJQ.bnE() != 5) {
            this.eJQ.nj(1);
        }
        return this.eJQ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blo() {
        if (this.eJQ == null) {
            return null;
        }
        return this.eJQ.eSI;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar IS(String str) {
        ar arVar = new ar(str);
        if (this.eJQ != null) {
            arVar.v("fid", this.eJQ.getFid());
            arVar.dR("tid", this.eJQ.getTid());
            if (this.eJQ.bmy()) {
                arVar.ap("obj_type", 8);
            } else if (this.eJQ.bpO()) {
                arVar.ap("obj_type", 9);
            } else if (this.eJQ.bmv()) {
                arVar.ap("obj_type", 2);
            }
            arVar.ap("obj_param1", csM() ? 2 : 1);
            if (this.eJQ.bnQ() != null) {
                arVar.dR("obj_id", this.eJQ.bnQ().getUserId());
            }
        }
        return arVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csQ() {
        ar az = az(iAY, true);
        if (az != null && bln() != null) {
            cb bln = bln();
            az.ap("obj_name", bln.bpv() != null && (bln.bpv().dNz() != null || bln.bpv().bHH() != null) ? 1 : 0);
            if (bln.bnQ() != null) {
                az.ap(TiebaInitialize.Params.AB_TYPE, bln.bnQ().hadConcerned() ? 1 : 0);
            }
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
            }
            az.ap("obj_param5", ai(bln));
            if (bln.bpV()) {
                az.ap(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                az.ap(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return az;
    }

    public ar b(cb cbVar, int i) {
        ar az = az(iAH, true);
        if (az != null) {
            if (i != -1) {
                az.ap("click_locate", i);
            }
            if (bln() != null) {
                cb bln = bln();
                if (bln.getBaijiahaoData() != null) {
                    az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
                }
                az.ap("obj_param5", ai(bln));
            }
        }
        return az;
    }

    public ar aj(cb cbVar) {
        return b(cbVar, -1);
    }

    public ar csZ() {
        ar az = az(iBb, true);
        if (az != null && bln() != null) {
            cb bln = bln();
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
            }
            az.ap("obj_param5", ai(bln));
        }
        return az;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csN() {
        ar az = az(iAJ, true);
        if (az != null && bln() != null) {
            cb bln = bln();
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
            }
            az.ap("obj_param5", ai(bln));
        }
        return az;
    }

    public ar ak(cb cbVar) {
        ar az = az(iAI, true);
        if (az != null && bln() != null) {
            cb bln = bln();
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
                if (bln.bpV()) {
                    az.ap(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    az.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            az.ap("obj_param5", ai(bln));
        }
        return az;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eJQ == null || this.eJQ.boh() == null || this.eJQ.boh().video_url == null) {
            return null;
        }
        return this.eJQ.boh().video_url;
    }

    public int ai(cb cbVar) {
        if (cbVar == null) {
            return 1;
        }
        if (cbVar.bpO() || cbVar.bpN()) {
            return 2;
        }
        return (cbVar.bmx() || cbVar.bmy()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmv() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csP() {
        ar az = az(iAH, true);
        if (bln() != null) {
            cb bln = bln();
            if (bln.getBaijiahaoData() != null) {
                az.dR("obj_param4", bln.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", bln.getBaijiahaoData().oriUgcVid);
            }
            az.ap("obj_param5", ai(bln));
            az.dR(IntentConfig.NID, bln.bmo());
        }
        return az;
    }
}
