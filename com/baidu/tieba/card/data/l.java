package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dEV = BdUniqueId.gen();
    public static String gHA = "";
    public static String gHB = "";
    public static String gHU = "";
    public static String gHz = "";
    public static String gHV = "";
    public static String gHW = "";
    public static String gHX = "";
    public boolean gHT = false;
    public boolean gHY = true;
    public boolean dEo = false;
    public boolean gHZ = false;
    public boolean dEu = false;
    public boolean dEv = false;
    public boolean gHS = false;
    public boolean gHQ = false;
    public int sourceType = 0;

    public l(bk bkVar) {
        this.dEA = bkVar;
    }

    public static boolean ac(bk bkVar) {
        return (bkVar == null || bkVar.aQQ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.dEA == null) {
            return k.TYPE;
        }
        if (this.dEo) {
            return k.gHF;
        }
        if (this.gHZ) {
            return dEV;
        }
        if (this.dEu) {
            return k.gHL;
        }
        if (this.dEv) {
            return k.gHN;
        }
        if (this.gHS) {
            return k.gHM;
        }
        if (this.gHQ) {
            return k.gHG;
        }
        return dEV;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        if (this.dEA == null) {
            return null;
        }
        if (this.dEA.aQl() != 5) {
            this.dEA.kr(1);
        }
        return this.dEA;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aOj() {
        if (this.dEA == null) {
            return null;
        }
        return this.dEA.dGS;
    }

    public an Dt(String str) {
        an anVar = new an(str);
        if (this.dEA != null) {
            anVar.s("fid", this.dEA.getFid());
            anVar.dh("tid", this.dEA.getTid());
            if (this.dEA.aPn()) {
                anVar.ag("obj_type", 8);
            } else if (this.dEA.aSw()) {
                anVar.ag("obj_type", 9);
            } else if (this.dEA.aPk()) {
                anVar.ag("obj_type", 2);
            }
            anVar.ag("obj_param1", bLG() ? 2 : 1);
            if (this.dEA.aQx() != null) {
                anVar.dh("obj_id", this.dEA.aQx().getUserId());
            }
        }
        return anVar;
    }

    public an bLN() {
        an ay = ay(gHU, true);
        if (ay != null && aOi() != null) {
            bk aOi = aOi();
            ay.ag("obj_name", aOi.aSb() != null && (aOi.aSb().ddL() != null || aOi.aSb().biA() != null) ? 1 : 0);
            if (aOi.aQx() != null) {
                ay.ag(TiebaInitialize.Params.AB_TYPE, aOi.aQx().hadConcerned() ? 1 : 0);
            }
            if (aOi.getBaijiahaoData() != null) {
                ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
            }
            ay.ag("obj_param5", ag(aOi));
        }
        return ay;
    }

    public an b(bk bkVar, int i) {
        an ay = ay(gHz, true);
        if (ay != null) {
            if (i != -1) {
                ay.ag("click_locate", i);
            }
            if (aOi() != null) {
                bk aOi = aOi();
                if (aOi.getBaijiahaoData() != null) {
                    ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                    ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
                }
                ay.ag("obj_param5", ag(aOi));
            }
        }
        return ay;
    }

    public an ah(bk bkVar) {
        return b(bkVar, -1);
    }

    public an bLU() {
        an ay = ay(gHX, true);
        if (ay != null && aOi() != null) {
            bk aOi = aOi();
            if (aOi.getBaijiahaoData() != null) {
                ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
            }
            ay.ag("obj_param5", ag(aOi));
            ay.dh("nid", aOi.getNid());
        }
        return ay;
    }

    public an ai(bk bkVar) {
        an ay = ay(gHA, true);
        if (ay != null && aOi() != null) {
            bk aOi = aOi();
            if (aOi.getBaijiahaoData() != null) {
                ay.dh("obj_param4", aOi.getBaijiahaoData().oriUgcNid);
                ay.dh("obj_param6", aOi.getBaijiahaoData().oriUgcVid);
            }
            ay.ag("obj_param5", ag(aOi));
        }
        return ay;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dEA == null || this.dEA.aQQ() == null || this.dEA.aQQ().video_url == null) {
            return null;
        }
        return this.dEA.aQQ().video_url;
    }

    public int ag(bk bkVar) {
        if (bkVar == null) {
            return 1;
        }
        if (bkVar.aSw() || bkVar.aSv()) {
            return 2;
        }
        return (bkVar.aPm() || bkVar.aPn()) ? 3 : 1;
    }
}
