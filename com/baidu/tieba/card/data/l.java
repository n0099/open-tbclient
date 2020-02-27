package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId cRy = BdUniqueId.gen();
    public static final BdUniqueId fNm = BdUniqueId.gen();
    public static final BdUniqueId fNn = BdUniqueId.gen();
    public static String fMQ = "";
    public static String fMR = "";
    public static String fNo = "";
    public static String fMP = "";
    public static String fNp = "";
    public static String fNq = "";
    public static String fNr = "";
    public boolean fNl = false;
    public boolean fNs = true;
    public boolean cQT = false;
    public boolean fNt = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    public boolean fNj = false;
    public boolean fNk = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cRe = bjVar;
    }

    public static boolean aa(bj bjVar) {
        return (bjVar == null || bjVar.aCD() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cRe == null) {
            return k.TYPE;
        }
        if (this.cQT) {
            return k.fMW;
        }
        if (this.fNt) {
            return cRy;
        }
        if (this.cQZ) {
            return k.fNf;
        }
        if (this.cRa) {
            return k.fNe;
        }
        if (this.fNj) {
            return k.fNc;
        }
        if (this.fNk) {
            return k.fNd;
        }
        return cRy;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAe() {
        if (this.cRe == null) {
            return null;
        }
        if (this.cRe.aCa() != 5) {
            this.cRe.jI(1);
        }
        return this.cRe;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAf() {
        if (this.cRe == null) {
            return null;
        }
        return this.cRe.cTv;
    }

    public an zY(String str) {
        an anVar = new an(str);
        if (this.cRe != null) {
            anVar.s("fid", this.cRe.getFid());
            anVar.cy("tid", this.cRe.getTid());
            if (this.cRe.aBc()) {
                anVar.X("obj_type", 8);
            } else if (this.cRe.aEf()) {
                anVar.X("obj_type", 9);
            } else if (this.cRe.aAZ()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_param1", bvt() ? 2 : 1);
            if (this.cRe.aCm() != null) {
                anVar.cy("obj_id", this.cRe.aCm().getUserId());
            }
        }
        return anVar;
    }

    public an bvz() {
        an af = af(fNo, true);
        if (af != null && aAe() != null) {
            bj aAe = aAe();
            af.X("obj_name", aAe.aDK() != null && (aAe.aDK().cLa() != null || aAe.aDK().aTY() != null) ? 1 : 0);
            if (aAe.aCm() != null) {
                af.X(TiebaInitialize.Params.AB_TYPE, aAe.aCm().hadConcerned() ? 1 : 0);
            }
            if (aAe.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAe));
        }
        return af;
    }

    public an b(bj bjVar, int i) {
        an af = af(fMP, true);
        if (af != null) {
            if (i != -1) {
                af.X("click_locate", i);
            }
            if (aAe() != null) {
                bj aAe = aAe();
                if (aAe.getBaijiahaoData() != null) {
                    af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                    af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
                }
                af.X("obj_param5", ae(aAe));
            }
        }
        return af;
    }

    public an af(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bvG() {
        an af = af(fNr, true);
        if (af != null && aAe() != null) {
            bj aAe = aAe();
            if (aAe.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAe));
        }
        return af;
    }

    public an bvB() {
        an af = af(fMR, true);
        if (af != null && aAe() != null) {
            bj aAe = aAe();
            if (aAe.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAe));
        }
        return af;
    }

    public an ag(bj bjVar) {
        an af = af(fMQ, true);
        if (af != null && aAe() != null) {
            bj aAe = aAe();
            if (aAe.getBaijiahaoData() != null) {
                af.cy("obj_param4", aAe.getBaijiahaoData().oriUgcNid);
                af.cy("obj_param6", aAe.getBaijiahaoData().oriUgcVid);
            }
            af.X("obj_param5", ae(aAe));
        }
        return af;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cRe == null || this.cRe.aCD() == null || this.cRe.aCD().video_url == null) {
            return null;
        }
        return this.cRe.aCD().video_url;
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aEf() || bjVar.aEe()) {
            return 2;
        }
        return (bjVar.aBb() || bjVar.aBc()) ? 3 : 1;
    }
}
