package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes2.dex */
public class k extends c {
    public bd threadData;
    public static String crK = "";
    public static String crL = "";
    public static String crM = "";
    public static String crN = "";
    public static String crO = "";
    public static String crP = "";
    public static String crQ = "";
    public static String crR = "";
    public static String crS = "";
    public static String crT = "";
    public static String crU = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId crV = BdUniqueId.gen();
    public static final BdUniqueId ZI = BdUniqueId.gen();
    public static final BdUniqueId ZO = BdUniqueId.gen();
    public static final BdUniqueId crW = BdUniqueId.gen();
    public boolean crX = false;
    public boolean isLinkThread = false;
    public boolean crY = false;
    public boolean aEf = true;

    public static boolean N(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.ZH || bdVar.getType() == bd.ZJ || bdVar.getType() == bd.ZI || bdVar.getType() == bd.ZO || bdVar.getType() == bd.ZQ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.crX) {
            return crV;
        }
        if (this.isLinkThread) {
            return ZI;
        }
        if (this.threadData.isShareThread) {
            return ZO;
        }
        if (this.threadData.getType() == bd.ZQ) {
            return crW;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Pe() {
        return this.threadData;
    }

    public boolean afR() {
        return (this.threadData == null || v.v(this.threadData.se()) == 0) ? false : true;
    }

    public al afS() {
        bd Pe;
        if (this.crX) {
            al alVar = new al("c11003");
            if (Pe() != null && (Pe = Pe()) != null) {
                alVar.ac("tid", Pe.getTid());
                if (Pe.rQ() != null) {
                    alVar.r("ab_type", Pe.rQ().hadConcerned() ? 1 : 0);
                }
            }
            return alVar;
        } else if (afR()) {
            al kA = kA(crP);
            if (kA != null && Pe() != null) {
                bd Pe2 = Pe();
                kA.r("obj_name", Pe2.tc() != null && (Pe2.tc().bsb() != null || Pe2.tc().JR() != null) ? 1 : 0);
                if (Pe2.rQ() != null) {
                    kA.r("ab_type", Pe2.rQ().hadConcerned() ? 1 : 0);
                }
            }
            return kA;
        } else {
            al kA2 = kA(crK);
            if (kA2 != null) {
                kA2.ac("ab_tag", afK()).ac("ab_action", "show");
                if (Pe() != null) {
                    bd Pe3 = Pe();
                    boolean z = (Pe3.tc() == null || (Pe3.tc().bsb() == null && Pe3.tc().JR() == null)) ? false : true;
                    kA2.r("obj_name", z ? 1 : 0);
                    if (z && Pe3.tc().bsb() != null && Pe3.tc().bsb().JJ() != null && Pe3.tc().bsb().JJ().size() > 0) {
                        kA2.r("obj_to", Pe3.tc().gwX ? 2 : 1);
                    }
                    if (Pe3.rQ() != null) {
                        kA2.r("ab_type", Pe3.rQ().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return kA2;
        }
    }

    public al kC(String str) {
        al alVar = new al(str);
        if (alVar != null && this.threadData != null) {
            alVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            alVar.ac("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            alVar.r("obj_type", i);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.threadData.rQ().getUserId());
        }
        return alVar;
    }

    public al kD(String str) {
        al kA = kA(str);
        if (kA != null) {
            kA.ac("ab_tag", afK()).ac("ab_action", "show");
            if (Pe() != null) {
                bd Pe = Pe();
                boolean z = (Pe.tc() == null || (Pe.tc().bsb() == null && Pe.tc().JR() == null)) ? false : true;
                kA.r("obj_name", z ? 1 : 0);
                if (z && Pe.tc().bsb() != null && Pe.tc().bsb().JJ() != null && Pe.tc().bsb().JJ().size() > 0) {
                    kA.r("obj_to", Pe.tc().gwX ? 2 : 1);
                }
            }
        }
        return kA;
    }

    public al kE(String str) {
        al kA = kA(str);
        if (kA != null) {
            kA.ac("ab_tag", afK()).ac("ab_action", "click");
        }
        return kA;
    }

    public al afT() {
        if (afR()) {
            return kA(crQ);
        }
        al kA = kA(crL);
        if (kA != null) {
            kA.ac("ab_tag", afK()).ac("ab_action", "click");
            return kA;
        }
        return kA;
    }

    public al afU() {
        if (afR()) {
            return kA(crR);
        }
        al U = U(crM, 0);
        if (U != null) {
            U.ac("ab_tag", afK()).ac("ab_action", "click");
            return U;
        }
        return U;
    }

    public al afV() {
        if (afR()) {
            return kA(crS);
        }
        al kA = kA(crN);
        if (kA != null) {
            kA.ac("ab_tag", afK()).ac("ab_action", "click");
            return kA;
        }
        return kA;
    }

    public al afW() {
        if (afR()) {
            return kA(crT);
        }
        al kA = kA(crO);
        if (kA != null) {
            kA.ac("ab_tag", afK()).ac("ab_action", "click");
            return kA;
        }
        return kA;
    }

    public al afX() {
        return kA(crU);
    }

    public al kF(String str) {
        return kA(str);
    }

    public al kG(String str) {
        al kA = kA(str);
        if (this.threadData != null && this.threadData.rQ() != null) {
            kA.r("ab_type", this.threadData.rQ().hadConcerned() ? 1 : 0);
        }
        return kA;
    }

    public al kH(String str) {
        return kA(str);
    }
}
