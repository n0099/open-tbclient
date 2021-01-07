package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class k extends b {
    public static String izr = "";
    public static String izs = "";
    public static String izt = "";
    public static String izu = "";
    public static String izv = "";
    public static String izw = "";
    public static String izx = "";
    public static String izy = "";
    public static String izz = "";
    public static String izA = "";
    public static String izB = "";
    public static String izC = "";
    public static String izD = "";
    public static String izE = "";
    public static String izF = "";
    public static String izG = "";
    public static String izH = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId izI = BdUniqueId.gen();
    public static final BdUniqueId eTh = BdUniqueId.gen();
    public static final BdUniqueId eTo = BdUniqueId.gen();
    public static final BdUniqueId eTp = BdUniqueId.gen();
    public static final BdUniqueId eTq = BdUniqueId.gen();
    public static final BdUniqueId eTr = BdUniqueId.gen();
    public static final BdUniqueId eTv = BdUniqueId.gen();
    public static final BdUniqueId eTw = BdUniqueId.gen();
    public static final BdUniqueId izJ = BdUniqueId.gen();
    public static final BdUniqueId izK = BdUniqueId.gen();
    public static final BdUniqueId eSQ = BdUniqueId.gen();
    public static final BdUniqueId izL = BdUniqueId.gen();
    public static final BdUniqueId izM = BdUniqueId.gen();
    public static final BdUniqueId izN = BdUniqueId.gen();
    public static final BdUniqueId izO = BdUniqueId.gen();
    public static final BdUniqueId izP = BdUniqueId.gen();
    public static final BdUniqueId izQ = BdUniqueId.gen();
    public static final BdUniqueId izR = BdUniqueId.gen();
    public static final BdUniqueId eTc = BdUniqueId.gen();
    public static final BdUniqueId eTe = BdUniqueId.gen();
    public static final BdUniqueId eTf = BdUniqueId.gen();
    public boolean izS = false;
    public boolean isLinkThread = false;
    public boolean eSB = false;
    public boolean izT = false;
    public boolean izU = false;
    public boolean fFi = true;

    public static boolean ad(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        return bzVar.getType() == bz.eSL || bzVar.getType() == bz.eTi || bzVar.getType() == bz.eTh || bzVar.getType() == bz.eTo || bzVar.getType() == bz.eTt;
    }

    public static boolean af(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        return bzVar.getType() == bz.eTv || bzVar.getType() == bz.eTw;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.eMv == null) {
            return TYPE;
        }
        if (this.izj && b.iyZ.length > 1) {
            BdUniqueId type = this.eMv.getType();
            if (type == bz.eSL || type == bz.eTh || type == bz.eTt || type == bz.eTi) {
                if (this.eSH) {
                    indexOf = b.iyX.indexOf(b.iyO);
                } else {
                    indexOf = b.iyX.indexOf(b.iyN);
                }
                if (this.eSv) {
                    indexOf2 = b.iyY.indexOf(b.iyP);
                } else if (this.eSu) {
                    indexOf2 = b.iyY.indexOf(b.iyR);
                } else if (this.izg) {
                    indexOf2 = b.iyY.indexOf(b.iyQ);
                } else {
                    indexOf2 = b.iyY.indexOf(b.iyS);
                }
                if (indexOf >= 0 && indexOf < b.iyZ.length && indexOf2 >= 0 && indexOf2 < b.iyZ[0].length) {
                    return b.iyZ[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.eMv.threadType == 63) {
            return eTv;
        } else {
            if (this.eMv.threadType == 64) {
                return eTw;
            }
            if (this.eMv.isShareThread && this.eMv.eVB != null) {
                if (this.eMv.eVB.eQY) {
                    OriginalThreadInfo originalThreadInfo = this.eMv.eVB;
                    if (originalThreadInfo.videoInfo != null) {
                        return eTr;
                    }
                    if (originalThreadInfo.bpY()) {
                        return eTq;
                    }
                    return eTp;
                }
                return eTo;
            } else if (this.eSq) {
                return izK;
            } else {
                if (this.eSr) {
                    return izL;
                }
                if (this.izg) {
                    return izM;
                }
                if (this.eSu) {
                    return izN;
                }
                if (this.eSv) {
                    return izO;
                }
                if (this.eSw) {
                    return izP;
                }
                if (this.eSx) {
                    return izR;
                }
                if (this.izi) {
                    return izQ;
                }
                if (this.eSH) {
                    return eSQ;
                }
                if (this.eSD) {
                    return eTc;
                }
                if (this.eSF) {
                    return eTe;
                }
                if (this.eSG) {
                    return eTf;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boP() {
        if (this.eMv == null) {
            return null;
        }
        if (this.eMv.brf() == 5) {
            return this.eMv;
        }
        this.eMv.oM(1);
        return this.eMv;
    }

    public boolean cvA() {
        return (this.eMv == null || x.getCount(this.eMv.brE()) == 0) ? false : true;
    }

    public boolean cvB() {
        return this.eMv == null || this.eMv.bsw();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bpW() {
        return this.eMv != null && this.eMv.bpW();
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvw() {
        SmartApp bsg;
        if (cvA()) {
            aq Jr = Jr(izw);
            if (Jr != null) {
                Jr.setPosition(this.position);
                if (boP() != null) {
                    bz boP = boP();
                    Jr.an("obj_name", boP.bsX() != null && (boP.bsX().dPg() != null || boP.bsX().bLf() != null) ? 1 : 0);
                    if (boP.brr() != null) {
                        Jr.an(TiebaInitialize.Params.AB_TYPE, boP.brr().hadConcerned() ? 1 : 0);
                    }
                    Jr.an("is_full", boP.btk() ? 1 : 0);
                }
            }
            return Jr;
        } else if (cvB()) {
            aq Jr2 = Jr(izC);
            if (Jr2 != null) {
                Jr2.setPosition(this.position);
                if (boP() != null && (bsg = boP().bsg()) != null) {
                    TiebaStatic.deleteParamByKey(Jr2, "obj_type");
                    Jr2.dX("obj_type", bsg.id);
                    Jr2.dX("obj_name", bsg.name);
                    return Jr2;
                }
                return Jr2;
            }
            return Jr2;
        } else if (bpW()) {
            return null;
        } else {
            aq Jr3 = Jr(izr);
            if (Jr3 != null) {
                Jr3.setPosition(this.position);
                Jr3.dX(TiebaInitialize.Params.AB_ACTION, "show");
                if (boP() != null) {
                    bz boP2 = boP();
                    boolean z = (boP2.bsX() == null || (boP2.bsX().dPg() == null && boP2.bsX().bLf() == null)) ? false : true;
                    Jr3.an("obj_name", z ? 1 : 0);
                    if (z && boP2.bsX().dPg() != null && boP2.bsX().dPg().bKX() != null && boP2.bsX().dPg().bKX().size() > 0) {
                        Jr3.an(TiebaInitialize.Params.OBJ_TO, boP2.bsX().nsa ? 2 : 1);
                    }
                    if (boP2.brr() != null) {
                        Jr3.an(TiebaInitialize.Params.AB_TYPE, boP2.brr().hadConcerned() ? 1 : 0);
                    }
                    Jr3.an("is_full", boP2.btk() ? 1 : 0);
                    if (boP2.getBaijiahaoData() != null) {
                        Jr3.dX("obj_param4", boP2.getBaijiahaoData().oriUgcNid);
                    }
                    Jr3.an("obj_param5", ah(boP2));
                    if (boP2.btx()) {
                        Jr3.an("obj_param6", 2);
                    } else {
                        Jr3.an("obj_param6", 1);
                    }
                    if (boP2.btD()) {
                        Jr3.an("gua_type", 1);
                    } else if (boP2.bty() != null) {
                        Jr3.an("gua_type", 2);
                    } else {
                        Jr3.an("gua_type", 0);
                    }
                }
            }
            return Jr3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public aq Js(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.eMv != null) {
            if (this.eMv.getBaijiahaoData() == null) {
                aqVar.w("fid", this.eMv.getFid());
                aqVar.dX("tid", this.eMv.getTid());
            } else {
                aqVar.dX("tid", this.eMv.getBaijiahaoData().oriUgcNid);
            }
            if (this.eMv.bpW()) {
                i = 2;
            } else if (this.eMv.isLinkThread()) {
                i = 4;
            } else if (this.eMv.isShareThread) {
                i = 5;
            } else if (this.eMv.bpY()) {
                i = 6;
            } else if (this.eMv.btp()) {
                i = 7;
            } else if (this.eMv.bpZ()) {
                i = 8;
            } else {
                i = this.eMv.btq() ? 9 : 1;
            }
            aqVar.an("obj_type", i);
            aqVar.dX("obj_id", this.eMv.brr().getUserId());
            aqVar.an("obj_param1", cvs() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Ju(String str) {
        aq Jr = Jr(str);
        if (Jr != null) {
            Jr.dX("ab_tag", cvo()).dX(TiebaInitialize.Params.AB_ACTION, "show");
            if (boP() != null) {
                bz boP = boP();
                boolean z = (boP.bsX() == null || (boP.bsX().dPg() == null && boP.bsX().bLf() == null)) ? false : true;
                Jr.an("obj_name", z ? 1 : 0);
                if (z && boP.bsX().dPg() != null && boP.bsX().dPg().bKX() != null && boP.bsX().dPg().bKX().size() > 0) {
                    Jr.an(TiebaInitialize.Params.OBJ_TO, boP.bsX().nsa ? 2 : 1);
                }
            }
        }
        return Jr;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvu() {
        aq Jr;
        SmartApp bsg;
        if (cvA()) {
            Jr = Jr(izx);
        } else if (cvB()) {
            aq Jr2 = Jr(izD);
            if (Jr2 != null && boP() != null && (bsg = boP().bsg()) != null) {
                TiebaStatic.deleteParamByKey(Jr2, "obj_type");
                Jr2.dX("obj_type", bsg.id);
                Jr2.dX("obj_name", bsg.name);
                return Jr2;
            }
            return Jr2;
        } else {
            Jr = Jr(izs);
            if (Jr != null) {
                Jr.dX(TiebaInitialize.Params.AB_ACTION, "click");
                if (boP() != null) {
                    bz boP = boP();
                    if (boP.getBaijiahaoData() != null) {
                        Jr.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                    }
                    Jr.an("obj_param5", ah(boP));
                }
            }
        }
        if (Jr != null && boP() != null) {
            Jr.an("is_full", boP().btk() ? 1 : 0);
        }
        return Jr;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvt() {
        if (cvA()) {
            return Jr(izy);
        }
        if (l.ad(this.eMv)) {
            aq aA = aA(izG, true);
            if (aA != null && boP() != null) {
                bz boP = boP();
                if (boP.getBaijiahaoData() != null) {
                    aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                    aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(boP));
                return aA;
            }
            return aA;
        }
        aq aV = aV(izt, 0);
        if (aV != null) {
            aV.dX("ab_tag", cvo()).dX(TiebaInitialize.Params.AB_ACTION, "click");
            if (boP() != null) {
                bz boP2 = boP();
                if (boP2.getBaijiahaoData() != null) {
                    aV.dX("obj_param4", boP2.getBaijiahaoData().oriUgcNid);
                }
                aV.an("obj_param5", ah(boP2));
                aV.dX(IntentConfig.NID, boP2.bpP());
                return aV;
            }
            return aV;
        }
        return aV;
    }

    public aq cvC() {
        if (l.ad(this.eMv)) {
            aq aA = aA(izF, true);
            if (aA != null && boP() != null) {
                bz boP = boP();
                if (boP.getBaijiahaoData() != null) {
                    aA.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                    aA.dX("obj_param6", boP.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(boP));
                if (boP.btx()) {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aA;
                }
                aA.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aA;
            }
            return aA;
        } else if (cvA()) {
            return Jr(izz);
        } else {
            aq Jr = Jr(izu);
            if (Jr != null) {
                Jr.dX("ab_tag", cvo()).dX(TiebaInitialize.Params.AB_ACTION, "click");
                if (boP() != null) {
                    bz boP2 = boP();
                    if (boP2.getBaijiahaoData() != null) {
                        Jr.dX("obj_param4", boP2.getBaijiahaoData().oriUgcNid);
                    }
                    Jr.an("obj_param5", ah(boP2));
                    Jr.dX(IntentConfig.NID, boP2.bpP());
                    if (boP2.btx()) {
                        Jr.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Jr;
                    }
                    Jr.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Jr;
                }
                return Jr;
            }
            return Jr;
        }
    }

    public aq cvD() {
        if (cvA()) {
            return Jr(izA);
        }
        aq Jr = Jr(izv);
        if (Jr != null) {
            Jr.dX(TiebaInitialize.Params.AB_ACTION, "click");
            if (boP() != null) {
                bz boP = boP();
                if (boP.getBaijiahaoData() != null) {
                    Jr.dX("obj_param4", boP.getBaijiahaoData().oriUgcNid);
                }
                Jr.an("obj_param5", ah(boP));
                return Jr;
            }
            return Jr;
        }
        return Jr;
    }

    public aq cvE() {
        return Jr(izB);
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
        }
        return aA;
    }

    public aq Jv(String str) {
        aq Jr = Jr(str);
        if (this.eMv != null && this.eMv.brr() != null) {
            Jr.an(TiebaInitialize.Params.AB_TYPE, this.eMv.brr().hadConcerned() ? 1 : 0);
        }
        return Jr;
    }

    public aq Jw(String str) {
        return Jr(str);
    }

    public int ag(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpY()) {
            return 1;
        }
        if (bzVar.bpW()) {
            return 2;
        }
        if (bzVar.btp()) {
            return 3;
        }
        return bzVar.btq() ? 4 : 0;
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
}
