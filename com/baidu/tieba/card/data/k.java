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
    public static String gsy = "";
    public static String gsz = "";
    public static String gsA = "";
    public static String gsB = "";
    public static String gsC = "";
    public static String gsD = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId gsE = BdUniqueId.gen();
    public static final BdUniqueId dqX = BdUniqueId.gen();
    public static final BdUniqueId drd = BdUniqueId.gen();
    public static final BdUniqueId dre = BdUniqueId.gen();
    public static final BdUniqueId drf = BdUniqueId.gen();
    public static final BdUniqueId drg = BdUniqueId.gen();
    public static final BdUniqueId gsF = BdUniqueId.gen();
    public static final BdUniqueId gsG = BdUniqueId.gen();
    public static final BdUniqueId gsH = BdUniqueId.gen();
    public static final BdUniqueId gsI = BdUniqueId.gen();
    public static final BdUniqueId gsJ = BdUniqueId.gen();
    public static final BdUniqueId gsK = BdUniqueId.gen();
    public static final BdUniqueId gsL = BdUniqueId.gen();
    public static final BdUniqueId gsM = BdUniqueId.gen();
    public static final BdUniqueId gsN = BdUniqueId.gen();
    public static final BdUniqueId gsO = BdUniqueId.gen();
    public static final BdUniqueId gsP = BdUniqueId.gen();
    public static final BdUniqueId drk = BdUniqueId.gen();
    public static final BdUniqueId drl = BdUniqueId.gen();
    public boolean gsQ = false;
    public boolean isLinkThread = false;
    public boolean gsR = false;
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean gsS = false;
    public boolean dqw = false;
    public boolean dqy = false;
    public boolean dqz = false;
    public boolean gsT = false;
    public boolean gsU = false;
    public boolean dqC = false;
    public boolean dqx = false;
    public boolean gsV = false;
    public boolean dYg = true;

    public static boolean ab(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.dqI || bjVar.getType() == bj.dqY || bjVar.getType() == bj.dqX || bjVar.getType() == bj.drd || bjVar.getType() == bj.dri;
    }

    public static boolean ad(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.drk || bjVar.getType() == bj.drl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqE == null) {
            return TYPE;
        }
        if (this.dqE.threadType == 63) {
            return drk;
        }
        if (this.dqE.threadType == 64) {
            return drl;
        }
        if (this.dqE.isShareThread && this.dqE.dtt != null) {
            if (this.dqE.dtt.dpk) {
                OriginalThreadInfo originalThreadInfo = this.dqE.dtt;
                if (originalThreadInfo.videoInfo != null) {
                    return drg;
                }
                if (originalThreadInfo.aJr()) {
                    return drf;
                }
                return dre;
            }
            return drd;
        } else if (this.dqs) {
            return gsG;
        } else {
            if (this.dqt) {
                return gsH;
            }
            if (this.gsS) {
                return gsJ;
            }
            if (this.dqw) {
                return gsK;
            }
            if (this.dqx) {
                return gsL;
            }
            if (this.dqy) {
                return gsP;
            }
            if (this.dqz) {
                return gsO;
            }
            if (this.gsT) {
                return gsM;
            }
            if (this.gsU) {
                return gsN;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIu() {
        if (this.dqE == null) {
            return this.dqE;
        }
        if (this.dqE.aKq() == 5) {
            return this.dqE;
        }
        this.dqE.jP(1);
        return this.dqE;
    }

    public boolean bFo() {
        return (this.dqE == null || v.getCount(this.dqE.aKQ()) == 0) ? false : true;
    }

    public boolean bFp() {
        return this.dqE == null || this.dqE.aLC();
    }

    public boolean aJp() {
        return this.dqE != null && this.dqE.aJp();
    }

    public an bFq() {
        SmartApp aLo;
        if (bFo()) {
            an BI = BI(gsr);
            if (BI != null) {
                BI.setPosition(this.position);
                if (aIu() != null) {
                    bj aIu = aIu();
                    BI.af("obj_name", aIu.aMc() != null && (aIu.aMc().cWq() != null || aIu.aMc().bcn() != null) ? 1 : 0);
                    if (aIu.aKC() != null) {
                        BI.af(TiebaInitialize.Params.AB_TYPE, aIu.aKC().hadConcerned() ? 1 : 0);
                    }
                    BI.af("is_full", aIu.aMp() ? 1 : 0);
                }
            }
            return BI;
        } else if (bFp()) {
            an BI2 = BI(gsx);
            if (BI2 != null) {
                BI2.setPosition(this.position);
                if (aIu() != null && (aLo = aIu().aLo()) != null) {
                    BI2.cI("obj_type", aLo.id);
                    BI2.cI("obj_name", aLo.name);
                    return BI2;
                }
                return BI2;
            }
            return BI2;
        } else if (aJp()) {
            return null;
        } else {
            an BI3 = BI(gsm);
            if (BI3 != null) {
                BI3.setPosition(this.position);
                BI3.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "show");
                if (aIu() != null) {
                    bj aIu2 = aIu();
                    boolean z = (aIu2.aMc() == null || (aIu2.aMc().cWq() == null && aIu2.aMc().bcn() == null)) ? false : true;
                    BI3.af("obj_name", z ? 1 : 0);
                    if (z && aIu2.aMc().cWq() != null && aIu2.aMc().cWq().bcf() != null && aIu2.aMc().cWq().bcf().size() > 0) {
                        BI3.af(TiebaInitialize.Params.OBJ_TO, aIu2.aMc().kTa ? 2 : 1);
                    }
                    if (aIu2.aKC() != null) {
                        BI3.af(TiebaInitialize.Params.AB_TYPE, aIu2.aKC().hadConcerned() ? 1 : 0);
                    }
                    BI3.af("is_full", aIu2.aMp() ? 1 : 0);
                    if (aIu2.getBaijiahaoData() != null) {
                        BI3.cI("obj_param4", aIu2.getBaijiahaoData().oriUgcNid);
                    }
                    BI3.af("obj_param5", af(aIu2));
                }
            }
            return BI3;
        }
    }

    public an BK(String str) {
        int i;
        an anVar = new an(str);
        if (this.dqE != null) {
            if (this.dqE.getBaijiahaoData() == null) {
                anVar.t("fid", this.dqE.getFid());
                anVar.cI("tid", this.dqE.getTid());
            } else {
                anVar.cI("tid", this.dqE.getBaijiahaoData().oriUgcNid);
            }
            if (this.dqE.aJp()) {
                i = 2;
            } else if (this.dqE.isLinkThread()) {
                i = 4;
            } else if (this.dqE.isShareThread) {
                i = 5;
            } else if (this.dqE.aJr()) {
                i = 6;
            } else if (this.dqE.aMw()) {
                i = 7;
            } else if (this.dqE.aJs()) {
                i = 8;
            } else {
                i = this.dqE.aMx() ? 9 : 1;
            }
            anVar.af("obj_type", i);
            anVar.cI("obj_id", this.dqE.aKC().getUserId());
            anVar.af("obj_param1", bFk() ? 2 : 1);
        }
        return anVar;
    }

    public an BL(String str) {
        an BI = BI(str);
        if (BI != null) {
            BI.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "show");
            if (aIu() != null) {
                bj aIu = aIu();
                boolean z = (aIu.aMc() == null || (aIu.aMc().cWq() == null && aIu.aMc().bcn() == null)) ? false : true;
                BI.af("obj_name", z ? 1 : 0);
                if (z && aIu.aMc().cWq() != null && aIu.aMc().cWq().bcf() != null && aIu.aMc().cWq().bcf().size() > 0) {
                    BI.af(TiebaInitialize.Params.OBJ_TO, aIu.aMc().kTa ? 2 : 1);
                }
            }
        }
        return BI;
    }

    public an bFr() {
        an BI;
        SmartApp aLo;
        if (bFo()) {
            BI = BI(gss);
        } else if (bFp()) {
            an BI2 = BI(gsy);
            if (BI2 != null && aIu() != null && (aLo = aIu().aLo()) != null) {
                BI2.cI("obj_type", aLo.id);
                BI2.cI("obj_name", aLo.name);
                return BI2;
            }
            return BI2;
        } else {
            BI = BI(gsn);
            if (BI != null) {
                BI.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "click");
                if (aIu() != null) {
                    bj aIu = aIu();
                    if (aIu.getBaijiahaoData() != null) {
                        BI.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                    }
                    BI.af("obj_param5", af(aIu));
                }
            }
        }
        if (BI != null && aIu() != null) {
            BI.af("is_full", aIu().aMp() ? 1 : 0);
        }
        return BI;
    }

    public an bFs() {
        if (bFo()) {
            return BI(gst);
        }
        if (l.ab(this.dqE)) {
            an al = al(gsB, true);
            if (al != null && aIu() != null) {
                bj aIu = aIu();
                if (aIu.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIu));
                return al;
            }
            return al;
        }
        an aH = aH(gso, 0);
        if (aH != null) {
            aH.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "click");
            if (aIu() != null) {
                bj aIu2 = aIu();
                if (aIu2.getBaijiahaoData() != null) {
                    aH.cI("obj_param4", aIu2.getBaijiahaoData().oriUgcNid);
                }
                aH.af("obj_param5", af(aIu2));
                return aH;
            }
            return aH;
        }
        return aH;
    }

    public an bFt() {
        if (l.ab(this.dqE)) {
            an al = al(gsA, true);
            if (al != null && aIu() != null) {
                bj aIu = aIu();
                if (aIu.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIu));
                return al;
            }
            return al;
        } else if (bFo()) {
            return BI(gsu);
        } else {
            an BI = BI(gsp);
            if (BI != null) {
                BI.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "click");
                if (aIu() != null) {
                    bj aIu2 = aIu();
                    if (aIu2.getBaijiahaoData() != null) {
                        BI.cI("obj_param4", aIu2.getBaijiahaoData().oriUgcNid);
                    }
                    BI.af("obj_param5", af(aIu2));
                    return BI;
                }
                return BI;
            }
            return BI;
        }
    }

    public an bFu() {
        if (bFo()) {
            return BI(gsv);
        }
        an BI = BI(gsq);
        if (BI != null) {
            BI.cI(TiebaInitialize.Params.AB_TAG, bFg()).cI(TiebaInitialize.Params.AB_ACTION, "click");
            if (aIu() != null) {
                bj aIu = aIu();
                if (aIu.getBaijiahaoData() != null) {
                    BI.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                }
                BI.af("obj_param5", af(aIu));
                return BI;
            }
            return BI;
        }
        return BI;
    }

    public an bFv() {
        return BI(gsw);
    }

    public an bFw() {
        an al = al(gsz, true);
        if (aIu() != null) {
            bj aIu = aIu();
            if (aIu.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIu));
        }
        return al;
    }

    public an BM(String str) {
        an BI = BI(str);
        if (this.dqE != null && this.dqE.aKC() != null) {
            BI.af(TiebaInitialize.Params.AB_TYPE, this.dqE.aKC().hadConcerned() ? 1 : 0);
        }
        return BI;
    }

    public an BN(String str) {
        return BI(str);
    }

    public int ae(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJr()) {
            return 1;
        }
        if (bjVar.aJp()) {
            return 2;
        }
        if (bjVar.aMw()) {
            return 3;
        }
        return bjVar.aMx() ? 4 : 0;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aMx() || bjVar.aMw()) {
            return 2;
        }
        return (bjVar.aJr() || bjVar.aJs()) ? 3 : 1;
    }
}
