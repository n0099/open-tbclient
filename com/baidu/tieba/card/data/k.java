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
    public static String cBY = "";
    public static String cBZ = "";
    public static String cCa = "";
    public static String cCb = "";
    public static String cCc = "";
    public static String cCd = "";
    public static String cCe = "";
    public static String cCf = "";
    public static String cCg = "";
    public static String cCh = "";
    public static String cCi = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cCj = BdUniqueId.gen();
    public static final BdUniqueId ahy = BdUniqueId.gen();
    public static final BdUniqueId ahE = BdUniqueId.gen();
    public static final BdUniqueId cCk = BdUniqueId.gen();
    public boolean cCl = false;
    public boolean isLinkThread = false;
    public boolean cCm = false;
    public boolean aNy = true;

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
        if (this.cCl) {
            return cCj;
        }
        if (this.isLinkThread) {
            return ahy;
        }
        if (this.threadData.isShareThread) {
            return ahE;
        }
        if (this.threadData.getType() == bb.ahG) {
            return cCk;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb Td() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.uZ() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean ajs() {
        return (this.threadData == null || w.y(this.threadData.vz()) == 0) ? false : true;
    }

    public an ajt() {
        bb Td;
        if (this.cCl) {
            an anVar = new an("c11003");
            if (Td() != null && (Td = Td()) != null) {
                anVar.af("tid", Td.getTid());
                if (Td.vk() != null) {
                    anVar.r("ab_type", Td.vk().hadConcerned() ? 1 : 0);
                }
            }
            return anVar;
        } else if (ajs()) {
            an lc = lc(cCd);
            if (lc != null && Td() != null) {
                bb Td2 = Td();
                lc.r("obj_name", Td2.wx() != null && (Td2.wx().bwh() != null || Td2.wx().NF() != null) ? 1 : 0);
                if (Td2.vk() != null) {
                    lc.r("ab_type", Td2.vk().hadConcerned() ? 1 : 0);
                }
            }
            return lc;
        } else {
            an lc2 = lc(cBY);
            if (lc2 != null) {
                lc2.af("ab_tag", ajk()).af("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (Td() != null) {
                    bb Td3 = Td();
                    boolean z = (Td3.wx() == null || (Td3.wx().bwh() == null && Td3.wx().NF() == null)) ? false : true;
                    lc2.r("obj_name", z ? 1 : 0);
                    if (z && Td3.wx().bwh() != null && Td3.wx().bwh().Nx() != null && Td3.wx().bwh().Nx().size() > 0) {
                        lc2.r("obj_to", Td3.wx().gOz ? 2 : 1);
                    }
                    if (Td3.vk() != null) {
                        lc2.r("ab_type", Td3.vk().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return lc2;
        }
    }

    public an le(String str) {
        int i;
        an anVar = new an(str);
        if (anVar != null && this.threadData != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            anVar.af("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            anVar.r("obj_type", i);
            anVar.af(VideoPlayActivityConfig.OBJ_ID, this.threadData.vk().getUserId());
            anVar.r("obj_param1", ajo() ? 2 : 1);
        }
        return anVar;
    }

    public an lf(String str) {
        an lc = lc(str);
        if (lc != null) {
            lc.af("ab_tag", ajk()).af("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (Td() != null) {
                bb Td = Td();
                boolean z = (Td.wx() == null || (Td.wx().bwh() == null && Td.wx().NF() == null)) ? false : true;
                lc.r("obj_name", z ? 1 : 0);
                if (z && Td.wx().bwh() != null && Td.wx().bwh().Nx() != null && Td.wx().bwh().Nx().size() > 0) {
                    lc.r("obj_to", Td.wx().gOz ? 2 : 1);
                }
            }
        }
        return lc;
    }

    public an lg(String str) {
        an lc = lc(str);
        if (lc != null) {
            lc.af("ab_tag", ajk()).af("ab_action", "click");
        }
        return lc;
    }

    public an aju() {
        if (ajs()) {
            return lc(cCe);
        }
        an lc = lc(cBZ);
        if (lc != null) {
            lc.af("ab_tag", ajk()).af("ab_action", "click");
            return lc;
        }
        return lc;
    }

    public an ajv() {
        if (ajs()) {
            return lc(cCf);
        }
        an Q = Q(cCa, 0);
        if (Q != null) {
            Q.af("ab_tag", ajk()).af("ab_action", "click");
            return Q;
        }
        return Q;
    }

    public an ajw() {
        if (ajs()) {
            return lc(cCg);
        }
        an lc = lc(cCb);
        if (lc != null) {
            lc.af("ab_tag", ajk()).af("ab_action", "click");
            return lc;
        }
        return lc;
    }

    public an ajx() {
        if (ajs()) {
            return lc(cCh);
        }
        an lc = lc(cCc);
        if (lc != null) {
            lc.af("ab_tag", ajk()).af("ab_action", "click");
            return lc;
        }
        return lc;
    }

    public an ajy() {
        return lc(cCi);
    }

    public an lh(String str) {
        return lc(str);
    }

    public an li(String str) {
        an lc = lc(str);
        if (this.threadData != null && this.threadData.vk() != null) {
            lc.r("ab_type", this.threadData.vk().hadConcerned() ? 1 : 0);
        }
        return lc;
    }

    public an lj(String str) {
        return lc(str);
    }
}
