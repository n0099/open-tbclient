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
    public bb YA() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.yk() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aoI() {
        return (this.threadData == null || v.I(this.threadData.yK()) == 0) ? false : true;
    }

    public am aoJ() {
        bb YA;
        if (this.cQs) {
            am amVar = new am("c11003");
            if (YA() != null && (YA = YA()) != null) {
                amVar.ax("tid", YA.getTid());
                if (YA.yv() != null) {
                    amVar.x("ab_type", YA.yv().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (aoI()) {
            am mi = mi(cQk);
            if (mi != null && YA() != null) {
                bb YA2 = YA();
                mi.x("obj_name", YA2.zM() != null && (YA2.zM().bCd() != null || YA2.zM().QS() != null) ? 1 : 0);
                if (YA2.yv() != null) {
                    mi.x("ab_type", YA2.yv().hadConcerned() ? 1 : 0);
                }
            }
            return mi;
        } else {
            am mi2 = mi(cQf);
            if (mi2 != null) {
                mi2.ax("ab_tag", aoA()).ax("ab_action", "show");
                if (YA() != null) {
                    bb YA3 = YA();
                    boolean z = (YA3.zM() == null || (YA3.zM().bCd() == null && YA3.zM().QS() == null)) ? false : true;
                    mi2.x("obj_name", z ? 1 : 0);
                    if (z && YA3.zM().bCd() != null && YA3.zM().bCd().QK() != null && YA3.zM().bCd().QK().size() > 0) {
                        mi2.x("obj_to", YA3.zM().hdA ? 2 : 1);
                    }
                    if (YA3.yv() != null) {
                        mi2.x("ab_type", YA3.yv().hadConcerned() ? 1 : 0);
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
            amVar.x("obj_param1", aoE() ? 2 : 1);
        }
        return amVar;
    }

    public am ml(String str) {
        am mi = mi(str);
        if (mi != null) {
            mi.ax("ab_tag", aoA()).ax("ab_action", "show");
            if (YA() != null) {
                bb YA = YA();
                boolean z = (YA.zM() == null || (YA.zM().bCd() == null && YA.zM().QS() == null)) ? false : true;
                mi.x("obj_name", z ? 1 : 0);
                if (z && YA.zM().bCd() != null && YA.zM().bCd().QK() != null && YA.zM().bCd().QK().size() > 0) {
                    mi.x("obj_to", YA.zM().hdA ? 2 : 1);
                }
            }
        }
        return mi;
    }

    public am mm(String str) {
        am mi = mi(str);
        if (mi != null) {
            mi.ax("ab_tag", aoA()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return mi;
    }

    public am aoK() {
        if (aoI()) {
            return mi(cQl);
        }
        am mi = mi(cQg);
        if (mi != null) {
            mi.ax("ab_tag", aoA()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoL() {
        if (aoI()) {
            return mi(cQm);
        }
        am Z = Z(cQh, 0);
        if (Z != null) {
            Z.ax("ab_tag", aoA()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return Z;
        }
        return Z;
    }

    public am aoM() {
        if (aoI()) {
            return mi(cQn);
        }
        am mi = mi(cQi);
        if (mi != null) {
            mi.ax("ab_tag", aoA()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoN() {
        if (aoI()) {
            return mi(cQo);
        }
        am mi = mi(cQj);
        if (mi != null) {
            mi.ax("ab_tag", aoA()).ax("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return mi;
        }
        return mi;
    }

    public am aoO() {
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
