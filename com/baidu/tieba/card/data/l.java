package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dLH = BdUniqueId.gen();
    public static String gUA = "";
    public static String gUB = "";
    public static String gUU = "";
    public static String gUz = "";
    public static String gUV = "";
    public static String gUW = "";
    public static String gUX = "";
    public boolean gUT = false;
    public boolean gUY = true;
    public boolean dKS = false;
    public boolean gUZ = false;
    public boolean dKY = false;
    public boolean dKZ = false;
    public boolean gUS = false;
    public boolean gUQ = false;
    public boolean dLe = false;
    public boolean dLg = false;
    public boolean dLh = false;
    public int sourceType = 0;

    public l(bu buVar) {
        this.dLi = buVar;
    }

    public static boolean ad(bu buVar) {
        return (buVar == null || buVar.aSH() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLi == null) {
            return k.TYPE;
        }
        if (this.dKS) {
            return k.gUF;
        }
        if (this.gUZ) {
            return dLH;
        }
        if (this.dKY) {
            return k.gUL;
        }
        if (this.dKZ) {
            return k.gUN;
        }
        if (this.gUS) {
            return k.gUM;
        }
        if (this.gUQ) {
            return k.gUG;
        }
        if (this.dLe) {
            return k.dLB;
        }
        if (this.dLg) {
            return k.dLD;
        }
        if (this.dLh) {
            return k.dLE;
        }
        return dLH;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        if (this.dLi == null) {
            return null;
        }
        if (this.dLi.aSd() != 5) {
            this.dLi.kF(1);
        }
        return this.dLi;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aPT() {
        if (this.dLi == null) {
            return null;
        }
        return this.dLi.dND;
    }

    public ao DU(String str) {
        ao aoVar = new ao(str);
        if (this.dLi != null) {
            aoVar.s("fid", this.dLi.getFid());
            aoVar.dk("tid", this.dLi.getTid());
            if (this.dLi.aQY()) {
                aoVar.ag("obj_type", 8);
            } else if (this.dLi.aUm()) {
                aoVar.ag("obj_type", 9);
            } else if (this.dLi.aQV()) {
                aoVar.ag("obj_type", 2);
            }
            aoVar.ag("obj_param1", bOQ() ? 2 : 1);
            if (this.dLi.aSp() != null) {
                aoVar.dk("obj_id", this.dLi.aSp().getUserId());
            }
        }
        return aoVar;
    }

    public ao bOX() {
        ao aA = aA(gUU, true);
        if (aA != null && aPS() != null) {
            bu aPS = aPS();
            aA.ag("obj_name", aPS.aTS() != null && (aPS.aTS().dia() != null || aPS.aTS().bkW() != null) ? 1 : 0);
            if (aPS.aSp() != null) {
                aA.ag(TiebaInitialize.Params.AB_TYPE, aPS.aSp().hadConcerned() ? 1 : 0);
            }
            if (aPS.getBaijiahaoData() != null) {
                aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
            }
            aA.ag("obj_param5", ah(aPS));
            if (aPS.aUt()) {
                aA.ag(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aA.ag(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aA;
    }

    public ao b(bu buVar, int i) {
        ao aA = aA(gUz, true);
        if (aA != null) {
            if (i != -1) {
                aA.ag("click_locate", i);
            }
            if (aPS() != null) {
                bu aPS = aPS();
                if (aPS.getBaijiahaoData() != null) {
                    aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                    aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
                }
                aA.ag("obj_param5", ah(aPS));
            }
        }
        return aA;
    }

    public ao ai(bu buVar) {
        return b(buVar, -1);
    }

    public ao bPe() {
        ao aA = aA(gUX, true);
        if (aA != null && aPS() != null) {
            bu aPS = aPS();
            if (aPS.getBaijiahaoData() != null) {
                aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
            }
            aA.ag("obj_param5", ah(aPS));
            aA.dk("nid", aPS.getNid());
        }
        return aA;
    }

    public ao aj(bu buVar) {
        ao aA = aA(gUA, true);
        if (aA != null && aPS() != null) {
            bu aPS = aPS();
            if (aPS.getBaijiahaoData() != null) {
                aA.dk("obj_param4", aPS.getBaijiahaoData().oriUgcNid);
                aA.dk("obj_param6", aPS.getBaijiahaoData().oriUgcVid);
                if (aPS.aUt()) {
                    aA.ag(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aA.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aA.ag("obj_param5", ah(aPS));
        }
        return aA;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dLi == null || this.dLi.aSH() == null || this.dLi.aSH().video_url == null) {
            return null;
        }
        return this.dLi.aSH().video_url;
    }

    public int ah(bu buVar) {
        if (buVar == null) {
            return 1;
        }
        if (buVar.aUm() || buVar.aUl()) {
            return 2;
        }
        return (buVar.aQX() || buVar.aQY()) ? 3 : 1;
    }
}
