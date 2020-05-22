package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dEV = BdUniqueId.gen();
    public static String gHp = "";
    public static String gHq = "";
    public static String gHJ = "";
    public static String gHo = "";
    public static String gHK = "";
    public static String gHL = "";
    public static String gHM = "";
    public boolean gHI = false;
    public boolean gHN = true;
    public boolean dEo = false;
    public boolean gHO = false;
    public boolean dEu = false;
    public boolean dEv = false;
    public boolean gHH = false;
    public boolean gHF = false;
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
            return k.gHu;
        }
        if (this.gHO) {
            return dEV;
        }
        if (this.dEu) {
            return k.gHA;
        }
        if (this.dEv) {
            return k.gHC;
        }
        if (this.gHH) {
            return k.gHB;
        }
        if (this.gHF) {
            return k.gHv;
        }
        return dEV;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        if (this.dEA == null) {
            return null;
        }
        if (this.dEA.aQl() != 5) {
            this.dEA.kp(1);
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
            anVar.ag("obj_param1", bLE() ? 2 : 1);
            if (this.dEA.aQx() != null) {
                anVar.dh("obj_id", this.dEA.aQx().getUserId());
            }
        }
        return anVar;
    }

    public an bLL() {
        an ay = ay(gHJ, true);
        if (ay != null && aOi() != null) {
            bk aOi = aOi();
            ay.ag("obj_name", aOi.aSb() != null && (aOi.aSb().ddw() != null || aOi.aSb().biy() != null) ? 1 : 0);
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
        an ay = ay(gHo, true);
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

    public an bLS() {
        an ay = ay(gHM, true);
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
        an ay = ay(gHp, true);
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
