package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes2.dex */
public class k extends c {
    public bb threadData;
    public static String cHM = "";
    public static String cHN = "";
    public static String cHO = "";
    public static String cHP = "";
    public static String cHQ = "";
    public static String cHR = "";
    public static String cHS = "";
    public static String cHT = "";
    public static String cHU = "";
    public static String cHV = "";
    public static String cHW = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cHX = BdUniqueId.gen();
    public static final BdUniqueId ajY = BdUniqueId.gen();
    public static final BdUniqueId ake = BdUniqueId.gen();
    public static final BdUniqueId cHY = BdUniqueId.gen();
    public boolean cHZ = false;
    public boolean isLinkThread = false;
    public boolean cIa = false;
    public boolean aQN = true;

    public static boolean S(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.ajX || bbVar.getType() == bb.ajZ || bbVar.getType() == bb.ajY || bbVar.getType() == bb.ake || bbVar.getType() == bb.akg;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cHZ) {
            return cHX;
        }
        if (this.isLinkThread) {
            return ajY;
        }
        if (this.threadData.isShareThread) {
            return ake;
        }
        if (this.threadData.getType() == bb.akg) {
            return cHY;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb UT() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.wb() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean alg() {
        return (this.threadData == null || v.y(this.threadData.wB()) == 0) ? false : true;
    }

    public am alh() {
        bb UT;
        if (this.cHZ) {
            am amVar = new am("c11003");
            if (UT() != null && (UT = UT()) != null) {
                amVar.al("tid", UT.getTid());
                if (UT.wm() != null) {
                    amVar.w("ab_type", UT.wm().hadConcerned() ? 1 : 0);
                }
            }
            return amVar;
        } else if (alg()) {
            am lG = lG(cHR);
            if (lG != null && UT() != null) {
                bb UT2 = UT();
                lG.w("obj_name", UT2.xD() != null && (UT2.xD().byO() != null || UT2.xD().OX() != null) ? 1 : 0);
                if (UT2.wm() != null) {
                    lG.w("ab_type", UT2.wm().hadConcerned() ? 1 : 0);
                }
            }
            return lG;
        } else {
            am lG2 = lG(cHM);
            if (lG2 != null) {
                lG2.al("ab_tag", akY()).al("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (UT() != null) {
                    bb UT3 = UT();
                    boolean z = (UT3.xD() == null || (UT3.xD().byO() == null && UT3.xD().OX() == null)) ? false : true;
                    lG2.w("obj_name", z ? 1 : 0);
                    if (z && UT3.xD().byO() != null && UT3.xD().byO().OP() != null && UT3.xD().byO().OP().size() > 0) {
                        lG2.w("obj_to", UT3.xD().gWf ? 2 : 1);
                    }
                    if (UT3.wm() != null) {
                        lG2.w("ab_type", UT3.wm().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return lG2;
        }
    }

    public am lI(String str) {
        int i;
        am amVar = new am(str);
        if (amVar != null && this.threadData != null) {
            amVar.g(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            amVar.al("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            amVar.w("obj_type", i);
            amVar.al(VideoPlayActivityConfig.OBJ_ID, this.threadData.wm().getUserId());
            amVar.w("obj_param1", alc() ? 2 : 1);
        }
        return amVar;
    }

    public am lJ(String str) {
        am lG = lG(str);
        if (lG != null) {
            lG.al("ab_tag", akY()).al("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (UT() != null) {
                bb UT = UT();
                boolean z = (UT.xD() == null || (UT.xD().byO() == null && UT.xD().OX() == null)) ? false : true;
                lG.w("obj_name", z ? 1 : 0);
                if (z && UT.xD().byO() != null && UT.xD().byO().OP() != null && UT.xD().byO().OP().size() > 0) {
                    lG.w("obj_to", UT.xD().gWf ? 2 : 1);
                }
            }
        }
        return lG;
    }

    public am lK(String str) {
        am lG = lG(str);
        if (lG != null) {
            lG.al("ab_tag", akY()).al("ab_action", "click");
        }
        return lG;
    }

    public am ali() {
        if (alg()) {
            return lG(cHS);
        }
        am lG = lG(cHN);
        if (lG != null) {
            lG.al("ab_tag", akY()).al("ab_action", "click");
            return lG;
        }
        return lG;
    }

    public am alj() {
        if (alg()) {
            return lG(cHT);
        }
        am V = V(cHO, 0);
        if (V != null) {
            V.al("ab_tag", akY()).al("ab_action", "click");
            return V;
        }
        return V;
    }

    public am alk() {
        if (alg()) {
            return lG(cHU);
        }
        am lG = lG(cHP);
        if (lG != null) {
            lG.al("ab_tag", akY()).al("ab_action", "click");
            return lG;
        }
        return lG;
    }

    public am all() {
        if (alg()) {
            return lG(cHV);
        }
        am lG = lG(cHQ);
        if (lG != null) {
            lG.al("ab_tag", akY()).al("ab_action", "click");
            return lG;
        }
        return lG;
    }

    public am alm() {
        return lG(cHW);
    }

    public am lL(String str) {
        return lG(str);
    }

    public am lM(String str) {
        am lG = lG(str);
        if (this.threadData != null && this.threadData.wm() != null) {
            lG.w("ab_type", this.threadData.wm().hadConcerned() ? 1 : 0);
        }
        return lG;
    }

    public am lN(String str) {
        return lG(str);
    }
}
