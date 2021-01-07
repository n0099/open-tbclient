package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class l extends b implements com.baidu.tbadk.core.util.g.a {
    public boolean izU = false;
    public boolean izZ = true;
    public int sourceType = 0;
    public static final BdUniqueId eTj = BdUniqueId.gen();
    public static String izF = "";
    public static String izG = "";
    public static String izV = "";
    public static String izE = "";
    public static String izW = "";
    public static String izX = "";
    public static String izY = "";

    public l(bz bzVar) {
        this.eMv = bzVar;
    }

    public static boolean ad(bz bzVar) {
        return (bzVar == null || bzVar.brI() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eMv == null) {
            return k.TYPE;
        }
        if (this.izj) {
            if (this.eSH) {
                return bz.eSM;
            }
            return this.eMv.getType();
        } else if (this.eSq) {
            return k.izK;
        } else {
            if (this.izh) {
                return eTj;
            }
            if (this.eSw) {
                return k.izP;
            }
            if (this.eSx) {
                return k.izR;
            }
            if (this.izi) {
                return k.izQ;
            }
            if (this.eSH) {
                return k.eSQ;
            }
            if (this.eSD) {
                return k.eTc;
            }
            if (this.eSF) {
                return k.eTe;
            }
            if (this.eSG) {
                return k.eTf;
            }
            return eTj;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boP() {
        if (this.eMv == null) {
            return null;
        }
        if (this.eMv.brf() != 5) {
            this.eMv.oM(1);
        }
        return this.eMv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String boQ() {
        if (this.eMv == null) {
            return null;
        }
        return this.eMv.eVh;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq Js(String str) {
        aq aqVar = new aq(str);
        if (this.eMv != null) {
            aqVar.w("fid", this.eMv.getFid());
            aqVar.dX("tid", this.eMv.getTid());
            if (this.eMv.bpZ()) {
                aqVar.an("obj_type", 8);
            } else if (this.eMv.btq()) {
                aqVar.an("obj_type", 9);
            } else if (this.eMv.bpW()) {
                aqVar.an("obj_type", 2);
            }
            aqVar.an("obj_param1", cvs() ? 2 : 1);
            if (this.eMv.brr() != null) {
                aqVar.dX("obj_id", this.eMv.brr().getUserId());
            }
        }
        return aqVar;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvw() {
        aq aA = aA(izV, true);
        if (aA != null && boP() != null) {
            bz boP = boP();
            aA.an("obj_name", boP.bsX() != null && (boP.bsX().dPg() != null || boP.bsX().bLf() != null) ? 1 : 0);
            if (boP.brr() != null) {
                aA.an(TiebaInitialize.Params.AB_TYPE, boP.brr().hadConcerned() ? 1 : 0);
            }
            if (boP.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(boP));
            if (boP.btx()) {
                aA.an(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aA.an(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aA;
    }

    public aq b(bz bzVar, int i) {
        aq aA = aA(izE, true);
        if (aA != null) {
            if (i != -1) {
                aA.an("click_locate", i);
            }
            if (boP() != null) {
                bz boP = boP();
                if (boP.getBaijiahaoData() != null) {
                    aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                    aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(boP));
            }
        }
        return aA;
    }

    public aq ai(bz bzVar) {
        return b(bzVar, -1);
    }

    public aq cvF() {
        aq aA = aA(izY, true);
        if (aA != null && boP() != null) {
            bz boP = boP();
            if (boP.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(boP));
        }
        return aA;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvt() {
        aq aA = aA(izG, true);
        if (aA != null && boP() != null) {
            bz boP = boP();
            if (boP.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(boP));
        }
        return aA;
    }

    public aq aj(bz bzVar) {
        aq aA = aA(izF, true);
        if (aA != null && boP() != null) {
            bz boP = boP();
            if (boP.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
                if (boP.btx()) {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aA.an("obj_param5", ah(boP));
        }
        return aA;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eMv == null || this.eMv.brI() == null || this.eMv.brI().video_url == null) {
            return null;
        }
        return this.eMv.brI().video_url;
    }

    public int ah(bz bzVar) {
        if (bzVar == null) {
            return 1;
        }
        if (bzVar.btq() || bzVar.btp()) {
            return 2;
        }
        return (bzVar.bpY() || bzVar.bpZ()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bpW() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvv() {
        aq aA = aA(izE, true);
        if (boP() != null) {
            bz boP = boP();
            if (boP.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(boP));
            aA.dX(IntentConfig.NID, boP.bpP());
        }
        return aA;
    }
}
