package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class k extends b {
    public static String iCr = "";
    public static String iCs = "";
    public static String iCt = "";
    public static String iCu = "";
    public static String iCv = "";
    public static String iCw = "";
    public static String iCx = "";
    public static String iCy = "";
    public static String iCz = "";
    public static String iCA = "";
    public static String iCB = "";
    public static String iCC = "";
    public static String iCD = "";
    public static String iCE = "";
    public static String iCF = "";
    public static String iCG = "";
    public static String iCH = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iCI = BdUniqueId.gen();
    public static final BdUniqueId eSj = BdUniqueId.gen();
    public static final BdUniqueId eSq = BdUniqueId.gen();
    public static final BdUniqueId eSr = BdUniqueId.gen();
    public static final BdUniqueId eSs = BdUniqueId.gen();
    public static final BdUniqueId eSt = BdUniqueId.gen();
    public static final BdUniqueId eSx = BdUniqueId.gen();
    public static final BdUniqueId eSy = BdUniqueId.gen();
    public static final BdUniqueId iCJ = BdUniqueId.gen();
    public static final BdUniqueId iCK = BdUniqueId.gen();
    public static final BdUniqueId eRS = BdUniqueId.gen();
    public static final BdUniqueId iCL = BdUniqueId.gen();
    public static final BdUniqueId iCM = BdUniqueId.gen();
    public static final BdUniqueId iCN = BdUniqueId.gen();
    public static final BdUniqueId iCO = BdUniqueId.gen();
    public static final BdUniqueId iCP = BdUniqueId.gen();
    public static final BdUniqueId iCQ = BdUniqueId.gen();
    public static final BdUniqueId iCR = BdUniqueId.gen();
    public static final BdUniqueId eSe = BdUniqueId.gen();
    public static final BdUniqueId eSg = BdUniqueId.gen();
    public static final BdUniqueId eSh = BdUniqueId.gen();
    public boolean iCS = false;
    public boolean isLinkThread = false;
    public boolean eRD = false;
    public boolean iCT = false;
    public boolean iCU = false;
    public boolean fEo = true;

    public static boolean ae(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        return cbVar.getType() == cb.eRN || cbVar.getType() == cb.eSk || cbVar.getType() == cb.eSj || cbVar.getType() == cb.eSq || cbVar.getType() == cb.eSv;
    }

    public static boolean ag(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        return cbVar.getType() == cb.eSx || cbVar.getType() == cb.eSy;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.eLr == null) {
            return TYPE;
        }
        if (this.iCj && b.iBZ.length > 1) {
            BdUniqueId type = this.eLr.getType();
            if (type == cb.eRN || type == cb.eSj || type == cb.eSv || type == cb.eSk) {
                if (this.eRJ) {
                    indexOf = b.iBX.indexOf(b.iBO);
                } else {
                    indexOf = b.iBX.indexOf(b.iBN);
                }
                if (this.eRx) {
                    indexOf2 = b.iBY.indexOf(b.iBP);
                } else if (this.eRw) {
                    indexOf2 = b.iBY.indexOf(b.iBR);
                } else if (this.iCg) {
                    indexOf2 = b.iBY.indexOf(b.iBQ);
                } else {
                    indexOf2 = b.iBY.indexOf(b.iBS);
                }
                if (indexOf >= 0 && indexOf < b.iBZ.length && indexOf2 >= 0 && indexOf2 < b.iBZ[0].length) {
                    return b.iBZ[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.eLr.threadType == 63) {
            return eSx;
        } else {
            if (this.eLr.threadType == 64) {
                return eSy;
            }
            if (this.eLr.isShareThread && this.eLr.eUD != null) {
                if (this.eLr.eUD.eQa) {
                    OriginalThreadInfo originalThreadInfo = this.eLr.eUD;
                    if (originalThreadInfo.videoInfo != null) {
                        return eSt;
                    }
                    if (originalThreadInfo.bmz()) {
                        return eSs;
                    }
                    return eSr;
                }
                return eSq;
            } else if (this.eRs) {
                return iCK;
            } else {
                if (this.eRt) {
                    return iCL;
                }
                if (this.iCg) {
                    return iCM;
                }
                if (this.eRw) {
                    return iCN;
                }
                if (this.eRx) {
                    return iCO;
                }
                if (this.eRy) {
                    return iCP;
                }
                if (this.eRz) {
                    return iCR;
                }
                if (this.iCi) {
                    return iCQ;
                }
                if (this.eRJ) {
                    return eRS;
                }
                if (this.eRF) {
                    return eSe;
                }
                if (this.eRH) {
                    return eSg;
                }
                if (this.eRI) {
                    return eSh;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb blp() {
        if (this.eLr == null) {
            return null;
        }
        if (this.eLr.bnG() == 5) {
            return this.eLr;
        }
        this.eLr.nk(1);
        return this.eLr;
    }

    public boolean cth() {
        return (this.eLr == null || y.getCount(this.eLr.bof()) == 0) ? false : true;
    }

    public boolean cti() {
        return this.eLr == null || this.eLr.boW();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bmx() {
        return this.eLr != null && this.eLr.bmx();
    }

    @Override // com.baidu.tieba.card.data.b
    public ar ctd() {
        SmartApp boG;
        if (cth()) {
            ar Jb = Jb(iCw);
            if (Jb != null) {
                Jb.setPosition(this.position);
                if (blp() != null) {
                    cb blp = blp();
                    Jb.aq("obj_name", blp.bpx() != null && (blp.bpx().dNQ() != null || blp.bpx().bHL() != null) ? 1 : 0);
                    if (blp.bnS() != null) {
                        Jb.aq(TiebaInitialize.Params.AB_TYPE, blp.bnS().hadConcerned() ? 1 : 0);
                    }
                    Jb.aq("is_full", blp.bpK() ? 1 : 0);
                }
            }
            return Jb;
        } else if (cti()) {
            ar Jb2 = Jb(iCC);
            if (Jb2 != null) {
                Jb2.setPosition(this.position);
                if (blp() != null && (boG = blp().boG()) != null) {
                    TiebaStatic.deleteParamByKey(Jb2, "obj_type");
                    Jb2.dR("obj_type", boG.id);
                    Jb2.dR("obj_name", boG.name);
                    return Jb2;
                }
                return Jb2;
            }
            return Jb2;
        } else if (bmx()) {
            return null;
        } else {
            ar Jb3 = Jb(iCr);
            if (Jb3 != null) {
                Jb3.setPosition(this.position);
                Jb3.dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (blp() != null) {
                    cb blp2 = blp();
                    boolean z = (blp2.bpx() == null || (blp2.bpx().dNQ() == null && blp2.bpx().bHL() == null)) ? false : true;
                    Jb3.aq("obj_name", z ? 1 : 0);
                    if (z && blp2.bpx().dNQ() != null && blp2.bpx().dNQ().bHD() != null && blp2.bpx().dNQ().bHD().size() > 0) {
                        Jb3.aq(TiebaInitialize.Params.OBJ_TO, blp2.bpx().nzJ ? 2 : 1);
                    }
                    if (blp2.bnS() != null) {
                        Jb3.aq(TiebaInitialize.Params.AB_TYPE, blp2.bnS().hadConcerned() ? 1 : 0);
                    }
                    Jb3.aq("is_full", blp2.bpK() ? 1 : 0);
                    if (blp2.getBaijiahaoData() != null) {
                        Jb3.dR("obj_param4", blp2.getBaijiahaoData().oriUgcNid);
                    }
                    Jb3.aq("obj_param5", ai(blp2));
                    if (blp2.bpX()) {
                        Jb3.aq("obj_param6", 2);
                    } else {
                        Jb3.aq("obj_param6", 1);
                    }
                    if (blp2.bqd()) {
                        Jb3.aq("gua_type", 1);
                    } else if (blp2.bpY() != null) {
                        Jb3.aq("gua_type", 2);
                    } else {
                        Jb3.aq("gua_type", 0);
                    }
                }
            }
            return Jb3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public ar Jc(String str) {
        int i;
        ar arVar = new ar(str);
        if (this.eLr != null) {
            if (this.eLr.getBaijiahaoData() == null) {
                arVar.v("fid", this.eLr.getFid());
                arVar.dR("tid", this.eLr.getTid());
            } else {
                arVar.dR("tid", this.eLr.getBaijiahaoData().oriUgcNid);
            }
            if (this.eLr.bmx()) {
                i = 2;
            } else if (this.eLr.isLinkThread()) {
                i = 4;
            } else if (this.eLr.isShareThread) {
                i = 5;
            } else if (this.eLr.bmz()) {
                i = 6;
            } else if (this.eLr.bpP()) {
                i = 7;
            } else if (this.eLr.bmA()) {
                i = 8;
            } else {
                i = this.eLr.bpQ() ? 9 : 1;
            }
            arVar.aq("obj_type", i);
            arVar.dR("obj_id", this.eLr.bnS().getUserId());
            arVar.aq("obj_param1", csZ() ? 2 : 1);
        }
        return arVar;
    }

    public ar Je(String str) {
        ar Jb = Jb(str);
        if (Jb != null) {
            Jb.dR("ab_tag", csV()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (blp() != null) {
                cb blp = blp();
                boolean z = (blp.bpx() == null || (blp.bpx().dNQ() == null && blp.bpx().bHL() == null)) ? false : true;
                Jb.aq("obj_name", z ? 1 : 0);
                if (z && blp.bpx().dNQ() != null && blp.bpx().dNQ().bHD() != null && blp.bpx().dNQ().bHD().size() > 0) {
                    Jb.aq(TiebaInitialize.Params.OBJ_TO, blp.bpx().nzJ ? 2 : 1);
                }
            }
        }
        return Jb;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar ctb() {
        ar Jb;
        SmartApp boG;
        if (cth()) {
            Jb = Jb(iCx);
        } else if (cti()) {
            ar Jb2 = Jb(iCD);
            if (Jb2 != null && blp() != null && (boG = blp().boG()) != null) {
                TiebaStatic.deleteParamByKey(Jb2, "obj_type");
                Jb2.dR("obj_type", boG.id);
                Jb2.dR("obj_name", boG.name);
                return Jb2;
            }
            return Jb2;
        } else {
            Jb = Jb(iCs);
            if (Jb != null) {
                Jb.dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (blp() != null) {
                    cb blp = blp();
                    if (blp.getBaijiahaoData() != null) {
                        Jb.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                    }
                    Jb.aq("obj_param5", ai(blp));
                }
            }
        }
        if (Jb != null && blp() != null) {
            Jb.aq("is_full", blp().bpK() ? 1 : 0);
        }
        return Jb;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar cta() {
        if (cth()) {
            return Jb(iCy);
        }
        if (l.ae(this.eLr)) {
            ar az = az(iCG, true);
            if (az != null && blp() != null) {
                cb blp = blp();
                if (blp.getBaijiahaoData() != null) {
                    az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
                }
                az.aq("obj_param5", ai(blp));
                return az;
            }
            return az;
        }
        ar aW = aW(iCt, 0);
        if (aW != null) {
            aW.dR("ab_tag", csV()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (blp() != null) {
                cb blp2 = blp();
                if (blp2.getBaijiahaoData() != null) {
                    aW.dR("obj_param4", blp2.getBaijiahaoData().oriUgcNid);
                }
                aW.aq("obj_param5", ai(blp2));
                aW.dR(IntentConfig.NID, blp2.bmq());
                return aW;
            }
            return aW;
        }
        return aW;
    }

    public ar ctj() {
        if (l.ae(this.eLr)) {
            ar az = az(iCF, true);
            if (az != null && blp() != null) {
                cb blp = blp();
                if (blp.getBaijiahaoData() != null) {
                    az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                    az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
                }
                az.aq("obj_param5", ai(blp));
                if (blp.bpX()) {
                    az.aq(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return az;
                }
                az.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return az;
            }
            return az;
        } else if (cth()) {
            return Jb(iCz);
        } else {
            ar Jb = Jb(iCu);
            if (Jb != null) {
                Jb.dR("ab_tag", csV()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (blp() != null) {
                    cb blp2 = blp();
                    if (blp2.getBaijiahaoData() != null) {
                        Jb.dR("obj_param4", blp2.getBaijiahaoData().oriUgcNid);
                    }
                    Jb.aq("obj_param5", ai(blp2));
                    Jb.dR(IntentConfig.NID, blp2.bmq());
                    if (blp2.bpX()) {
                        Jb.aq(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Jb;
                    }
                    Jb.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Jb;
                }
                return Jb;
            }
            return Jb;
        }
    }

    public ar ctk() {
        if (cth()) {
            return Jb(iCA);
        }
        ar Jb = Jb(iCv);
        if (Jb != null) {
            Jb.dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (blp() != null) {
                cb blp = blp();
                if (blp.getBaijiahaoData() != null) {
                    Jb.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                }
                Jb.aq("obj_param5", ai(blp));
                return Jb;
            }
            return Jb;
        }
        return Jb;
    }

    public ar ctl() {
        return Jb(iCB);
    }

    @Override // com.baidu.tieba.card.data.b
    public ar ctc() {
        ar az = az(iCE, true);
        if (blp() != null) {
            cb blp = blp();
            if (blp.getBaijiahaoData() != null) {
                az.dR("obj_param4", blp.getBaijiahaoData().oriUgcNid);
                az.dR("obj_param6", blp.getBaijiahaoData().oriUgcVid);
            }
            az.aq("obj_param5", ai(blp));
        }
        return az;
    }

    public ar Jf(String str) {
        ar Jb = Jb(str);
        if (this.eLr != null && this.eLr.bnS() != null) {
            Jb.aq(TiebaInitialize.Params.AB_TYPE, this.eLr.bnS().hadConcerned() ? 1 : 0);
        }
        return Jb;
    }

    public ar Jg(String str) {
        return Jb(str);
    }

    public int ah(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmz()) {
            return 1;
        }
        if (cbVar.bmx()) {
            return 2;
        }
        if (cbVar.bpP()) {
            return 3;
        }
        return cbVar.bpQ() ? 4 : 0;
    }

    public int ai(cb cbVar) {
        if (cbVar == null) {
            return 1;
        }
        if (cbVar.bpQ() || cbVar.bpP()) {
            return 2;
        }
        return (cbVar.bmz() || cbVar.bmA()) ? 3 : 1;
    }
}
