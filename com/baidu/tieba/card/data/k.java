package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes2.dex */
public class k extends c {
    public bd threadData;
    public static String cBy = "";
    public static String cBz = "";
    public static String cBA = "";
    public static String cBB = "";
    public static String cBC = "";
    public static String cBD = "";
    public static String cBE = "";
    public static String cBF = "";
    public static String cBG = "";
    public static String cBH = "";
    public static String cBI = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cBJ = BdUniqueId.gen();
    public static final BdUniqueId ahK = BdUniqueId.gen();
    public static final BdUniqueId ahQ = BdUniqueId.gen();
    public static final BdUniqueId cBK = BdUniqueId.gen();
    public boolean cBL = false;
    public boolean isLinkThread = false;
    public boolean cBM = false;
    public boolean aMC = true;

    public static boolean N(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.ahJ || bdVar.getType() == bd.ahL || bdVar.getType() == bd.ahK || bdVar.getType() == bd.ahQ || bdVar.getType() == bd.ahS;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cBL) {
            return cBJ;
        }
        if (this.isLinkThread) {
            return ahK;
        }
        if (this.threadData.isShareThread) {
            return ahQ;
        }
        if (this.threadData.getType() == bd.ahS) {
            return cBK;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Sz() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.vc() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean ajz() {
        return (this.threadData == null || w.y(this.threadData.vA()) == 0) ? false : true;
    }

    public am ajA() {
        bd Sz;
        if (this.cBL) {
            am amVar = new am("c11003");
            if (Sz() != null && (Sz = Sz()) != null) {
                amVar.ah("tid", Sz.getTid());
                if (Sz.vm() != null) {
                    amVar.r("ab_type", Sz.vm().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (ajz()) {
            am lg = lg(cBD);
            if (lg != null && Sz() != null) {
                bd Sz2 = Sz();
                lg.r("obj_name", Sz2.wy() != null && (Sz2.wy().bxb() != null || Sz2.wy().No() != null) ? 1 : 0);
                if (Sz2.vm() != null) {
                    lg.r("ab_type", Sz2.vm().hadConcerned() ? 1 : 0);
                }
            }
            return lg;
        } else {
            am lg2 = lg(cBy);
            if (lg2 != null) {
                lg2.ah("ab_tag", ajr()).ah("ab_action", "show");
                if (Sz() != null) {
                    bd Sz3 = Sz();
                    boolean z = (Sz3.wy() == null || (Sz3.wy().bxb() == null && Sz3.wy().No() == null)) ? false : true;
                    lg2.r("obj_name", z ? 1 : 0);
                    if (z && Sz3.wy().bxb() != null && Sz3.wy().bxb().Ng() != null && Sz3.wy().bxb().Ng().size() > 0) {
                        lg2.r("obj_to", Sz3.wy().gJA ? 2 : 1);
                    }
                    if (Sz3.vm() != null) {
                        lg2.r("ab_type", Sz3.vm().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return lg2;
        }
    }

    public am li(String str) {
        int i;
        am amVar = new am(str);
        if (amVar != null && this.threadData != null) {
            amVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.ah("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.r("obj_type", i);
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.threadData.vm().getUserId());
            amVar.r("obj_param1", ajv() ? 2 : 1);
        }
        return amVar;
    }

    public am lj(String str) {
        am lg = lg(str);
        if (lg != null) {
            lg.ah("ab_tag", ajr()).ah("ab_action", "show");
            if (Sz() != null) {
                bd Sz = Sz();
                boolean z = (Sz.wy() == null || (Sz.wy().bxb() == null && Sz.wy().No() == null)) ? false : true;
                lg.r("obj_name", z ? 1 : 0);
                if (z && Sz.wy().bxb() != null && Sz.wy().bxb().Ng() != null && Sz.wy().bxb().Ng().size() > 0) {
                    lg.r("obj_to", Sz.wy().gJA ? 2 : 1);
                }
            }
        }
        return lg;
    }

    public am lk(String str) {
        am lg = lg(str);
        if (lg != null) {
            lg.ah("ab_tag", ajr()).ah("ab_action", "click");
        }
        return lg;
    }

    public am ajB() {
        if (ajz()) {
            return lg(cBE);
        }
        am lg = lg(cBz);
        if (lg != null) {
            lg.ah("ab_tag", ajr()).ah("ab_action", "click");
            return lg;
        }
        return lg;
    }

    public am ajC() {
        if (ajz()) {
            return lg(cBF);
        }
        am W = W(cBA, 0);
        if (W != null) {
            W.ah("ab_tag", ajr()).ah("ab_action", "click");
            return W;
        }
        return W;
    }

    public am ajD() {
        if (ajz()) {
            return lg(cBG);
        }
        am lg = lg(cBB);
        if (lg != null) {
            lg.ah("ab_tag", ajr()).ah("ab_action", "click");
            return lg;
        }
        return lg;
    }

    public am ajE() {
        if (ajz()) {
            return lg(cBH);
        }
        am lg = lg(cBC);
        if (lg != null) {
            lg.ah("ab_tag", ajr()).ah("ab_action", "click");
            return lg;
        }
        return lg;
    }

    public am ajF() {
        return lg(cBI);
    }

    public am ll(String str) {
        return lg(str);
    }

    public am lm(String str) {
        am lg = lg(str);
        if (this.threadData != null && this.threadData.vm() != null) {
            lg.r("ab_type", this.threadData.vm().hadConcerned() ? 1 : 0);
        }
        return lg;
    }

    public am ln(String str) {
        return lg(str);
    }
}
