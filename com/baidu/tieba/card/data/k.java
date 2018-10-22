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
    public static String cQf = "";
    public static String cQg = "";
    public static String cQh = "";
    public static String cQi = "";
    public static String cQj = "";
    public static String cQk = "";
    public static String cQl = "";
    public static String cQm = "";
    public static String cQn = "";
    public static String cQo = "";
    public static String cQp = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cQq = BdUniqueId.gen();
    public static final BdUniqueId aoT = BdUniqueId.gen();
    public static final BdUniqueId aoZ = BdUniqueId.gen();
    public static final BdUniqueId cQr = BdUniqueId.gen();
    public boolean cQs = false;
    public boolean isLinkThread = false;
    public boolean cQt = false;
    public boolean aVo = true;

    public static boolean S(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.aoS || bbVar.getType() == bb.aoU || bbVar.getType() == bb.aoT || bbVar.getType() == bb.aoZ || bbVar.getType() == bb.apb;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cQs) {
            return cQq;
        }
        if (this.isLinkThread) {
            return aoT;
        }
        if (this.threadData.isShareThread) {
            return aoZ;
        }
        if (this.threadData.getType() == bb.apb) {
            return cQr;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb YB() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.yk() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aoJ() {
        return (this.threadData == null || v.I(this.threadData.yK()) == 0) ? false : true;
    }

    public am aoK() {
        bb YB;
        if (this.cQs) {
            am amVar = new am("c11003");
            if (YB() != null && (YB = YB()) != null) {
                amVar.ax("tid", YB.getTid());
                if (YB.yv() != null) {
                    amVar.x("ab_type", YB.yv().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (aoJ()) {
            am mi = mi(cQk);
            if (mi != null && YB() != null) {
                bb YB2 = YB();
                mi.x("obj_name", YB2.zM() != null && (YB2.zM().bCd() != null || YB2.zM().QS() != null) ? 1 : 0);
                if (YB2.yv() != null) {
                    mi.x("ab_type", YB2.yv().hadConcerned() ? 1 : 0);
                }
            }
            return mi;
        } else {
            am mi2 = mi(cQf);
            if (mi2 != null) {
                mi2.ax("ab_tag", aoB()).ax("ab_action", "show");
                if (YB() != null) {
                    bb YB3 = YB();
                    boolean z = (YB3.zM() == null || (YB3.zM().bCd() == null && YB3.zM().QS() == null)) ? false : true;
                    mi2.x("obj_name", z ? 1 : 0);
                    if (z && YB3.zM().bCd() != null && YB3.zM().bCd().QK() != null && YB3.zM().bCd().QK().size() > 0) {
                        mi2.x("obj_to", YB3.zM().hdB ? 2 : 1);
                    }
                    if (YB3.yv() != null) {
                        mi2.x("ab_type", YB3.yv().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return mi2;
        }
    }

    public am mk(String str) {
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
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.threadData.yv().getUserId());
            amVar.x("obj_param1", aoF() ? 2 : 1);
        }
        return amVar;
    }

    public am ml(String str) {
        am mi = mi(str);
        if (mi != null) {
            mi.ax("ab_tag", aoB()).ax("ab_action", "show");
            if (YB() != null) {
                bb YB = YB();
                boolean z = (YB.zM() == null || (YB.zM().bCd() == null && YB.zM().QS() == null)) ? false : true;
                mi.x("obj_name", z ? 1 : 0);
                if (z && YB.zM().bCd() != null && YB.zM().bCd().QK() != null && YB.zM().bCd().QK().size() > 0) {
                    mi.x("obj_to", YB.zM().hdB ? 2 : 1);
                }
            }
        }
        return mi;
    }

    public am mm(String str) {
        am mi = mi(str);
        if (mi != null) {
            mi.ax("ab_tag", aoB()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return mi;
    }

    public am aoL() {
        if (aoJ()) {
            return mi(cQl);
        }
        am mi = mi(cQg);
        if (mi != null) {
            mi.ax("ab_tag", aoB()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoM() {
        if (aoJ()) {
            return mi(cQm);
        }
        am Z = Z(cQh, 0);
        if (Z != null) {
            Z.ax("ab_tag", aoB()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return Z;
        }
        return Z;
    }

    public am aoN() {
        if (aoJ()) {
            return mi(cQn);
        }
        am mi = mi(cQi);
        if (mi != null) {
            mi.ax("ab_tag", aoB()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoO() {
        if (aoJ()) {
            return mi(cQo);
        }
        am mi = mi(cQj);
        if (mi != null) {
            mi.ax("ab_tag", aoB()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoP() {
        return mi(cQp);
    }

    public am mn(String str) {
        return mi(str);
    }

    public am mo(String str) {
        am mi = mi(str);
        if (this.threadData != null && this.threadData.yv() != null) {
            mi.x("ab_type", this.threadData.yv().hadConcerned() ? 1 : 0);
        }
        return mi;
    }

    public am mp(String str) {
        return mi(str);
    }
}
