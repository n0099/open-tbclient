package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class l extends b implements com.baidu.tbadk.core.util.g.a {
    public boolean iCU = false;
    public boolean iCZ = true;
    public int sourceType = 0;
    public static final BdUniqueId eSl = BdUniqueId.gen();
    public static String iCF = "";
    public static String iCG = "";
    public static String iCV = "";
    public static String iCE = "";
    public static String iCW = "";
    public static String iCX = "";
    public static String iCY = "";

    public l(cb cbVar) {
        this.eLr = cbVar;
    }

    public static boolean ae(cb cbVar) {
        return (cbVar == null || cbVar.boj() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eLr == null) {
            return k.TYPE;
        }
        if (this.iCj) {
            if (this.eRJ) {
                return cb.eRO;
            }
            return this.eLr.getType();
        } else if (this.eRs) {
            return k.iCK;
        } else {
            if (this.iCh) {
                return eSl;
            }
            if (this.eRy) {
                return k.iCP;
            }
            if (this.eRz) {
                return k.iCR;
            }
            if (this.iCi) {
                return k.iCQ;
            }
            if (this.eRJ) {
                return k.eRS;
            }
            if (this.eRF) {
                return k.eSe;
            }
            if (this.eRH) {
                return k.eSg;
            }
            if (this.eRI) {
                return k.eSh;
            }
            return eSl;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb blp() {
        if (this.eLr == null) {
            return null;
        }
        if (this.eLr.bnG() != 5) {
            this.eLr.nk(1);
        }
        return this.eLr;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        if (this.eLr == null) {
            return null;
        }
        return this.eLr.eUj;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar Jc(String str) {
        ar arVar = new ar(str);
        if (this.eLr != null) {
            arVar.v("fid", this.eLr.getFid());
            arVar.dR("tid", this.eLr.getTid());
            if (this.eLr.bmA()) {
                arVar.aq("obj_type", 8);
            } else if (this.eLr.bpQ()) {
                arVar.aq("obj_type", 9);
            } else if (this.eLr.bmx()) {
                arVar.aq("obj_type", 2);
            }
            arVar.aq("obj_param1", csZ() ? 2 : 1);
            if (this.eLr.bnS() != null) {
                arVar.dR("obj_id", this.eLr.bnS().getUserId());
            }
        }
        return arVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar ctd() {
        ar az = az(iCV, true);
        if (az != null && blp() != null) {
            cb blp = blp();
            az.aq("obj_name", blp.bpx() != null && (blp.bpx().dNQ() != null || blp.bpx().bHL() != null) ? 1 : 0);
            if (blp.bnS() != null) {
                az.aq(TiebaInitialize.Params.AB_TYPE, blp.bnS().hadConcerned() ? 1 : 0);
            }
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
            }
            az.aq("obj_param5", ai(blp));
            if (blp.bpX()) {
                az.aq(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                az.aq(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return az;
    }

    public ar b(cb cbVar, int i) {
        ar az = az(iCE, true);
        if (az != null) {
            if (i != -1) {
                az.aq("click_locate", i);
            }
            if (blp() != null) {
                cb blp = blp();
                if (blp.getBaijiahaoData() != null) {
                    az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
                }
                az.aq("obj_param5", ai(blp));
            }
        }
        return az;
    }

    public ar aj(cb cbVar) {
        return b(cbVar, -1);
    }

    public ar ctm() {
        ar az = az(iCY, true);
        if (az != null && blp() != null) {
            cb blp = blp();
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
            }
            az.aq("obj_param5", ai(blp));
        }
        return az;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar cta() {
        ar az = az(iCG, true);
        if (az != null && blp() != null) {
            cb blp = blp();
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
            }
            az.aq("obj_param5", ai(blp));
        }
        return az;
    }

    public ar ak(cb cbVar) {
        ar az = az(iCF, true);
        if (az != null && blp() != null) {
            cb blp = blp();
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
                if (blp.bpX()) {
                    az.aq(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    az.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            az.aq("obj_param5", ai(blp));
        }
        return az;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eLr == null || this.eLr.boj() == null || this.eLr.boj().video_url == null) {
            return null;
        }
        return this.eLr.boj().video_url;
    }

    public int ai(cb cbVar) {
        if (cbVar == null) {
            return 1;
        }
        if (cbVar.bpQ() || cbVar.bpP()) {
            return 2;
        }
        return (cbVar.bmz() || cbVar.bmA()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmx() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar ctc() {
        ar az = az(iCE, true);
        if (blp() != null) {
            cb blp = blp();
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
            }
            az.aq("obj_param5", ai(blp));
            az.dR(IntentConfig.NID, blp.bmq());
        }
        return az;
    }
}
