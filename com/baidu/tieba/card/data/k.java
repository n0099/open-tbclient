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
                    if (originalThreadInfo.bpX()) {
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
    public bz boO() {
        if (this.eMv == null) {
            return null;
        }
        if (this.eMv.bre() == 5) {
            return this.eMv;
        }
        this.eMv.oM(1);
        return this.eMv;
    }

    public boolean cvz() {
        return (this.eMv == null || x.getCount(this.eMv.brD()) == 0) ? false : true;
    }

    public boolean cvA() {
        return this.eMv == null || this.eMv.bsv();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bpV() {
        return this.eMv != null && this.eMv.bpV();
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvv() {
        SmartApp bsf;
        if (cvz()) {
            aq Js = Js(izw);
            if (Js != null) {
                Js.setPosition(this.position);
                if (boO() != null) {
                    bz boO = boO();
                    Js.an("obj_name", boO.bsW() != null && (boO.bsW().dPf() != null || boO.bsW().bLe() != null) ? 1 : 0);
                    if (boO.brq() != null) {
                        Js.an(TiebaInitialize.Params.AB_TYPE, boO.brq().hadConcerned() ? 1 : 0);
                    }
                    Js.an("is_full", boO.btj() ? 1 : 0);
                }
            }
            return Js;
        } else if (cvA()) {
            aq Js2 = Js(izC);
            if (Js2 != null) {
                Js2.setPosition(this.position);
                if (boO() != null && (bsf = boO().bsf()) != null) {
                    TiebaStatic.deleteParamByKey(Js2, "obj_type");
                    Js2.dX("obj_type", bsf.id);
                    Js2.dX("obj_name", bsf.name);
                    return Js2;
                }
                return Js2;
            }
            return Js2;
        } else if (bpV()) {
            return null;
        } else {
            aq Js3 = Js(izr);
            if (Js3 != null) {
                Js3.setPosition(this.position);
                Js3.dX(TiebaInitialize.Params.AB_ACTION, "show");
                if (boO() != null) {
                    bz boO2 = boO();
                    boolean z = (boO2.bsW() == null || (boO2.bsW().dPf() == null && boO2.bsW().bLe() == null)) ? false : true;
                    Js3.an("obj_name", z ? 1 : 0);
                    if (z && boO2.bsW().dPf() != null && boO2.bsW().dPf().bKW() != null && boO2.bsW().dPf().bKW().size() > 0) {
                        Js3.an(TiebaInitialize.Params.OBJ_TO, boO2.bsW().nsb ? 2 : 1);
                    }
                    if (boO2.brq() != null) {
                        Js3.an(TiebaInitialize.Params.AB_TYPE, boO2.brq().hadConcerned() ? 1 : 0);
                    }
                    Js3.an("is_full", boO2.btj() ? 1 : 0);
                    if (boO2.getBaijiahaoData() != null) {
                        Js3.dX("obj_param4", boO2.getBaijiahaoData().oriUgcNid);
                    }
                    Js3.an("obj_param5", ah(boO2));
                    if (boO2.btw()) {
                        Js3.an("obj_param6", 2);
                    } else {
                        Js3.an("obj_param6", 1);
                    }
                    if (boO2.btC()) {
                        Js3.an("gua_type", 1);
                    } else if (boO2.btx() != null) {
                        Js3.an("gua_type", 2);
                    } else {
                        Js3.an("gua_type", 0);
                    }
                }
            }
            return Js3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public aq Jt(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.eMv != null) {
            if (this.eMv.getBaijiahaoData() == null) {
                aqVar.w("fid", this.eMv.getFid());
                aqVar.dX("tid", this.eMv.getTid());
            } else {
                aqVar.dX("tid", this.eMv.getBaijiahaoData().oriUgcNid);
            }
            if (this.eMv.bpV()) {
                i = 2;
            } else if (this.eMv.isLinkThread()) {
                i = 4;
            } else if (this.eMv.isShareThread) {
                i = 5;
            } else if (this.eMv.bpX()) {
                i = 6;
            } else if (this.eMv.bto()) {
                i = 7;
            } else if (this.eMv.bpY()) {
                i = 8;
            } else {
                i = this.eMv.btp() ? 9 : 1;
            }
            aqVar.an("obj_type", i);
            aqVar.dX("obj_id", this.eMv.brq().getUserId());
            aqVar.an("obj_param1", cvr() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Jv(String str) {
        aq Js = Js(str);
        if (Js != null) {
            Js.dX("ab_tag", cvn()).dX(TiebaInitialize.Params.AB_ACTION, "show");
            if (boO() != null) {
                bz boO = boO();
                boolean z = (boO.bsW() == null || (boO.bsW().dPf() == null && boO.bsW().bLe() == null)) ? false : true;
                Js.an("obj_name", z ? 1 : 0);
                if (z && boO.bsW().dPf() != null && boO.bsW().dPf().bKW() != null && boO.bsW().dPf().bKW().size() > 0) {
                    Js.an(TiebaInitialize.Params.OBJ_TO, boO.bsW().nsb ? 2 : 1);
                }
            }
        }
        return Js;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvt() {
        aq Js;
        SmartApp bsf;
        if (cvz()) {
            Js = Js(izx);
        } else if (cvA()) {
            aq Js2 = Js(izD);
            if (Js2 != null && boO() != null && (bsf = boO().bsf()) != null) {
                TiebaStatic.deleteParamByKey(Js2, "obj_type");
                Js2.dX("obj_type", bsf.id);
                Js2.dX("obj_name", bsf.name);
                return Js2;
            }
            return Js2;
        } else {
            Js = Js(izs);
            if (Js != null) {
                Js.dX(TiebaInitialize.Params.AB_ACTION, "click");
                if (boO() != null) {
                    bz boO = boO();
                    if (boO.getBaijiahaoData() != null) {
                        Js.dX("obj_param4", boO.getBaijiahaoData().oriUgcNid);
                    }
                    Js.an("obj_param5", ah(boO));
                }
            }
        }
        if (Js != null && boO() != null) {
            Js.an("is_full", boO().btj() ? 1 : 0);
        }
        return Js;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvs() {
        if (cvz()) {
            return Js(izy);
        }
        if (l.ad(this.eMv)) {
            aq aA = aA(izG, true);
            if (aA != null && boO() != null) {
                bz boO = boO();
                if (boO.getBaijiahaoData() != null) {
                    aA.dX("obj_param4", boO.getBaijiahaoData().oriUgcNid);
                    aA.dX("obj_param6", boO.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(boO));
                return aA;
            }
            return aA;
        }
        aq aV = aV(izt, 0);
        if (aV != null) {
            aV.dX("ab_tag", cvn()).dX(TiebaInitialize.Params.AB_ACTION, "click");
            if (boO() != null) {
                bz boO2 = boO();
                if (boO2.getBaijiahaoData() != null) {
                    aV.dX("obj_param4", boO2.getBaijiahaoData().oriUgcNid);
                }
                aV.an("obj_param5", ah(boO2));
                aV.dX(IntentConfig.NID, boO2.bpO());
                return aV;
            }
            return aV;
        }
        return aV;
    }

    public aq cvB() {
        if (l.ad(this.eMv)) {
            aq aA = aA(izF, true);
            if (aA != null && boO() != null) {
                bz boO = boO();
                if (boO.getBaijiahaoData() != null) {
                    aA.dX("obj_param4", boO.getBaijiahaoData().oriUgcNid);
                    aA.dX("obj_param6", boO.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(boO));
                if (boO.btw()) {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aA;
                }
                aA.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aA;
            }
            return aA;
        } else if (cvz()) {
            return Js(izz);
        } else {
            aq Js = Js(izu);
            if (Js != null) {
                Js.dX("ab_tag", cvn()).dX(TiebaInitialize.Params.AB_ACTION, "click");
                if (boO() != null) {
                    bz boO2 = boO();
                    if (boO2.getBaijiahaoData() != null) {
                        Js.dX("obj_param4", boO2.getBaijiahaoData().oriUgcNid);
                    }
                    Js.an("obj_param5", ah(boO2));
                    Js.dX(IntentConfig.NID, boO2.bpO());
                    if (boO2.btw()) {
                        Js.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Js;
                    }
                    Js.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Js;
                }
                return Js;
            }
            return Js;
        }
    }

    public aq cvC() {
        if (cvz()) {
            return Js(izA);
        }
        aq Js = Js(izv);
        if (Js != null) {
            Js.dX(TiebaInitialize.Params.AB_ACTION, "click");
            if (boO() != null) {
                bz boO = boO();
                if (boO.getBaijiahaoData() != null) {
                    Js.dX("obj_param4", boO.getBaijiahaoData().oriUgcNid);
                }
                Js.an("obj_param5", ah(boO));
                return Js;
            }
            return Js;
        }
        return Js;
    }

    public aq cvD() {
        return Js(izB);
    }

    @Override // com.baidu.tieba.card.data.b
    public aq cvu() {
        aq aA = aA(izE, true);
        if (boO() != null) {
            bz boO = boO();
            if (boO.getBaijiahaoData() != null) {
                aA.dX("obj_param4", boO.getBaijiahaoData().oriUgcNid);
                aA.dX("obj_param6", boO.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(boO));
        }
        return aA;
    }

    public aq Jw(String str) {
        aq Js = Js(str);
        if (this.eMv != null && this.eMv.brq() != null) {
            Js.an(TiebaInitialize.Params.AB_TYPE, this.eMv.brq().hadConcerned() ? 1 : 0);
        }
        return Js;
    }

    public aq Jx(String str) {
        return Js(str);
    }

    public int ag(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpX()) {
            return 1;
        }
        if (bzVar.bpV()) {
            return 2;
        }
        if (bzVar.bto()) {
            return 3;
        }
        return bzVar.btp() ? 4 : 0;
    }

    public int ah(bz bzVar) {
        if (bzVar == null) {
            return 1;
        }
        if (bzVar.btp() || bzVar.bto()) {
            return 2;
        }
        return (bzVar.bpX() || bzVar.bpY()) ? 3 : 1;
    }
}
