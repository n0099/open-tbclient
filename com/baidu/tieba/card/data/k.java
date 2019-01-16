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
    public static String dbv = "";
    public static String dbw = "";
    public static String dbx = "";
    public static String dby = "";
    public static String dbz = "";
    public static String dbA = "";
    public static String dbB = "";
    public static String dbC = "";
    public static String dbD = "";
    public static String dbE = "";
    public static String dbF = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId dbG = BdUniqueId.gen();
    public static final BdUniqueId atJ = BdUniqueId.gen();
    public static final BdUniqueId atP = BdUniqueId.gen();
    public static final BdUniqueId dbH = BdUniqueId.gen();
    public boolean dbI = false;
    public boolean isLinkThread = false;
    public boolean dbJ = false;
    public boolean bao = true;

    public static boolean S(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.atI || bbVar.getType() == bb.atK || bbVar.getType() == bb.atJ || bbVar.getType() == bb.atP || bbVar.getType() == bb.atR;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.dbI) {
            return dbG;
        }
        if (this.isLinkThread) {
            return atJ;
        }
        if (this.threadData.isShareThread) {
            return atP;
        }
        if (this.threadData.getType() == bb.atR) {
            return dbH;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb aaq() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.zI() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean arj() {
        return (this.threadData == null || v.H(this.threadData.Ai()) == 0) ? false : true;
    }

    public am ark() {
        bb aaq;
        if (this.dbI) {
            am amVar = new am("c11003");
            if (aaq() != null && (aaq = aaq()) != null) {
                amVar.aB("tid", aaq.getTid());
                if (aaq.zT() != null) {
                    amVar.y("ab_type", aaq.zT().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (arj()) {
            am nb = nb(dbA);
            if (nb != null && aaq() != null) {
                bb aaq2 = aaq();
                nb.y("obj_name", aaq2.Bk() != null && (aaq2.Bk().bEU() != null || aaq2.Bk().SF() != null) ? 1 : 0);
                if (aaq2.zT() != null) {
                    nb.y("ab_type", aaq2.zT().hadConcerned() ? 1 : 0);
                }
            }
            return nb;
        } else {
            am nb2 = nb(dbv);
            if (nb2 != null) {
                nb2.aB("ab_tag", arb()).aB("ab_action", "show");
                if (aaq() != null) {
                    bb aaq3 = aaq();
                    boolean z = (aaq3.Bk() == null || (aaq3.Bk().bEU() == null && aaq3.Bk().SF() == null)) ? false : true;
                    nb2.y("obj_name", z ? 1 : 0);
                    if (z && aaq3.Bk().bEU() != null && aaq3.Bk().bEU().Sx() != null && aaq3.Bk().bEU().Sx().size() > 0) {
                        nb2.y("obj_to", aaq3.Bk().hqi ? 2 : 1);
                    }
                    if (aaq3.zT() != null) {
                        nb2.y("ab_type", aaq3.zT().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return nb2;
        }
    }

    public am nd(String str) {
        int i;
        am amVar = new am(str);
        if (amVar != null && this.threadData != null) {
            amVar.i(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.aB("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.y("obj_type", i);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.threadData.zT().getUserId());
            amVar.y("obj_param1", arf() ? 2 : 1);
        }
        return amVar;
    }

    public am ne(String str) {
        am nb = nb(str);
        if (nb != null) {
            nb.aB("ab_tag", arb()).aB("ab_action", "show");
            if (aaq() != null) {
                bb aaq = aaq();
                boolean z = (aaq.Bk() == null || (aaq.Bk().bEU() == null && aaq.Bk().SF() == null)) ? false : true;
                nb.y("obj_name", z ? 1 : 0);
                if (z && aaq.Bk().bEU() != null && aaq.Bk().bEU().Sx() != null && aaq.Bk().bEU().Sx().size() > 0) {
                    nb.y("obj_to", aaq.Bk().hqi ? 2 : 1);
                }
            }
        }
        return nb;
    }

    public am nf(String str) {
        am nb = nb(str);
        if (nb != null) {
            nb.aB("ab_tag", arb()).aB("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
        }
        return nb;
    }

    public am arl() {
        return kR(-1);
    }

    public am kR(int i) {
        if (arj()) {
            return nb(dbB);
        }
        am nb = nb(dbw);
        if (nb != null) {
            nb.aB("ab_tag", arb()).aB("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            if (i != -1) {
                nb.y("click_locate", i);
                return nb;
            }
            return nb;
        }
        return nb;
    }

    public am arm() {
        if (arj()) {
            return nb(dbC);
        }
        am ab = ab(dbx, 0);
        if (ab != null) {
            ab.aB("ab_tag", arb()).aB("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return ab;
        }
        return ab;
    }

    public am arn() {
        if (arj()) {
            return nb(dbD);
        }
        am nb = nb(dby);
        if (nb != null) {
            nb.aB("ab_tag", arb()).aB("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return nb;
        }
        return nb;
    }

    public am aro() {
        if (arj()) {
            return nb(dbE);
        }
        am nb = nb(dbz);
        if (nb != null) {
            nb.aB("ab_tag", arb()).aB("ab_action", AiAppsUBCStatistic.TYPE_CLICK);
            return nb;
        }
        return nb;
    }

    public am arp() {
        return nb(dbF);
    }

    public am ng(String str) {
        return nb(str);
    }

    public am nh(String str) {
        am nb = nb(str);
        if (this.threadData != null && this.threadData.zT() != null) {
            nb.y("ab_type", this.threadData.zT().hadConcerned() ? 1 : 0);
        }
        return nb;
    }

    public am ni(String str) {
        return nb(str);
    }
}
