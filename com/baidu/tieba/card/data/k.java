package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class k extends c {
    public bb threadData;
    public static String cRl = "";
    public static String cRm = "";
    public static String cRn = "";
    public static String cRo = "";
    public static String cRp = "";
    public static String cRq = "";
    public static String cRr = "";
    public static String cRs = "";
    public static String cRt = "";
    public static String cRu = "";
    public static String cRv = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cRw = BdUniqueId.gen();
    public static final BdUniqueId apH = BdUniqueId.gen();
    public static final BdUniqueId apN = BdUniqueId.gen();
    public static final BdUniqueId cRx = BdUniqueId.gen();
    public boolean cRy = false;
    public boolean isLinkThread = false;
    public boolean cRz = false;
    public boolean aWe = true;

    public static boolean S(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.apG || bbVar.getType() == bb.apI || bbVar.getType() == bb.apH || bbVar.getType() == bb.apN || bbVar.getType() == bb.apP;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cRy) {
            return cRw;
        }
        if (this.isLinkThread) {
            return apH;
        }
        if (this.threadData.isShareThread) {
            return apN;
        }
        if (this.threadData.getType() == bb.apP) {
            return cRx;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb YL() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.yr() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aok() {
        return (this.threadData == null || v.H(this.threadData.yR()) == 0) ? false : true;
    }

    public am aol() {
        bb YL;
        if (this.cRy) {
            am amVar = new am("c11003");
            if (YL() != null && (YL = YL()) != null) {
                amVar.ax("tid", YL.getTid());
                if (YL.yC() != null) {
                    amVar.x("ab_type", YL.yC().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (aok()) {
            am mj = mj(cRq);
            if (mj != null && YL() != null) {
                bb YL2 = YL();
                mj.x("obj_name", YL2.zT() != null && (YL2.zT().bBz() != null || YL2.zT().Rb() != null) ? 1 : 0);
                if (YL2.yC() != null) {
                    mj.x("ab_type", YL2.yC().hadConcerned() ? 1 : 0);
                }
            }
            return mj;
        } else {
            am mj2 = mj(cRl);
            if (mj2 != null) {
                mj2.ax("ab_tag", aoc()).ax("ab_action", "show");
                if (YL() != null) {
                    bb YL3 = YL();
                    boolean z = (YL3.zT() == null || (YL3.zT().bBz() == null && YL3.zT().Rb() == null)) ? false : true;
                    mj2.x("obj_name", z ? 1 : 0);
                    if (z && YL3.zT().bBz() != null && YL3.zT().bBz().QT() != null && YL3.zT().bBz().QT().size() > 0) {
                        mj2.x("obj_to", YL3.zT().heY ? 2 : 1);
                    }
                    if (YL3.yC() != null) {
                        mj2.x("ab_type", YL3.yC().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return mj2;
        }
    }

    public am ml(String str) {
        int i;
        am amVar = new am(str);
        if (amVar != null && this.threadData != null) {
            amVar.h(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.ax("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.x("obj_type", i);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.threadData.yC().getUserId());
            amVar.x("obj_param1", aog() ? 2 : 1);
        }
        return amVar;
    }

    public am mm(String str) {
        am mj = mj(str);
        if (mj != null) {
            mj.ax("ab_tag", aoc()).ax("ab_action", "show");
            if (YL() != null) {
                bb YL = YL();
                boolean z = (YL.zT() == null || (YL.zT().bBz() == null && YL.zT().Rb() == null)) ? false : true;
                mj.x("obj_name", z ? 1 : 0);
                if (z && YL.zT().bBz() != null && YL.zT().bBz().QT() != null && YL.zT().bBz().QT().size() > 0) {
                    mj.x("obj_to", YL.zT().heY ? 2 : 1);
                }
            }
        }
        return mj;
    }

    public am mn(String str) {
        am mj = mj(str);
        if (mj != null) {
            mj.ax("ab_tag", aoc()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return mj;
    }

    public am aom() {
        if (aok()) {
            return mj(cRr);
        }
        am mj = mj(cRm);
        if (mj != null) {
            mj.ax("ab_tag", aoc()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mj;
        }
        return mj;
    }

    public am aon() {
        if (aok()) {
            return mj(cRs);
        }
        am Z = Z(cRn, 0);
        if (Z != null) {
            Z.ax("ab_tag", aoc()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return Z;
        }
        return Z;
    }

    public am aoo() {
        if (aok()) {
            return mj(cRt);
        }
        am mj = mj(cRo);
        if (mj != null) {
            mj.ax("ab_tag", aoc()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mj;
        }
        return mj;
    }

    public am aop() {
        if (aok()) {
            return mj(cRu);
        }
        am mj = mj(cRp);
        if (mj != null) {
            mj.ax("ab_tag", aoc()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mj;
        }
        return mj;
    }

    public am aoq() {
        return mj(cRv);
    }

    public am mo(String str) {
        return mj(str);
    }

    public am mp(String str) {
        am mj = mj(str);
        if (this.threadData != null && this.threadData.yC() != null) {
            mj.x("ab_type", this.threadData.yC().hadConcerned() ? 1 : 0);
        }
        return mj;
    }

    public am mq(String str) {
        return mj(str);
    }
}
