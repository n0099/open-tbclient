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
    public static String cXS = "";
    public static String cXT = "";
    public static String cXU = "";
    public static String cXV = "";
    public static String cXW = "";
    public static String cXX = "";
    public static String cXY = "";
    public static String cXZ = "";
    public static String cYa = "";
    public static String cYb = "";
    public static String cYc = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cYd = BdUniqueId.gen();
    public static final BdUniqueId ath = BdUniqueId.gen();
    public static final BdUniqueId atn = BdUniqueId.gen();
    public static final BdUniqueId cYe = BdUniqueId.gen();
    public boolean cYf = false;
    public boolean isLinkThread = false;
    public boolean cYg = false;
    public boolean aZB = true;

    public static boolean S(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.atg || bbVar.getType() == bb.ati || bbVar.getType() == bb.ath || bbVar.getType() == bb.atn || bbVar.getType() == bb.atp;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cYf) {
            return cYd;
        }
        if (this.isLinkThread) {
            return ath;
        }
        if (this.threadData.isShareThread) {
            return atn;
        }
        if (this.threadData.getType() == bb.atp) {
            return cYe;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb ZR() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.zv() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean apX() {
        return (this.threadData == null || v.H(this.threadData.zV()) == 0) ? false : true;
    }

    public am apY() {
        bb ZR;
        if (this.cYf) {
            am amVar = new am("c11003");
            if (ZR() != null && (ZR = ZR()) != null) {
                amVar.aA("tid", ZR.getTid());
                if (ZR.zG() != null) {
                    amVar.x("ab_type", ZR.zG().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (apX()) {
            am mI = mI(cXX);
            if (mI != null && ZR() != null) {
                bb ZR2 = ZR();
                mI.x("obj_name", ZR2.AX() != null && (ZR2.AX().bDt() != null || ZR2.AX().Sh() != null) ? 1 : 0);
                if (ZR2.zG() != null) {
                    mI.x("ab_type", ZR2.zG().hadConcerned() ? 1 : 0);
                }
            }
            return mI;
        } else {
            am mI2 = mI(cXS);
            if (mI2 != null) {
                mI2.aA("ab_tag", apP()).aA("ab_action", "show");
                if (ZR() != null) {
                    bb ZR3 = ZR();
                    boolean z = (ZR3.AX() == null || (ZR3.AX().bDt() == null && ZR3.AX().Sh() == null)) ? false : true;
                    mI2.x("obj_name", z ? 1 : 0);
                    if (z && ZR3.AX().bDt() != null && ZR3.AX().bDt().RZ() != null && ZR3.AX().bDt().RZ().size() > 0) {
                        mI2.x("obj_to", ZR3.AX().hlS ? 2 : 1);
                    }
                    if (ZR3.zG() != null) {
                        mI2.x("ab_type", ZR3.zG().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return mI2;
        }
    }

    public am mK(String str) {
        int i;
        am amVar = new am(str);
        if (amVar != null && this.threadData != null) {
            amVar.i(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.aA("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.x("obj_type", i);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.threadData.zG().getUserId());
            amVar.x("obj_param1", apT() ? 2 : 1);
        }
        return amVar;
    }

    public am mL(String str) {
        am mI = mI(str);
        if (mI != null) {
            mI.aA("ab_tag", apP()).aA("ab_action", "show");
            if (ZR() != null) {
                bb ZR = ZR();
                boolean z = (ZR.AX() == null || (ZR.AX().bDt() == null && ZR.AX().Sh() == null)) ? false : true;
                mI.x("obj_name", z ? 1 : 0);
                if (z && ZR.AX().bDt() != null && ZR.AX().bDt().RZ() != null && ZR.AX().bDt().RZ().size() > 0) {
                    mI.x("obj_to", ZR.AX().hlS ? 2 : 1);
                }
            }
        }
        return mI;
    }

    public am mM(String str) {
        am mI = mI(str);
        if (mI != null) {
            mI.aA("ab_tag", apP()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return mI;
    }

    public am apZ() {
        if (apX()) {
            return mI(cXY);
        }
        am mI = mI(cXT);
        if (mI != null) {
            mI.aA("ab_tag", apP()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mI;
        }
        return mI;
    }

    public am aqa() {
        if (apX()) {
            return mI(cXZ);
        }
        am aa = aa(cXU, 0);
        if (aa != null) {
            aa.aA("ab_tag", apP()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return aa;
        }
        return aa;
    }

    public am aqb() {
        if (apX()) {
            return mI(cYa);
        }
        am mI = mI(cXV);
        if (mI != null) {
            mI.aA("ab_tag", apP()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mI;
        }
        return mI;
    }

    public am aqc() {
        if (apX()) {
            return mI(cYb);
        }
        am mI = mI(cXW);
        if (mI != null) {
            mI.aA("ab_tag", apP()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mI;
        }
        return mI;
    }

    public am aqd() {
        return mI(cYc);
    }

    public am mN(String str) {
        return mI(str);
    }

    public am mO(String str) {
        am mI = mI(str);
        if (this.threadData != null && this.threadData.zG() != null) {
            mI.x("ab_type", this.threadData.zG().hadConcerned() ? 1 : 0);
        }
        return mI;
    }

    public am mP(String str) {
        return mI(str);
    }
}
