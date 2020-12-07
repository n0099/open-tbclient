package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class l extends b implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId eJq = BdUniqueId.gen();
    public static String ini = "";
    public static String inj = "";
    public static String inz = "";
    public static String inh = "";
    public static String inA = "";
    public static String inB = "";
    public static String inC = "";
    public boolean iny = false;
    public boolean inD = true;
    public int sourceType = 0;

    public l(by byVar) {
        this.eCR = byVar;
    }

    public static boolean ad(by byVar) {
        return (byVar == null || byVar.bph() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eCR == null) {
            return k.TYPE;
        }
        if (this.imM) {
            if (this.eIO) {
                return by.eIT;
            }
            return this.eCR.getType();
        } else if (this.eIy) {
            return k.inn;
        } else {
            if (this.imK) {
                return eJq;
            }
            if (this.eIE) {
                return k.f4int;
            }
            if (this.eIF) {
                return k.inv;
            }
            if (this.imL) {
                return k.inu;
            }
            if (this.eIO) {
                return k.eIX;
            }
            if (this.eIK) {
                return k.eJj;
            }
            if (this.eIM) {
                return k.eJl;
            }
            if (this.eIN) {
                return k.eJm;
            }
            return eJq;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        if (this.eCR == null) {
            return null;
        }
        if (this.eCR.boD() != 5) {
            this.eCR.oC(1);
        }
        return this.eCR;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmo() {
        if (this.eCR == null) {
            return null;
        }
        return this.eCR.eLn;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar Jv(String str) {
        ar arVar = new ar(str);
        if (this.eCR != null) {
            arVar.w("fid", this.eCR.getFid());
            arVar.dY("tid", this.eCR.getTid());
            if (this.eCR.bny()) {
                arVar.al("obj_type", 8);
            } else if (this.eCR.bqN()) {
                arVar.al("obj_type", 9);
            } else if (this.eCR.bnv()) {
                arVar.al("obj_type", 2);
            }
            arVar.al("obj_param1", csx() ? 2 : 1);
            if (this.eCR.boP() != null) {
                arVar.dY("obj_id", this.eCR.boP().getUserId());
            }
        }
        return arVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csB() {
        ar aJ = aJ(inz, true);
        if (aJ != null && bmn() != null) {
            by bmn = bmn();
            aJ.al("obj_name", bmn.bqu() != null && (bmn.bqu().dPi() != null || bmn.bqu().bIK() != null) ? 1 : 0);
            if (bmn.boP() != null) {
                aJ.al(TiebaInitialize.Params.AB_TYPE, bmn.boP().hadConcerned() ? 1 : 0);
            }
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
            }
            aJ.al("obj_param5", ah(bmn));
            if (bmn.bqU()) {
                aJ.al(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aJ.al(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aJ;
    }

    public ar b(by byVar, int i) {
        ar aJ = aJ(inh, true);
        if (aJ != null) {
            if (i != -1) {
                aJ.al("click_locate", i);
            }
            if (bmn() != null) {
                by bmn = bmn();
                if (bmn.getBaijiahaoData() != null) {
                    aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                    aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
                }
                aJ.al("obj_param5", ah(bmn));
            }
        }
        return aJ;
    }

    public ar ai(by byVar) {
        return b(byVar, -1);
    }

    public ar csK() {
        ar aJ = aJ(inC, true);
        if (aJ != null && bmn() != null) {
            by bmn = bmn();
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
            }
            aJ.al("obj_param5", ah(bmn));
        }
        return aJ;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csy() {
        ar aJ = aJ(inj, true);
        if (aJ != null && bmn() != null) {
            by bmn = bmn();
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
            }
            aJ.al("obj_param5", ah(bmn));
        }
        return aJ;
    }

    public ar aj(by byVar) {
        ar aJ = aJ(ini, true);
        if (aJ != null && bmn() != null) {
            by bmn = bmn();
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
                if (bmn.bqU()) {
                    aJ.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aJ.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aJ.al("obj_param5", ah(bmn));
        }
        return aJ;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eCR == null || this.eCR.bph() == null || this.eCR.bph().video_url == null) {
            return null;
        }
        return this.eCR.bph().video_url;
    }

    public int ah(by byVar) {
        if (byVar == null) {
            return 1;
        }
        if (byVar.bqN() || byVar.bqM()) {
            return 2;
        }
        return (byVar.bnx() || byVar.bny()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bnv() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csA() {
        ar aJ = aJ(inh, true);
        if (bmn() != null) {
            by bmn = bmn();
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
            }
            aJ.al("obj_param5", ah(bmn));
            aJ.dY("nid", bmn.getNid());
        }
        return aJ;
    }
}
