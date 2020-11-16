package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes20.dex */
public class k extends b {
    public static String ibX = "";
    public static String ibY = "";
    public static String ibZ = "";
    public static String ica = "";
    public static String icb = "";
    public static String icc = "";
    public static String icd = "";
    public static String ice = "";
    public static String icf = "";
    public static String icg = "";
    public static String ich = "";
    public static String ici = "";
    public static String icj = "";
    public static String ick = "";
    public static String icl = "";
    public static String icm = "";
    public static String icn = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ico = BdUniqueId.gen();
    public static final BdUniqueId eCm = BdUniqueId.gen();
    public static final BdUniqueId eCt = BdUniqueId.gen();
    public static final BdUniqueId eCu = BdUniqueId.gen();
    public static final BdUniqueId eCv = BdUniqueId.gen();
    public static final BdUniqueId eCw = BdUniqueId.gen();
    public static final BdUniqueId eCA = BdUniqueId.gen();
    public static final BdUniqueId eCB = BdUniqueId.gen();
    public static final BdUniqueId icp = BdUniqueId.gen();
    public static final BdUniqueId icq = BdUniqueId.gen();
    public static final BdUniqueId eBW = BdUniqueId.gen();
    public static final BdUniqueId icr = BdUniqueId.gen();
    public static final BdUniqueId ics = BdUniqueId.gen();
    public static final BdUniqueId ict = BdUniqueId.gen();
    public static final BdUniqueId icu = BdUniqueId.gen();
    public static final BdUniqueId icv = BdUniqueId.gen();
    public static final BdUniqueId icw = BdUniqueId.gen();
    public static final BdUniqueId icx = BdUniqueId.gen();
    public static final BdUniqueId eCi = BdUniqueId.gen();
    public static final BdUniqueId eCk = BdUniqueId.gen();
    public static final BdUniqueId eCl = BdUniqueId.gen();
    public boolean icy = false;
    public boolean isLinkThread = false;
    public boolean eBH = false;
    public boolean icz = false;
    public boolean icA = false;
    public boolean fnY = true;

    public static boolean ad(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        return bxVar.getType() == bx.eBR || bxVar.getType() == bx.eCn || bxVar.getType() == bx.eCm || bxVar.getType() == bx.eCt || bxVar.getType() == bx.eCy;
    }

