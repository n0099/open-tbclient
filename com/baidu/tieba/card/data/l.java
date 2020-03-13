package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId cRA = BdUniqueId.gen();
    public static final BdUniqueId fNB = BdUniqueId.gen();
    public static final BdUniqueId fNC = BdUniqueId.gen();
    public static String fNf = "";
    public static String fNg = "";
    public static String fND = "";
    public static String fNe = "";
    public static String fNE = "";
    public static String fNF = "";
    public static String fNG = "";
    public boolean fNA = false;
    public boolean fNH = true;
    public boolean cQV = false;
    public boolean fNI = false;
    public boolean cRb = false;
    public boolean cRc = false;
    public boolean fNy = false;
    public boolean fNz = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cRg = bjVar;
    }

    public static boolean aa(bj bjVar) {
        return (bjVar == null || bjVar.aCF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRg == null) {
            return k.TYPE;
        }
        if (this.cQV) {
            return k.fNl;
        }
        if (this.fNI) {
            return cRA;
        }
        if (this.cRb) {
            return k.fNu;
        }
        if (this.cRc) {
            return k.fNt;
        }
        if (this.fNy) {
            return k.fNr;
        }
        if (this.fNz) {
            return k.fNs;
        }
        return cRA;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        if (this.cRg == null) {
            return null;
        }
        if (this.cRg.aCc() != 5) {
            this.cRg.jI(1);
        }
        return this.cRg;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        if (this.cRg == null) {
            return null;
        }
        return this.cRg.cTx;
    }

    public an zZ(String str) {
        an anVar = new an(str);
        if (this.cRg != null) {
            anVar.s("fid", this.cRg.getFid());
            anVar.cy("tid", this.cRg.getTid());
            if (this.cRg.aBe()) {
                anVar.X("obj_type", 8);
            } else if (this.cRg.aEh()) {
                anVar.X("obj_type", 9);
            } else if (this.cRg.aBb()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_param1", bvw() ? 2 : 1);
            if (this.cRg.aCo() != null) {
                anVar.cy("obj_id", this.cRg.aCo().getUserId());
            }
        }
        return anVar;
    }

    public an bvC() {
        an af = af(fND, true);
        if (af != null && aAg() != null) {
            bj aAg = aAg();
            af.X("obj_name", aAg.aDM() != null && (aAg.aDM().cLd() != null || aAg.aDM().aUb() != null) ? 1 : 0);
            if (aAg.aCo() != null) {
                af.X(TiebaInitialize.Params.AB_TYPE, aAg.aCo().hadConcerned() ? 1 : 0);
            }
            if (aAg.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAg));
        }
        return af;
    }

    public an b(bj bjVar, int i) {
        an af = af(fNe, true);
        if (af != null) {
            if (i != -1) {
                af.X("click_locate", i);
            }
            if (aAg() != null) {
                bj aAg = aAg();
                if (aAg.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAg));
            }
        }
        return af;
    }

    public an af(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bvJ() {
        an af = af(fNG, true);
        if (af != null && aAg() != null) {
            bj aAg = aAg();
            if (aAg.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAg));
        }
        return af;
    }

    public an bvE() {
        an af = af(fNg, true);
        if (af != null && aAg() != null) {
            bj aAg = aAg();
            if (aAg.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAg));
        }
        return af;
    }

    public an ag(bj bjVar) {
        an af = af(fNf, true);
        if (af != null && aAg() != null) {
            bj aAg = aAg();
            if (aAg.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAg.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAg.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAg));
        }
        return af;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.cRg == null || this.cRg.aCF() == null || this.cRg.aCF().video_url == null) {
            return null;
        }
        return this.cRg.aCF().video_url;
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEh() || bjVar.aEg()) {
            return 2;
        }
        return (bjVar.aBd() || bjVar.aBe()) ? 3 : 1;
    }
}
