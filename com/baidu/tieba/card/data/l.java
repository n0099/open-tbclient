package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId cRz = BdUniqueId.gen();
    public static final BdUniqueId fNo = BdUniqueId.gen();
    public static final BdUniqueId fNp = BdUniqueId.gen();
    public static String fMS = "";
    public static String fMT = "";
    public static String fNq = "";
    public static String fMR = "";
    public static String fNr = "";
    public static String fNs = "";
    public static String fNt = "";
    public boolean fNn = false;
    public boolean fNu = true;
    public boolean cQU = false;
    public boolean fNv = false;
    public boolean cRa = false;
    public boolean cRb = false;
    public boolean fNl = false;
    public boolean fNm = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cRf = bjVar;
    }

    public static boolean aa(bj bjVar) {
        return (bjVar == null || bjVar.aCF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRf == null) {
            return k.TYPE;
        }
        if (this.cQU) {
            return k.fMY;
        }
        if (this.fNv) {
            return cRz;
        }
        if (this.cRa) {
            return k.fNh;
        }
        if (this.cRb) {
            return k.fNg;
        }
        if (this.fNl) {
            return k.fNe;
        }
        if (this.fNm) {
            return k.fNf;
        }
        return cRz;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        if (this.cRf == null) {
            return null;
        }
        if (this.cRf.aCc() != 5) {
            this.cRf.jI(1);
        }
        return this.cRf;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        if (this.cRf == null) {
            return null;
        }
        return this.cRf.cTw;
    }

    public an zY(String str) {
        an anVar = new an(str);
        if (this.cRf != null) {
            anVar.s("fid", this.cRf.getFid());
            anVar.cy("tid", this.cRf.getTid());
            if (this.cRf.aBe()) {
                anVar.X("obj_type", 8);
            } else if (this.cRf.aEh()) {
                anVar.X("obj_type", 9);
            } else if (this.cRf.aBb()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_param1", bvv() ? 2 : 1);
            if (this.cRf.aCo() != null) {
                anVar.cy("obj_id", this.cRf.aCo().getUserId());
            }
        }
        return anVar;
    }

    public an bvB() {
        an af = af(fNq, true);
        if (af != null && aAg() != null) {
            bj aAg = aAg();
            af.X("obj_name", aAg.aDM() != null && (aAg.aDM().cLc() != null || aAg.aDM().aUa() != null) ? 1 : 0);
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
        an af = af(fMR, true);
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

    public an bvI() {
        an af = af(fNt, true);
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

    public an bvD() {
        an af = af(fMT, true);
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
        an af = af(fMS, true);
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

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cRf == null || this.cRf.aCF() == null || this.cRf.aCF().video_url == null) {
            return null;
        }
        return this.cRf.aCF().video_url;
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
