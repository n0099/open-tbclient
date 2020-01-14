package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId cNv = BdUniqueId.gen();
    public static final BdUniqueId fKQ = BdUniqueId.gen();
    public static final BdUniqueId fKR = BdUniqueId.gen();
    public static String fKu = "";
    public static String fKv = "";
    public static String fKS = "";
    public static String fKt = "";
    public static String fKT = "";
    public static String fKU = "";
    public static String fKV = "";
    public boolean fKP = false;
    public boolean fKW = true;
    public boolean cMQ = false;
    public boolean fKX = false;
    public boolean cMW = false;
    public boolean cMX = false;
    public boolean fKN = false;
    public boolean fKO = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cNb = bjVar;
    }

    public static boolean Z(bj bjVar) {
        return (bjVar == null || bjVar.aAo() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cNb == null) {
            return k.TYPE;
        }
        if (this.cMQ) {
            return k.fKA;
        }
        if (this.fKX) {
            return cNv;
        }
        if (this.cMW) {
            return k.fKJ;
        }
        if (this.cMX) {
            return k.fKI;
        }
        if (this.fKN) {
            return k.fKG;
        }
        if (this.fKO) {
            return k.fKH;
        }
        return cNv;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axQ() {
        if (this.cNb == null) {
            return null;
        }
        if (this.cNb.azL() != 5) {
            this.cNb.jr(1);
        }
        return this.cNb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axR() {
        if (this.cNb == null) {
            return null;
        }
        return this.cNb.cPt;
    }

    public an zI(String str) {
        an anVar = new an(str);
        if (this.cNb != null) {
            anVar.s("fid", this.cNb.getFid());
            anVar.cp("tid", this.cNb.getTid());
            if (this.cNb.aBS()) {
                anVar.Z("obj_type", 8);
            } else if (this.cNb.aBU()) {
                anVar.Z("obj_type", 9);
            } else if (this.cNb.aAX()) {
                anVar.Z("obj_type", 2);
            }
            anVar.Z("obj_param1", btP() ? 2 : 1);
            if (this.cNb.azX() != null) {
                anVar.cp("obj_id", this.cNb.azX().getUserId());
            }
        }
        return anVar;
    }

    public an btV() {
        an af = af(fKS, true);
        if (af != null && axQ() != null) {
            bj axQ = axQ();
            af.Z("obj_name", axQ.aBx() != null && (axQ.aBx().cJB() != null || axQ.aBx().aRH() != null) ? 1 : 0);
            if (axQ.azX() != null) {
                af.Z(TiebaInitialize.Params.AB_TYPE, axQ.azX().hadConcerned() ? 1 : 0);
            }
            if (axQ.getBaijiahaoData() != null) {
                af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ad(axQ));
        }
        return af;
    }

    public an b(bj bjVar, int i) {
        an af = af(fKt, true);
        if (af != null) {
            if (i != -1) {
                af.Z("click_locate", i);
            }
            if (axQ() != null) {
                bj axQ = axQ();
                if (axQ.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ad(axQ));
            }
        }
        return af;
    }

    public an ae(bj bjVar) {
        return b(bjVar, -1);
    }

    public an buc() {
        an af = af(fKV, true);
        if (af != null && axQ() != null) {
            bj axQ = axQ();
            if (axQ.getBaijiahaoData() != null) {
                af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ad(axQ));
        }
        return af;
    }

    public an btX() {
        an af = af(fKv, true);
        if (af != null && axQ() != null) {
            bj axQ = axQ();
            if (axQ.getBaijiahaoData() != null) {
                af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ad(axQ));
        }
        return af;
    }

    public an af(bj bjVar) {
        an af = af(fKu, true);
        if (af != null && axQ() != null) {
            bj axQ = axQ();
            if (axQ.getBaijiahaoData() != null) {
                af.cp("obj_param4", axQ.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axQ.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ad(axQ));
        }
        return af;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cNb == null || this.cNb.aAo() == null || this.cNb.aAo().video_url == null) {
            return null;
        }
        return this.cNb.aAo().video_url;
    }

    public int ad(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aBU() || bjVar.aBT()) {
            return 2;
        }
        return (bjVar.ayL() || bjVar.aBS()) ? 3 : 1;
    }
}