    public static boolean af(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        return bxVar.getType() == bx.eCA || bxVar.getType() == bx.eCB;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.evQ == null) {
            return TYPE;
        }
        if (this.ibP && b.ibF.length > 1) {
            BdUniqueId type = this.evQ.getType();
            if (type == bx.eBR || type == bx.eCm || type == bx.eCy || type == bx.eCn) {
                if (this.eBN) {
                    indexOf = b.ibD.indexOf(b.ibv);
                } else {
                    indexOf = b.ibD.indexOf(b.ibu);
                }
                if (this.eBC) {
                    indexOf2 = b.ibE.indexOf(b.ibw);
                } else if (this.eBB) {
                    indexOf2 = b.ibE.indexOf(b.iby);
                } else if (this.ibM) {
                    indexOf2 = b.ibE.indexOf(b.ibx);
                } else {
                    indexOf2 = b.ibE.indexOf(b.ibz);
                }
                if (indexOf >= 0 && indexOf < b.ibF.length && indexOf2 >= 0 && indexOf2 < b.ibF[0].length) {
                    return b.ibF[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.evQ.threadType == 63) {
            return eCA;
        } else {
            if (this.evQ.threadType == 64) {
                return eCB;
            }
            if (this.evQ.isShareThread && this.evQ.eEF != null) {
                if (this.evQ.eEF.eAi) {
                    OriginalThreadInfo originalThreadInfo = this.evQ.eEF;
                    if (originalThreadInfo.videoInfo != null) {
                        return eCw;
                    }
                    if (originalThreadInfo.bkk()) {
                        return eCv;
                    }
                    return eCu;
                }
                return eCt;
            } else if (this.eBx) {
                return icq;
            } else {
                if (this.eBy) {
                    return icr;
                }
                if (this.ibM) {
                    return ics;
                }
                if (this.eBB) {
                    return ict;
                }
                if (this.eBC) {
                    return icu;
                }
                if (this.eBD) {
                    return icv;
                }
                if (this.eBE) {
                    return icx;
                }
                if (this.ibO) {
                    return icw;
                }
                if (this.eBN) {
                    return eBW;
                }
                if (this.eBJ) {
                    return eCi;
                }
                if (this.eBL) {
                    return eCk;
                }
                if (this.eBM) {
                    return eCl;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        if (this.evQ == null) {
            return null;
        }
        if (this.evQ.blq() == 5) {
            return this.evQ;
        }
        this.evQ.oe(1);
        return this.evQ;
    }

    public boolean cos() {
        return (this.evQ == null || y.getCount(this.evQ.blP()) == 0) ? false : true;
    }

    public boolean cot() {
        return this.evQ == null || this.evQ.bmH();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bki() {
        return this.evQ != null && this.evQ.bki();
    }

    @Override // com.baidu.tieba.card.data.b
    public ar coo() {
        SmartApp bmr;
        if (cos()) {
            ar IE = IE(icc);
            if (IE != null) {
                IE.setPosition(this.position);
                if (bjd() != null) {
                    bx bjd = bjd();
                    IE.ak("obj_name", bjd.bnh() != null && (bjd.bnh().dJS() != null || bjd.bnh().bFj() != null) ? 1 : 0);
                    if (bjd.blC() != null) {
                        IE.ak(TiebaInitialize.Params.AB_TYPE, bjd.blC().hadConcerned() ? 1 : 0);
                    }
                    IE.ak("is_full", bjd.bnu() ? 1 : 0);
                }
            }
            return IE;
        } else if (cot()) {
            ar IE2 = IE(ici);
            if (IE2 != null) {
                IE2.setPosition(this.position);
                if (bjd() != null && (bmr = bjd().bmr()) != null) {
                    IE2.dR("obj_type", bmr.id);
                    IE2.dR("obj_name", bmr.name);
                    return IE2;
                }
                return IE2;
            }
            return IE2;
        } else if (bki()) {
            return null;
        } else {
            ar IE3 = IE(ibX);
            if (IE3 != null) {
                IE3.setPosition(this.position);
                IE3.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "show");
                if (bjd() != null) {
                    bx bjd2 = bjd();
                    boolean z = (bjd2.bnh() == null || (bjd2.bnh().dJS() == null && bjd2.bnh().bFj() == null)) ? false : true;
                    IE3.ak("obj_name", z ? 1 : 0);
                    if (z && bjd2.bnh().dJS() != null && bjd2.bnh().dJS().bFb() != null && bjd2.bnh().dJS().bFb().size() > 0) {
                        IE3.ak(TiebaInitialize.Params.OBJ_TO, bjd2.bnh().mYp ? 2 : 1);
                    }
                    if (bjd2.blC() != null) {
                        IE3.ak(TiebaInitialize.Params.AB_TYPE, bjd2.blC().hadConcerned() ? 1 : 0);
                    }
                    IE3.ak("is_full", bjd2.bnu() ? 1 : 0);
                    if (bjd2.getBaijiahaoData() != null) {
                        IE3.dR("obj_param4", bjd2.getBaijiahaoData().oriUgcNid);
                    }
                    IE3.ak("obj_param5", ah(bjd2));
                    IE3.dR("nid", bjd2.getNid());
                    if (bjd2.bnG()) {
                        IE3.ak("obj_param6", 2);
                    } else {
                        IE3.ak("obj_param6", 1);
                    }
                }
            }
            return IE3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public ar IF(String str) {
        int i;
        ar arVar = new ar(str);
        if (this.evQ != null) {
            if (this.evQ.getBaijiahaoData() == null) {
                arVar.w("fid", this.evQ.getFid());
                arVar.dR("tid", this.evQ.getTid());
            } else {
                arVar.dR("tid", this.evQ.getBaijiahaoData().oriUgcNid);
            }
            if (this.evQ.bki()) {
                i = 2;
            } else if (this.evQ.isLinkThread()) {
                i = 4;
            } else if (this.evQ.isShareThread) {
                i = 5;
            } else if (this.evQ.bkk()) {
                i = 6;
            } else if (this.evQ.bnz()) {
                i = 7;
            } else if (this.evQ.bkl()) {
                i = 8;
            } else {
                i = this.evQ.bnA() ? 9 : 1;
            }
            arVar.ak("obj_type", i);
            arVar.dR("obj_id", this.evQ.blC().getUserId());
            arVar.ak("obj_param1", cok() ? 2 : 1);
        }
        return arVar;
    }

    public ar IH(String str) {
        ar IE = IE(str);
        if (IE != null) {
            IE.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "show");
            if (bjd() != null) {
                bx bjd = bjd();
                boolean z = (bjd.bnh() == null || (bjd.bnh().dJS() == null && bjd.bnh().bFj() == null)) ? false : true;
                IE.ak("obj_name", z ? 1 : 0);
                if (z && bjd.bnh().dJS() != null && bjd.bnh().dJS().bFb() != null && bjd.bnh().dJS().bFb().size() > 0) {
                    IE.ak(TiebaInitialize.Params.OBJ_TO, bjd.bnh().mYp ? 2 : 1);
                }
            }
        }
        return IE;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar com() {
        ar IE;
        SmartApp bmr;
        if (cos()) {
            IE = IE(icd);
        } else if (cot()) {
            ar IE2 = IE(icj);
            if (IE2 != null && bjd() != null && (bmr = bjd().bmr()) != null) {
                IE2.dR("obj_type", bmr.id);
                IE2.dR("obj_name", bmr.name);
                return IE2;
            }
            return IE2;
        } else {
            IE = IE(ibY);
            if (IE != null) {
                IE.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bjd() != null) {
                    bx bjd = bjd();
                    if (bjd.getBaijiahaoData() != null) {
                        IE.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                    }
                    IE.ak("obj_param5", ah(bjd));
                    IE.dR("nid", bjd.getNid());
                }
            }
        }
        if (IE != null && bjd() != null) {
            IE.ak("is_full", bjd().bnu() ? 1 : 0);
        }
        return IE;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar col() {
        if (cos()) {
            return IE(ice);
        }
        if (l.ad(this.evQ)) {
            ar aI = aI(icm, true);
            if (aI != null && bjd() != null) {
                bx bjd = bjd();
                if (bjd.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
                }
                aI.ak("obj_param5", ah(bjd));
                aI.dR("nid", bjd.getNid());
                return aI;
            }
            return aI;
        }
        ar aM = aM(ibZ, 0);
        if (aM != null) {
            aM.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bjd() != null) {
                bx bjd2 = bjd();
                if (bjd2.getBaijiahaoData() != null) {
                    aM.dR("obj_param4", bjd2.getBaijiahaoData().oriUgcNid);
                }
                aM.ak("obj_param5", ah(bjd2));
                aM.dR("nid", bjd2.getNid());
                return aM;
            }
            return aM;
        }
        return aM;
    }

    public ar cou() {
        if (l.ad(this.evQ)) {
            ar aI = aI(icl, true);
            if (aI != null && bjd() != null) {
                bx bjd = bjd();
                if (bjd.getBaijiahaoData() != null) {
                    aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                    aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
                }
                aI.ak("obj_param5", ah(bjd));
                if (bjd.bnG()) {
                    aI.ak(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aI;
                }
                aI.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aI;
            }
            return aI;
        } else if (cos()) {
            return IE(icf);
        } else {
            ar IE = IE(ica);
            if (IE != null) {
                IE.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "click");
                if (bjd() != null) {
                    bx bjd2 = bjd();
                    if (bjd2.getBaijiahaoData() != null) {
                        IE.dR("obj_param4", bjd2.getBaijiahaoData().oriUgcNid);
                    }
                    IE.ak("obj_param5", ah(bjd2));
                    IE.dR("nid", bjd2.getNid());
                    if (bjd2.bnG()) {
                        IE.ak(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return IE;
                    }
                    IE.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return IE;
                }
                return IE;
            }
            return IE;
        }
    }

    public ar cov() {
        if (cos()) {
            return IE(icg);
        }
        ar IE = IE(icb);
        if (IE != null) {
            IE.dR("ab_tag", cog()).dR(TiebaInitialize.Params.AB_ACTION, "click");
            if (bjd() != null) {
                bx bjd = bjd();
                if (bjd.getBaijiahaoData() != null) {
                    IE.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                }
                IE.ak("obj_param5", ah(bjd));
                IE.dR("nid", bjd.getNid());
                return IE;
            }
            return IE;
        }
        return IE;
    }

    public ar cow() {
        return IE(ich);
    }

    @Override // com.baidu.tieba.card.data.b
    public ar con() {
        ar aI = aI(ick, true);
        if (bjd() != null) {
            bx bjd = bjd();
            if (bjd.getBaijiahaoData() != null) {
                aI.dR("obj_param4", bjd.getBaijiahaoData().oriUgcNid);
                aI.dR("obj_param6", bjd.getBaijiahaoData().oriUgcVid);
            }
            aI.ak("obj_param5", ah(bjd));
            aI.dR("nid", bjd.getNid());
        }
        return aI;
    }

    public ar II(String str) {
        ar IE = IE(str);
        if (this.evQ != null && this.evQ.blC() != null) {
            IE.ak(TiebaInitialize.Params.AB_TYPE, this.evQ.blC().hadConcerned() ? 1 : 0);
        }
        return IE;
    }

    public ar IJ(String str) {
        return IE(str);
    }

    public int ag(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bkk()) {
            return 1;
        }
        if (bxVar.bki()) {
            return 2;
        }
        if (bxVar.bnz()) {
            return 3;
        }
        return bxVar.bnA() ? 4 : 0;
    }

    public int ah(bx bxVar) {
        if (bxVar == null) {
            return 1;
        }
        if (bxVar.bnA() || bxVar.bnz()) {
            return 2;
        }
        return (bxVar.bkk() || bxVar.bkl()) ? 3 : 1;
    }
}
