package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes20.dex */
public class l extends b implements com.baidu.tbadk.core.util.f.a {
    public boolean icA = false;
    public boolean icF = true;
    public int sourceType = 0;
    public static final BdUniqueId eCo = BdUniqueId.gen();
    public static String icl = "";
    public static String icm = "";
    public static String icB = "";
    public static String ick = "";
    public static String icC = "";
    public static String icD = "";
    public static String icE = "";

    public l(bx bxVar) {
        this.evQ = bxVar;
    }

    public static boolean ad(bx bxVar) {
        return (bxVar == null || bxVar.blU() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.evQ == null) {
            return k.TYPE;
        }
        if (this.ibP) {
            if (this.eBN) {
                return bx.eBS;
            }
            return this.evQ.getType();
        } else if (this.eBx) {
            return k.icq;
        } else {
            if (this.ibN) {
                return eCo;
            }
            if (this.eBD) {
                return k.icv;
            }
            if (this.eBE) {
                return k.icx;
            }
            if (this.ibO) {
                return k.icw;
            }
            if (this.eBN) {
                return k.eBW;
            }
            if (this.eBJ) {
                return k.eCi;
            }
            if (this.eBL) {
                return k.eCk;
            }
            if (this.eBM) {
                return k.eCl;
            }
            return eCo;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        if (this.evQ == null) {
            return null;
        }
        if (this.evQ.blq() != 5) {
            this.evQ.oe(1);
        }
        return this.evQ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bje() {
        if (this.evQ == null) {
            return null;
        }
        return this.evQ.eEl;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar IF(String str) {
        ar arVar = new ar(str);
        if (this.evQ != null) {
            arVar.w("fid", this.evQ.getFid());
            arVar.dR("tid", this.evQ.getTid());
            if (this.evQ.bkl()) {
                arVar.ak("obj_type", 8);
            } else if (this.evQ.bnA()) {
                arVar.ak("obj_type", 9);
            } else if (this.evQ.bki()) {
                arVar.ak("obj_type", 2);
            }
            arVar.ak("obj_param1", cok() ? 2 : 1);
            if (this.evQ.blC() != null) {
                arVar.dR("obj_id", this.evQ.blC().getUserId());
            }
        }
        return arVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar coo() {
        ar aI = aI(icB, true);
        if (aI != null && bjd() != null) {
            bx bjd = bjd();
            aI.ak("obj_name", bjd.bnh() != null && (bjd.bnh().dJS() != null || bjd.bnh().bFj() != null) ? 1 : 0);
            if (bjd.blC() != null) {
                aI.ak(TiebaInitialize.Params.AB_TYPE, bjd.blC().hadConcerned() ? 1 : 0);
            }
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
            }
            aI.ak("obj_param5", ah(bjd));
            if (bjd.bnG()) {
                aI.ak(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aI.ak(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aI;
    }

    public ar b(bx bxVar, int i) {
        ar aI = aI(ick, true);
        if (aI != null) {
            if (i != -1) {
                aI.ak("click_locate", i);
            }
            if (bjd() != null) {
                bx bjd = bjd();
                if (bjd.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
                }
                aI.ak("obj_param5", ah(bjd));
            }
        }
        return aI;
    }

    public ar ai(bx bxVar) {
        return b(bxVar, -1);
    }

    public ar cox() {
        ar aI = aI(icE, true);
        if (aI != null && bjd() != null) {
            bx bjd = bjd();
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
            }
            aI.ak("obj_param5", ah(bjd));
            aI.dR("nid", bjd.getNid());
        }
        return aI;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar col() {
        ar aI = aI(icm, true);
        if (aI != null && bjd() != null) {
            bx bjd = bjd();
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
            }
            aI.ak("obj_param5", ah(bjd));
        }
        return aI;
    }

    public ar aj(bx bxVar) {
        ar aI = aI(icl, true);
        if (aI != null && bjd() != null) {
            bx bjd = bjd();
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
                if (bjd.bnG()) {
                    aI.ak(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aI.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aI.ak("obj_param5", ah(bjd));
        }
        return aI;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.evQ == null || this.evQ.blU() == null || this.evQ.blU().video_url == null) {
            return null;
        }
        return this.evQ.blU().video_url;
    }

    public int ah(bx bxVar) {
        if (bxVar == null) {
            return 1;
        }
        if (bxVar.bnA() || bxVar.bnz()) {
            return 2;
        }
        return (bxVar.bkk() || bxVar.bkl()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bki() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar con() {
        ar aI = aI(ick, true);
        if (bjd() != null) {
            bx bjd = bjd();
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
            }
            aI.ak("obj_param5", ah(bjd));
            aI.dR("nid", bjd.getNid());
        }
        return aI;
    }
}
