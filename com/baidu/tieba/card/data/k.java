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
    public static String iuK = "";
    public static String iuL = "";
    public static String iuM = "";
    public static String iuN = "";
    public static String iuO = "";
    public static String iuP = "";
    public static String iuQ = "";
    public static String iuR = "";
    public static String iuS = "";
    public static String iuT = "";
    public static String iuU = "";
    public static String iuV = "";
    public static String iuW = "";
    public static String iuX = "";
    public static String iuY = "";
    public static String iuZ = "";
    public static String iva = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ivb = BdUniqueId.gen();
    public static final BdUniqueId eOw = BdUniqueId.gen();
    public static final BdUniqueId eOD = BdUniqueId.gen();
    public static final BdUniqueId eOE = BdUniqueId.gen();
    public static final BdUniqueId eOF = BdUniqueId.gen();
    public static final BdUniqueId eOG = BdUniqueId.gen();
    public static final BdUniqueId eOK = BdUniqueId.gen();
    public static final BdUniqueId eOL = BdUniqueId.gen();
    public static final BdUniqueId ivc = BdUniqueId.gen();
    public static final BdUniqueId ivd = BdUniqueId.gen();
    public static final BdUniqueId eOf = BdUniqueId.gen();
    public static final BdUniqueId ive = BdUniqueId.gen();
    public static final BdUniqueId ivf = BdUniqueId.gen();
    public static final BdUniqueId ivg = BdUniqueId.gen();
    public static final BdUniqueId ivh = BdUniqueId.gen();
    public static final BdUniqueId ivi = BdUniqueId.gen();
    public static final BdUniqueId ivj = BdUniqueId.gen();
    public static final BdUniqueId ivk = BdUniqueId.gen();
    public static final BdUniqueId eOr = BdUniqueId.gen();
    public static final BdUniqueId eOt = BdUniqueId.gen();
    public static final BdUniqueId eOu = BdUniqueId.gen();
    public boolean ivl = false;
    public boolean isLinkThread = false;
    public boolean eNQ = false;
    public boolean ivm = false;
    public boolean ivn = false;
    public boolean fAA = true;

    public static boolean ad(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        return bzVar.getType() == bz.eOa || bzVar.getType() == bz.eOx || bzVar.getType() == bz.eOw || bzVar.getType() == bz.eOD || bzVar.getType() == bz.eOI;
    }

    public static boolean af(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        return bzVar.getType() == bz.eOK || bzVar.getType() == bz.eOL;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.eHK == null) {
            return TYPE;
        }
        if (this.iuC && b.ius.length > 1) {
            BdUniqueId type = this.eHK.getType();
            if (type == bz.eOa || type == bz.eOw || type == bz.eOI || type == bz.eOx) {
                if (this.eNW) {
                    indexOf = b.iuq.indexOf(b.iuh);
                } else {
                    indexOf = b.iuq.indexOf(b.iug);
                }
                if (this.eNK) {
                    indexOf2 = b.iur.indexOf(b.iui);
                } else if (this.eNJ) {
                    indexOf2 = b.iur.indexOf(b.iuk);
                } else if (this.iuz) {
                    indexOf2 = b.iur.indexOf(b.iuj);
                } else {
                    indexOf2 = b.iur.indexOf(b.iul);
                }
                if (indexOf >= 0 && indexOf < b.ius.length && indexOf2 >= 0 && indexOf2 < b.ius[0].length) {
                    return b.ius[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.eHK.threadType == 63) {
            return eOK;
        } else {
            if (this.eHK.threadType == 64) {
                return eOL;
            }
            if (this.eHK.isShareThread && this.eHK.eQQ != null) {
                if (this.eHK.eQQ.eMn) {
                    OriginalThreadInfo originalThreadInfo = this.eHK.eQQ;
                    if (originalThreadInfo.videoInfo != null) {
                        return eOG;
                    }
                    if (originalThreadInfo.bme()) {
                        return eOF;
                    }
                    return eOE;
                }
                return eOD;
            } else if (this.eNF) {
                return ivd;
            } else {
                if (this.eNG) {
                    return ive;
                }
                if (this.iuz) {
                    return ivf;
                }
                if (this.eNJ) {
                    return ivg;
                }
                if (this.eNK) {
                    return ivh;
                }
                if (this.eNL) {
                    return ivi;
                }
                if (this.eNM) {
                    return ivk;
                }
                if (this.iuB) {
                    return ivj;
                }
                if (this.eNW) {
                    return eOf;
                }
                if (this.eNS) {
                    return eOr;
                }
                if (this.eNU) {
                    return eOt;
                }
                if (this.eNV) {
                    return eOu;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz bkV() {
        if (this.eHK == null) {
            return null;
        }
        if (this.eHK.bnl() == 5) {
            return this.eHK;
        }
        this.eHK.ng(1);
        return this.eHK;
    }

    public boolean crI() {
        return (this.eHK == null || x.getCount(this.eHK.bnK()) == 0) ? false : true;
    }

    public boolean crJ() {
        return this.eHK == null || this.eHK.boC();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmc() {
        return this.eHK != null && this.eHK.bmc();
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crE() {
        SmartApp bom;
        if (crI()) {
            aq Ig = Ig(iuP);
            if (Ig != null) {
                Ig.setPosition(this.position);
                if (bkV() != null) {
                    bz bkV = bkV();
                    Ig.an("obj_name", bkV.bpd() != null && (bkV.bpd().dLo() != null || bkV.bpd().bHn() != null) ? 1 : 0);
                    if (bkV.bnx() != null) {
                        Ig.an(TiebaInitialize.Params.AB_TYPE, bkV.bnx().hadConcerned() ? 1 : 0);
                    }
                    Ig.an("is_full", bkV.bpq() ? 1 : 0);
                }
            }
            return Ig;
        } else if (crJ()) {
            aq Ig2 = Ig(iuV);
            if (Ig2 != null) {
                Ig2.setPosition(this.position);
                if (bkV() != null && (bom = bkV().bom()) != null) {
                    TiebaStatic.deleteParamByKey(Ig2, "obj_type");
                    Ig2.dW("obj_type", bom.id);
                    Ig2.dW("obj_name", bom.name);
                    return Ig2;
                }
                return Ig2;
            }
            return Ig2;
        } else if (bmc()) {
            return null;
        } else {
            aq Ig3 = Ig(iuK);
            if (Ig3 != null) {
                Ig3.setPosition(this.position);
                Ig3.dW(TiebaInitialize.Params.AB_ACTION, "show");
                if (bkV() != null) {
                    bz bkV2 = bkV();
                    boolean z = (bkV2.bpd() == null || (bkV2.bpd().dLo() == null && bkV2.bpd().bHn() == null)) ? false : true;
                    Ig3.an("obj_name", z ? 1 : 0);
                    if (z && bkV2.bpd().dLo() != null && bkV2.bpd().dLo().bHf() != null && bkV2.bpd().dLo().bHf().size() > 0) {
                        Ig3.an(TiebaInitialize.Params.OBJ_TO, bkV2.bpd().nnu ? 2 : 1);
                    }
                    if (bkV2.bnx() != null) {
                        Ig3.an(TiebaInitialize.Params.AB_TYPE, bkV2.bnx().hadConcerned() ? 1 : 0);
                    }
                    Ig3.an("is_full", bkV2.bpq() ? 1 : 0);
                    if (bkV2.getBaijiahaoData() != null) {
                        Ig3.dW("obj_param4", bkV2.getBaijiahaoData().oriUgcNid);
                    }
                    Ig3.an("obj_param5", ah(bkV2));
                    if (bkV2.bpD()) {
                        Ig3.an("obj_param6", 2);
                    } else {
                        Ig3.an("obj_param6", 1);
                    }
                    if (bkV2.bpJ()) {
                        Ig3.an("gua_type", 1);
                    } else if (bkV2.bpE() != null) {
                        Ig3.an("gua_type", 2);
                    } else {
                        Ig3.an("gua_type", 0);
                    }
                }
            }
            return Ig3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public aq Ih(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.eHK != null) {
            if (this.eHK.getBaijiahaoData() == null) {
                aqVar.w("fid", this.eHK.getFid());
                aqVar.dW("tid", this.eHK.getTid());
            } else {
                aqVar.dW("tid", this.eHK.getBaijiahaoData().oriUgcNid);
            }
            if (this.eHK.bmc()) {
                i = 2;
            } else if (this.eHK.isLinkThread()) {
                i = 4;
            } else if (this.eHK.isShareThread) {
                i = 5;
            } else if (this.eHK.bme()) {
                i = 6;
            } else if (this.eHK.bpv()) {
                i = 7;
            } else if (this.eHK.bmf()) {
                i = 8;
            } else {
                i = this.eHK.bpw() ? 9 : 1;
            }
            aqVar.an("obj_type", i);
            aqVar.dW("obj_id", this.eHK.bnx().getUserId());
            aqVar.an("obj_param1", crA() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Ij(String str) {
        aq Ig = Ig(str);
        if (Ig != null) {
            Ig.dW("ab_tag", crw()).dW(TiebaInitialize.Params.AB_ACTION, "show");
            if (bkV() != null) {
                bz bkV = bkV();
                boolean z = (bkV.bpd() == null || (bkV.bpd().dLo() == null && bkV.bpd().bHn() == null)) ? false : true;
                Ig.an("obj_name", z ? 1 : 0);
                if (z && bkV.bpd().dLo() != null && bkV.bpd().dLo().bHf() != null && bkV.bpd().dLo().bHf().size() > 0) {
                    Ig.an(TiebaInitialize.Params.OBJ_TO, bkV.bpd().nnu ? 2 : 1);
                }
            }
        }
        return Ig;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crC() {
        aq Ig;
        SmartApp bom;
        if (crI()) {
            Ig = Ig(iuQ);
        } else if (crJ()) {
            aq Ig2 = Ig(iuW);
            if (Ig2 != null && bkV() != null && (bom = bkV().bom()) != null) {
                TiebaStatic.deleteParamByKey(Ig2, "obj_type");
                Ig2.dW("obj_type", bom.id);
                Ig2.dW("obj_name", bom.name);
                return Ig2;
            }
            return Ig2;
        } else {
            Ig = Ig(iuL);
            if (Ig != null) {
                Ig.dW(TiebaInitialize.Params.AB_ACTION, "click");
                if (bkV() != null) {
                    bz bkV = bkV();
                    if (bkV.getBaijiahaoData() != null) {
                        Ig.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                    }
                    Ig.an("obj_param5", ah(bkV));
                }
            }
        }
        if (Ig != null && bkV() != null) {
            Ig.an("is_full", bkV().bpq() ? 1 : 0);
        }
        return Ig;
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crB() {
        if (crI()) {
            return Ig(iuR);
        }
        if (l.ad(this.eHK)) {
            aq aA = aA(iuZ, true);
            if (aA != null && bkV() != null) {
                bz bkV = bkV();
                if (bkV.getBaijiahaoData() != null) {
                    aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                    aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(bkV));
                return aA;
            }
            return aA;
        }
        aq aV = aV(iuM, 0);
        if (aV != null) {
            aV.dW("ab_tag", crw()).dW(TiebaInitialize.Params.AB_ACTION, "click");
            if (bkV() != null) {
                bz bkV2 = bkV();
                if (bkV2.getBaijiahaoData() != null) {
                    aV.dW("obj_param4", bkV2.getBaijiahaoData().oriUgcNid);
                }
                aV.an("obj_param5", ah(bkV2));
                aV.dW(IntentConfig.NID, bkV2.blV());
                return aV;
            }
            return aV;
        }
        return aV;
    }

    public aq crK() {
        if (l.ad(this.eHK)) {
            aq aA = aA(iuY, true);
            if (aA != null && bkV() != null) {
                bz bkV = bkV();
                if (bkV.getBaijiahaoData() != null) {
                    aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                    aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
                }
                aA.an("obj_param5", ah(bkV));
                if (bkV.bpD()) {
                    aA.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aA;
                }
                aA.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aA;
            }
            return aA;
        } else if (crI()) {
            return Ig(iuS);
        } else {
            aq Ig = Ig(iuN);
            if (Ig != null) {
                Ig.dW("ab_tag", crw()).dW(TiebaInitialize.Params.AB_ACTION, "click");
                if (bkV() != null) {
                    bz bkV2 = bkV();
                    if (bkV2.getBaijiahaoData() != null) {
                        Ig.dW("obj_param4", bkV2.getBaijiahaoData().oriUgcNid);
                    }
                    Ig.an("obj_param5", ah(bkV2));
                    Ig.dW(IntentConfig.NID, bkV2.blV());
                    if (bkV2.bpD()) {
                        Ig.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Ig;
                    }
                    Ig.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Ig;
                }
                return Ig;
            }
            return Ig;
        }
    }

    public aq crL() {
        if (crI()) {
            return Ig(iuT);
        }
        aq Ig = Ig(iuO);
        if (Ig != null) {
            Ig.dW(TiebaInitialize.Params.AB_ACTION, "click");
            if (bkV() != null) {
                bz bkV = bkV();
                if (bkV.getBaijiahaoData() != null) {
                    Ig.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                }
                Ig.an("obj_param5", ah(bkV));
                return Ig;
            }
            return Ig;
        }
        return Ig;
    }

    public aq crM() {
        return Ig(iuU);
    }

    @Override // com.baidu.tieba.card.data.b
    public aq crD() {
        aq aA = aA(iuX, true);
        if (bkV() != null) {
            bz bkV = bkV();
            if (bkV.getBaijiahaoData() != null) {
                aA.dW("obj_param4", bkV.getBaijiahaoData().oriUgcNid);
                aA.dW("obj_param6", bkV.getBaijiahaoData().oriUgcVid);
            }
            aA.an("obj_param5", ah(bkV));
        }
        return aA;
    }

    public aq Ik(String str) {
        aq Ig = Ig(str);
        if (this.eHK != null && this.eHK.bnx() != null) {
            Ig.an(TiebaInitialize.Params.AB_TYPE, this.eHK.bnx().hadConcerned() ? 1 : 0);
        }
        return Ig;
    }

    public aq Il(String str) {
        return Ig(str);
    }

    public int ag(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bme()) {
            return 1;
        }
        if (bzVar.bmc()) {
            return 2;
        }
        if (bzVar.bpv()) {
            return 3;
        }
        return bzVar.bpw() ? 4 : 0;
    }

    public int ah(bz bzVar) {
        if (bzVar == null) {
            return 1;
        }
        if (bzVar.bpw() || bzVar.bpv()) {
            return 2;
        }
        return (bzVar.bme() || bzVar.bmf()) ? 3 : 1;
    }
}
