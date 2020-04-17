package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class k extends c {
    public static String gsg = "";
    public static String gsh = "";
    public static String gsi = "";
    public static String gsj = "";
    public static String gsk = "";
    public static String gsl = "";
    public static String gsm = "";
    public static String gsn = "";
    public static String gso = "";
    public static String gsp = "";
    public static String gsq = "";
    public static String gsr = "";
    public static String gss = "";
    public static String gst = "";
    public static String gsu = "";
    public static String gsv = "";
    public static String gsw = "";
    public static String gsx = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId gsy = BdUniqueId.gen();
    public static final BdUniqueId dqT = BdUniqueId.gen();
    public static final BdUniqueId dqZ = BdUniqueId.gen();
    public static final BdUniqueId dra = BdUniqueId.gen();
    public static final BdUniqueId drb = BdUniqueId.gen();
    public static final BdUniqueId drc = BdUniqueId.gen();
    public static final BdUniqueId gsz = BdUniqueId.gen();
    public static final BdUniqueId gsA = BdUniqueId.gen();
    public static final BdUniqueId gsB = BdUniqueId.gen();
    public static final BdUniqueId gsC = BdUniqueId.gen();
    public static final BdUniqueId gsD = BdUniqueId.gen();
    public static final BdUniqueId gsE = BdUniqueId.gen();
    public static final BdUniqueId gsF = BdUniqueId.gen();
    public static final BdUniqueId gsG = BdUniqueId.gen();
    public static final BdUniqueId gsH = BdUniqueId.gen();
    public static final BdUniqueId gsI = BdUniqueId.gen();
    public static final BdUniqueId gsJ = BdUniqueId.gen();
    public static final BdUniqueId drg = BdUniqueId.gen();
    public static final BdUniqueId drh = BdUniqueId.gen();
    public boolean gsK = false;
    public boolean isLinkThread = false;
    public boolean gsL = false;
    public boolean dqo = false;
    public boolean dqp = false;
    public boolean gsM = false;
    public boolean dqs = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean gsN = false;
    public boolean gsO = false;
    public boolean dqy = false;
    public boolean dqt = false;
    public boolean gsP = false;
    public boolean dYb = true;

    public static boolean ab(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.dqE || bjVar.getType() == bj.dqU || bjVar.getType() == bj.dqT || bjVar.getType() == bj.dqZ || bjVar.getType() == bj.dre;
    }

    public static boolean ad(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.drg || bjVar.getType() == bj.drh;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqA == null) {
            return TYPE;
        }
        if (this.dqA.threadType == 63) {
            return drg;
        }
        if (this.dqA.threadType == 64) {
            return drh;
        }
        if (this.dqA.isShareThread && this.dqA.dto != null) {
            if (this.dqA.dto.dpg) {
                OriginalThreadInfo originalThreadInfo = this.dqA.dto;
                if (originalThreadInfo.videoInfo != null) {
                    return drc;
                }
                if (originalThreadInfo.aJt()) {
                    return drb;
                }
                return dra;
            }
            return dqZ;
        } else if (this.dqo) {
            return gsA;
        } else {
            if (this.dqp) {
                return gsB;
            }
            if (this.gsM) {
                return gsD;
            }
            if (this.dqs) {
                return gsE;
            }
            if (this.dqt) {
                return gsF;
            }
            if (this.dqu) {
                return gsJ;
            }
            if (this.dqv) {
                return gsI;
            }
            if (this.gsN) {
                return gsG;
            }
            if (this.gsO) {
                return gsH;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIw() {
        if (this.dqA == null) {
            return this.dqA;
        }
        if (this.dqA.aKs() == 5) {
            return this.dqA;
        }
        this.dqA.jP(1);
        return this.dqA;
    }

    public boolean bFq() {
        return (this.dqA == null || v.getCount(this.dqA.aKS()) == 0) ? false : true;
    }

    public boolean bFr() {
        return this.dqA == null || this.dqA.aLE();
    }

    public boolean aJr() {
        return this.dqA != null && this.dqA.aJr();
    }

    public an bFs() {
        SmartApp aLq;
        if (bFq()) {
            an BF = BF(gsl);
            if (BF != null) {
                BF.setPosition(this.position);
                if (aIw() != null) {
                    bj aIw = aIw();
                    BF.af("obj_name", aIw.aMe() != null && (aIw.aMe().cWt() != null || aIw.aMe().bcp() != null) ? 1 : 0);
                    if (aIw.aKE() != null) {
                        BF.af(TiebaInitialize.Params.AB_TYPE, aIw.aKE().hadConcerned() ? 1 : 0);
                    }
                    BF.af("is_full", aIw.aMr() ? 1 : 0);
                }
            }
            return BF;
        } else if (bFr()) {
            an BF2 = BF(gsr);
            if (BF2 != null) {
                BF2.setPosition(this.position);
                if (aIw() != null && (aLq = aIw().aLq()) != null) {
                    BF2.cI("obj_type", aLq.id);
                    BF2.cI("obj_name", aLq.name);
                    return BF2;
                }
                return BF2;
            }
            return BF2;
        } else if (aJr()) {
            return null;
        } else {
            an BF3 = BF(gsg);
            if (BF3 != null) {
                BF3.setPosition(this.position);
                BF3.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "show");
                if (aIw() != null) {
                    bj aIw2 = aIw();
                    boolean z = (aIw2.aMe() == null || (aIw2.aMe().cWt() == null && aIw2.aMe().bcp() == null)) ? false : true;
                    BF3.af("obj_name", z ? 1 : 0);
                    if (z && aIw2.aMe().cWt() != null && aIw2.aMe().cWt().bch() != null && aIw2.aMe().cWt().bch().size() > 0) {
                        BF3.af(TiebaInitialize.Params.OBJ_TO, aIw2.aMe().kSW ? 2 : 1);
                    }
                    if (aIw2.aKE() != null) {
                        BF3.af(TiebaInitialize.Params.AB_TYPE, aIw2.aKE().hadConcerned() ? 1 : 0);
                    }
                    BF3.af("is_full", aIw2.aMr() ? 1 : 0);
                    if (aIw2.getBaijiahaoData() != null) {
                        BF3.cI("obj_param4", aIw2.getBaijiahaoData().oriUgcNid);
                    }
                    BF3.af("obj_param5", af(aIw2));
                }
            }
            return BF3;
        }
    }

    public an BH(String str) {
        int i;
        an anVar = new an(str);
        if (this.dqA != null) {
            if (this.dqA.getBaijiahaoData() == null) {
                anVar.t("fid", this.dqA.getFid());
                anVar.cI("tid", this.dqA.getTid());
            } else {
                anVar.cI("tid", this.dqA.getBaijiahaoData().oriUgcNid);
            }
            if (this.dqA.aJr()) {
                i = 2;
            } else if (this.dqA.isLinkThread()) {
                i = 4;
            } else if (this.dqA.isShareThread) {
                i = 5;
            } else if (this.dqA.aJt()) {
                i = 6;
            } else if (this.dqA.aMy()) {
                i = 7;
            } else if (this.dqA.aJu()) {
                i = 8;
            } else {
                i = this.dqA.aMz() ? 9 : 1;
            }
            anVar.af("obj_type", i);
            anVar.cI("obj_id", this.dqA.aKE().getUserId());
            anVar.af("obj_param1", bFm() ? 2 : 1);
        }
        return anVar;
    }

    public an BI(String str) {
        an BF = BF(str);
        if (BF != null) {
            BF.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "show");
            if (aIw() != null) {
                bj aIw = aIw();
                boolean z = (aIw.aMe() == null || (aIw.aMe().cWt() == null && aIw.aMe().bcp() == null)) ? false : true;
                BF.af("obj_name", z ? 1 : 0);
                if (z && aIw.aMe().cWt() != null && aIw.aMe().cWt().bch() != null && aIw.aMe().cWt().bch().size() > 0) {
                    BF.af(TiebaInitialize.Params.OBJ_TO, aIw.aMe().kSW ? 2 : 1);
                }
            }
        }
        return BF;
    }

    public an bFt() {
        an BF;
        SmartApp aLq;
        if (bFq()) {
            BF = BF(gsm);
        } else if (bFr()) {
            an BF2 = BF(gss);
            if (BF2 != null && aIw() != null && (aLq = aIw().aLq()) != null) {
                BF2.cI("obj_type", aLq.id);
                BF2.cI("obj_name", aLq.name);
                return BF2;
            }
            return BF2;
        } else {
            BF = BF(gsh);
            if (BF != null) {
                BF.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "click");
                if (aIw() != null) {
                    bj aIw = aIw();
                    if (aIw.getBaijiahaoData() != null) {
                        BF.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                    }
                    BF.af("obj_param5", af(aIw));
                }
            }
        }
        if (BF != null && aIw() != null) {
            BF.af("is_full", aIw().aMr() ? 1 : 0);
        }
        return BF;
    }

    public an bFu() {
        if (bFq()) {
            return BF(gsn);
        }
        if (l.ab(this.dqA)) {
            an al = al(gsv, true);
            if (al != null && aIw() != null) {
                bj aIw = aIw();
                if (aIw.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIw));
                return al;
            }
            return al;
        }
        an aH = aH(gsi, 0);
        if (aH != null) {
            aH.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "click");
            if (aIw() != null) {
                bj aIw2 = aIw();
                if (aIw2.getBaijiahaoData() != null) {
                    aH.cI("obj_param4", aIw2.getBaijiahaoData().oriUgcNid);
                }
                aH.af("obj_param5", af(aIw2));
                return aH;
            }
            return aH;
        }
        return aH;
    }

    public an bFv() {
        if (l.ab(this.dqA)) {
            an al = al(gsu, true);
            if (al != null && aIw() != null) {
                bj aIw = aIw();
                if (aIw.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIw));
                return al;
            }
            return al;
        } else if (bFq()) {
            return BF(gso);
        } else {
            an BF = BF(gsj);
            if (BF != null) {
                BF.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "click");
                if (aIw() != null) {
                    bj aIw2 = aIw();
                    if (aIw2.getBaijiahaoData() != null) {
                        BF.cI("obj_param4", aIw2.getBaijiahaoData().oriUgcNid);
                    }
                    BF.af("obj_param5", af(aIw2));
                    return BF;
                }
                return BF;
            }
            return BF;
        }
    }

    public an bFw() {
        if (bFq()) {
            return BF(gsp);
        }
        an BF = BF(gsk);
        if (BF != null) {
            BF.cI(TiebaInitialize.Params.AB_TAG, bFi()).cI(TiebaInitialize.Params.AB_ACTION, "click");
            if (aIw() != null) {
                bj aIw = aIw();
                if (aIw.getBaijiahaoData() != null) {
                    BF.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                }
                BF.af("obj_param5", af(aIw));
                return BF;
            }
            return BF;
        }
        return BF;
    }

    public an bFx() {
        return BF(gsq);
    }

    public an bFy() {
        an al = al(gst, true);
        if (aIw() != null) {
            bj aIw = aIw();
            if (aIw.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIw));
        }
        return al;
    }

    public an BJ(String str) {
        an BF = BF(str);
        if (this.dqA != null && this.dqA.aKE() != null) {
            BF.af(TiebaInitialize.Params.AB_TYPE, this.dqA.aKE().hadConcerned() ? 1 : 0);
        }
        return BF;
    }

    public an BK(String str) {
        return BF(str);
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJt()) {
            return 1;
        }
        if (bjVar.aJr()) {
            return 2;
        }
        if (bjVar.aMy()) {
            return 3;
        }
        return bjVar.aMz() ? 4 : 0;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aMz() || bjVar.aMy()) {
            return 2;
        }
        return (bjVar.aJt() || bjVar.aJu()) ? 3 : 1;
    }
}
