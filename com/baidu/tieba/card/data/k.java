package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes2.dex */
public class k extends c {
    public bb threadData;
    public static String cBV = "";
    public static String cBW = "";
    public static String cBX = "";
    public static String cBY = "";
    public static String cBZ = "";
    public static String cCa = "";
    public static String cCb = "";
    public static String cCc = "";
    public static String cCd = "";
    public static String cCe = "";
    public static String cCf = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cCg = BdUniqueId.gen();
    public static final BdUniqueId ahy = BdUniqueId.gen();
    public static final BdUniqueId ahE = BdUniqueId.gen();
    public static final BdUniqueId cCh = BdUniqueId.gen();
    public boolean cCi = false;
    public boolean isLinkThread = false;
    public boolean cCj = false;
    public boolean aNv = true;

    public static boolean R(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        return bbVar.getType() == bb.ahx || bbVar.getType() == bb.ahz || bbVar.getType() == bb.ahy || bbVar.getType() == bb.ahE || bbVar.getType() == bb.ahG;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cCi) {
            return cCg;
        }
        if (this.isLinkThread) {
            return ahy;
        }
        if (this.threadData.isShareThread) {
            return ahE;
        }
        if (this.threadData.getType() == bb.ahG) {
            return cCh;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb Tg() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.uY() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean ajv() {
        return (this.threadData == null || w.y(this.threadData.vy()) == 0) ? false : true;
    }

    public an ajw() {
        bb Tg;
        if (this.cCi) {
            an anVar = new an("c11003");
            if (Tg() != null && (Tg = Tg()) != null) {
                anVar.ae("tid", Tg.getTid());
                if (Tg.vj() != null) {
                    anVar.r("ab_type", Tg.vj().hadConcerned() ? 1 : 0);
                }
            }
            return anVar;
        } else if (ajv()) {
            an le = le(cCa);
            if (le != null && Tg() != null) {
                bb Tg2 = Tg();
                le.r("obj_name", Tg2.ww() != null && (Tg2.ww().bwi() != null || Tg2.ww().NE() != null) ? 1 : 0);
                if (Tg2.vj() != null) {
                    le.r("ab_type", Tg2.vj().hadConcerned() ? 1 : 0);
                }
            }
            return le;
        } else {
            an le2 = le(cBV);
            if (le2 != null) {
                le2.ae("ab_tag", ajn()).ae("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (Tg() != null) {
                    bb Tg3 = Tg();
                    boolean z = (Tg3.ww() == null || (Tg3.ww().bwi() == null && Tg3.ww().NE() == null)) ? false : true;
                    le2.r("obj_name", z ? 1 : 0);
                    if (z && Tg3.ww().bwi() != null && Tg3.ww().bwi().Nw() != null && Tg3.ww().bwi().Nw().size() > 0) {
                        le2.r("obj_to", Tg3.ww().gOB ? 2 : 1);
                    }
                    if (Tg3.vj() != null) {
                        le2.r("ab_type", Tg3.vj().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return le2;
        }
    }

    public an lg(String str) {
        int i;
        an anVar = new an(str);
        if (anVar != null && this.threadData != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            anVar.ae("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            anVar.r("obj_type", i);
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.threadData.vj().getUserId());
            anVar.r("obj_param1", ajr() ? 2 : 1);
        }
        return anVar;
    }

    public an lh(String str) {
        an le = le(str);
        if (le != null) {
            le.ae("ab_tag", ajn()).ae("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (Tg() != null) {
                bb Tg = Tg();
                boolean z = (Tg.ww() == null || (Tg.ww().bwi() == null && Tg.ww().NE() == null)) ? false : true;
                le.r("obj_name", z ? 1 : 0);
                if (z && Tg.ww().bwi() != null && Tg.ww().bwi().Nw() != null && Tg.ww().bwi().Nw().size() > 0) {
                    le.r("obj_to", Tg.ww().gOB ? 2 : 1);
                }
            }
        }
        return le;
    }

    public an li(String str) {
        an le = le(str);
        if (le != null) {
            le.ae("ab_tag", ajn()).ae("ab_action", "click");
        }
        return le;
    }

    public an ajx() {
        if (ajv()) {
            return le(cCb);
        }
        an le = le(cBW);
        if (le != null) {
            le.ae("ab_tag", ajn()).ae("ab_action", "click");
            return le;
        }
        return le;
    }

    public an ajy() {
        if (ajv()) {
            return le(cCc);
        }
        an Q = Q(cBX, 0);
        if (Q != null) {
            Q.ae("ab_tag", ajn()).ae("ab_action", "click");
            return Q;
        }
        return Q;
    }

    public an ajz() {
        if (ajv()) {
            return le(cCd);
        }
        an le = le(cBY);
        if (le != null) {
            le.ae("ab_tag", ajn()).ae("ab_action", "click");
            return le;
        }
        return le;
    }

    public an ajA() {
        if (ajv()) {
            return le(cCe);
        }
        an le = le(cBZ);
        if (le != null) {
            le.ae("ab_tag", ajn()).ae("ab_action", "click");
            return le;
        }
        return le;
    }

    public an ajB() {
        return le(cCf);
    }

    public an lj(String str) {
        return le(str);
    }

    public an lk(String str) {
        an le = le(str);
        if (this.threadData != null && this.threadData.vj() != null) {
            le.r("ab_type", this.threadData.vj().hadConcerned() ? 1 : 0);
        }
        return le;
    }

    public an ll(String str) {
        return le(str);
    }
}
