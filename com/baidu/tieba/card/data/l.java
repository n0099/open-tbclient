package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId cRN = BdUniqueId.gen();
    public static final BdUniqueId fOj = BdUniqueId.gen();
    public static final BdUniqueId fOk = BdUniqueId.gen();
    public static String fNN = "";
    public static String fNO = "";
    public static String fOl = "";
    public static String fNM = "";
    public static String fOm = "";
    public static String fOn = "";
    public static String fOo = "";
    public boolean fOi = false;
    public boolean fOp = true;
    public boolean cRi = false;
    public boolean fOq = false;
    public boolean cRo = false;
    public boolean cRp = false;
    public boolean fOg = false;
    public boolean fOh = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cRt = bjVar;
    }

    public static boolean ab(bj bjVar) {
        return (bjVar == null || bjVar.aCI() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRt == null) {
            return k.TYPE;
        }
        if (this.cRi) {
            return k.fNT;
        }
        if (this.fOq) {
            return cRN;
        }
        if (this.cRo) {
            return k.fOc;
        }
        if (this.cRp) {
            return k.fOb;
        }
        if (this.fOg) {
            return k.fNZ;
        }
        if (this.fOh) {
            return k.fOa;
        }
        return cRN;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAj() {
        if (this.cRt == null) {
            return null;
        }
        if (this.cRt.aCf() != 5) {
            this.cRt.jI(1);
        }
        return this.cRt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAk() {
        if (this.cRt == null) {
            return null;
        }
        return this.cRt.cTK;
    }

    public an Aa(String str) {
        an anVar = new an(str);
        if (this.cRt != null) {
            anVar.s("fid", this.cRt.getFid());
            anVar.cx("tid", this.cRt.getTid());
            if (this.cRt.aBh()) {
                anVar.X("obj_type", 8);
            } else if (this.cRt.aEl()) {
                anVar.X("obj_type", 9);
            } else if (this.cRt.aBe()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_param1", bvB() ? 2 : 1);
            if (this.cRt.aCr() != null) {
                anVar.cx("obj_id", this.cRt.aCr().getUserId());
            }
        }
        return anVar;
    }

    public an bvH() {
        an af = af(fOl, true);
        if (af != null && aAj() != null) {
            bj aAj = aAj();
            af.X("obj_name", aAj.aDQ() != null && (aAj.aDQ().cLx() != null || aAj.aDQ().aUf() != null) ? 1 : 0);
            if (aAj.aCr() != null) {
                af.X(TiebaInitialize.Params.AB_TYPE, aAj.aCr().hadConcerned() ? 1 : 0);
            }
            if (aAj.getBaijiahaoData() != null) {
                af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", af(aAj));
        }
        return af;
    }

    public an b(bj bjVar, int i) {
        an af = af(fNM, true);
        if (af != null) {
            if (i != -1) {
                af.X("click_locate", i);
            }
            if (aAj() != null) {
                bj aAj = aAj();
                if (aAj.getBaijiahaoData() != null) {
                    af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                    af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", af(aAj));
            }
        }
        return af;
    }

    public an ag(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bvO() {
        an af = af(fOo, true);
        if (af != null && aAj() != null) {
            bj aAj = aAj();
            if (aAj.getBaijiahaoData() != null) {
                af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", af(aAj));
        }
        return af;
    }

    public an bvJ() {
        an af = af(fNO, true);
        if (af != null && aAj() != null) {
            bj aAj = aAj();
            if (aAj.getBaijiahaoData() != null) {
                af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", af(aAj));
        }
        return af;
    }

    public an ah(bj bjVar) {
        an af = af(fNN, true);
        if (af != null && aAj() != null) {
            bj aAj = aAj();
            if (aAj.getBaijiahaoData() != null) {
                af.cx("obj_param4", aAj.getBaijiahaoData().oriUgcNid);
                af.cx("obj_param6", aAj.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", af(aAj));
        }
        return af;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.cRt == null || this.cRt.aCI() == null || this.cRt.aCI().video_url == null) {
            return null;
        }
        return this.cRt.aCI().video_url;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEl() || bjVar.aEk()) {
            return 2;
        }
        return (bjVar.aBg() || bjVar.aBh()) ? 3 : 1;
    }
}
