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
    public static String daK = "";
    public static String daL = "";
    public static String daM = "";
    public static String daN = "";
    public static String daO = "";
    public static String daP = "";
    public static String daQ = "";
    public static String daR = "";
    public static String daS = "";
    public static String daT = "";
    public static String daU = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId daV = BdUniqueId.gen();
    public static final BdUniqueId ath = BdUniqueId.gen();
    public static final BdUniqueId atn = BdUniqueId.gen();
    public static final BdUniqueId daW = BdUniqueId.gen();
    public boolean daX = false;
    public boolean isLinkThread = false;
    public boolean daY = false;
    public boolean aZE = true;

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
        if (this.daX) {
            return daV;
        }
        if (this.isLinkThread) {
            return ath;
        }
        if (this.threadData.isShareThread) {
            return atn;
        }
        if (this.threadData.getType() == bb.atp) {
            return daW;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb ZT() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.zv() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aqM() {
        return (this.threadData == null || v.H(this.threadData.zV()) == 0) ? false : true;
    }

    public am aqN() {
        bb ZT;
        if (this.daX) {
            am amVar = new am("c11003");
            if (ZT() != null && (ZT = ZT()) != null) {
                amVar.aA("tid", ZT.getTid());
                if (ZT.zG() != null) {
                    amVar.x("ab_type", ZT.zG().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (aqM()) {
            am mL = mL(daP);
            if (mL != null && ZT() != null) {
                bb ZT2 = ZT();
                mL.x("obj_name", ZT2.AX() != null && (ZT2.AX().bEl() != null || ZT2.AX().Sj() != null) ? 1 : 0);
                if (ZT2.zG() != null) {
                    mL.x("ab_type", ZT2.zG().hadConcerned() ? 1 : 0);
                }
            }
            return mL;
        } else {
            am mL2 = mL(daK);
            if (mL2 != null) {
                mL2.aA("ab_tag", aqE()).aA("ab_action", "show");
                if (ZT() != null) {
                    bb ZT3 = ZT();
                    boolean z = (ZT3.AX() == null || (ZT3.AX().bEl() == null && ZT3.AX().Sj() == null)) ? false : true;
                    mL2.x("obj_name", z ? 1 : 0);
                    if (z && ZT3.AX().bEl() != null && ZT3.AX().bEl().Sb() != null && ZT3.AX().bEl().Sb().size() > 0) {
                        mL2.x("obj_to", ZT3.AX().hpd ? 2 : 1);
                    }
                    if (ZT3.zG() != null) {
                        mL2.x("ab_type", ZT3.zG().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return mL2;
        }
    }

    public am mN(String str) {
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
            amVar.x("obj_param1", aqI() ? 2 : 1);
        }
        return amVar;
    }

    public am mO(String str) {
        am mL = mL(str);
        if (mL != null) {
            mL.aA("ab_tag", aqE()).aA("ab_action", "show");
            if (ZT() != null) {
                bb ZT = ZT();
                boolean z = (ZT.AX() == null || (ZT.AX().bEl() == null && ZT.AX().Sj() == null)) ? false : true;
                mL.x("obj_name", z ? 1 : 0);
                if (z && ZT.AX().bEl() != null && ZT.AX().bEl().Sb() != null && ZT.AX().bEl().Sb().size() > 0) {
                    mL.x("obj_to", ZT.AX().hpd ? 2 : 1);
                }
            }
        }
        return mL;
    }

    public am mP(String str) {
        am mL = mL(str);
        if (mL != null) {
            mL.aA("ab_tag", aqE()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return mL;
    }

    public am aqO() {
        if (aqM()) {
            return mL(daQ);
        }
        am mL = mL(daL);
        if (mL != null) {
            mL.aA("ab_tag", aqE()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mL;
        }
        return mL;
    }

    public am aqP() {
        if (aqM()) {
            return mL(daR);
        }
        am ab = ab(daM, 0);
        if (ab != null) {
            ab.aA("ab_tag", aqE()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return ab;
        }
        return ab;
    }

    public am aqQ() {
        if (aqM()) {
            return mL(daS);
        }
        am mL = mL(daN);
        if (mL != null) {
            mL.aA("ab_tag", aqE()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mL;
        }
        return mL;
    }

    public am aqR() {
        if (aqM()) {
            return mL(daT);
        }
        am mL = mL(daO);
        if (mL != null) {
            mL.aA("ab_tag", aqE()).aA("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mL;
        }
        return mL;
    }

    public am aqS() {
        return mL(daU);
    }

    public am mQ(String str) {
        return mL(str);
    }

    public am mR(String str) {
        am mL = mL(str);
        if (this.threadData != null && this.threadData.zG() != null) {
            mL.x("ab_type", this.threadData.zG().hadConcerned() ? 1 : 0);
        }
        return mL;
    }

    public am mS(String str) {
        return mL(str);
    }
}
