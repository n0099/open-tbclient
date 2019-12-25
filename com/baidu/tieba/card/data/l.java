package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes5.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId cNl = BdUniqueId.gen();
    public static final BdUniqueId fHG = BdUniqueId.gen();
    public static final BdUniqueId fHH = BdUniqueId.gen();
    public static String fHk = "";
    public static String fHl = "";
    public static String fHI = "";
    public static String fHj = "";
    public static String fHJ = "";
    public static String fHK = "";
    public static String fHL = "";
    public boolean fHF = false;
    public boolean fHM = true;
    public boolean cMG = false;
    public boolean fHN = false;
    public boolean cMM = false;
    public boolean cMN = false;
    public boolean fHD = false;
    public boolean fHE = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.cMR = bjVar;
    }

    public static boolean Y(bj bjVar) {
        return (bjVar == null || bjVar.azV() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cMR == null) {
            return k.TYPE;
        }
        if (this.cMG) {
            return k.fHq;
        }
        if (this.fHN) {
            return cNl;
        }
        if (this.cMM) {
            return k.fHz;
        }
        if (this.cMN) {
            return k.fHy;
        }
        if (this.fHD) {
            return k.fHw;
        }
        if (this.fHE) {
            return k.fHx;
        }
        return cNl;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        if (this.cMR == null) {
            return null;
        }
        if (this.cMR.azs() != 5) {
            this.cMR.jr(1);
        }
        return this.cMR;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axy() {
        if (this.cMR == null) {
            return null;
        }
        return this.cMR.cPj;
    }

    public an zy(String str) {
        an anVar = new an(str);
        if (this.cMR != null) {
            anVar.s("fid", this.cMR.getFid());
            anVar.cp("tid", this.cMR.getTid());
            if (this.cMR.aBz()) {
                anVar.Z("obj_type", 8);
            } else if (this.cMR.aBB()) {
                anVar.Z("obj_type", 9);
            } else if (this.cMR.aAE()) {
                anVar.Z("obj_type", 2);
            }
            anVar.Z("obj_param1", bsN() ? 2 : 1);
            if (this.cMR.azE() != null) {
                anVar.cp("obj_id", this.cMR.azE().getUserId());
            }
        }
        return anVar;
    }

    public an bsT() {
        an af = af(fHI, true);
        if (af != null && axx() != null) {
            bj axx = axx();
            af.Z("obj_name", axx.aBe() != null && (axx.aBe().cIv() != null || axx.aBe().aRn() != null) ? 1 : 0);
            if (axx.azE() != null) {
                af.Z(TiebaInitialize.Params.AB_TYPE, axx.azE().hadConcerned() ? 1 : 0);
            }
            if (axx.getBaijiahaoData() != null) {
                af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ac(axx));
        }
        return af;
    }

    public an b(bj bjVar, int i) {
        an af = af(fHj, true);
        if (af != null) {
            if (i != -1) {
                af.Z("click_locate", i);
            }
            if (axx() != null) {
                bj axx = axx();
                if (axx.getBaijiahaoData() != null) {
                    af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                    af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
                }
                af.Z("obj_param5", ac(axx));
            }
        }
        return af;
    }

    public an ad(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bta() {
        an af = af(fHL, true);
        if (af != null && axx() != null) {
            bj axx = axx();
            if (axx.getBaijiahaoData() != null) {
                af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ac(axx));
        }
        return af;
    }

    public an bsV() {
        an af = af(fHl, true);
        if (af != null && axx() != null) {
            bj axx = axx();
            if (axx.getBaijiahaoData() != null) {
                af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ac(axx));
        }
        return af;
    }

    public an ae(bj bjVar) {
        an af = af(fHk, true);
        if (af != null && axx() != null) {
            bj axx = axx();
            if (axx.getBaijiahaoData() != null) {
                af.cp("obj_param4", axx.getBaijiahaoData().oriUgcNid);
                af.cp("obj_param6", axx.getBaijiahaoData().oriUgcVid);
            }
            af.Z("obj_param5", ac(axx));
        }
        return af;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cMR == null || this.cMR.azV() == null || this.cMR.azV().video_url == null) {
            return null;
        }
        return this.cMR.azV().video_url;
    }

    public int ac(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aBB() || bjVar.aBA()) {
            return 2;
        }
        return (bjVar.ays() || bjVar.aBz()) ? 3 : 1;
    }
}
