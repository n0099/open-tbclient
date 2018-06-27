package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes2.dex */
public class k extends c {
    public bc threadData;
    public static String czs = "";
    public static String czt = "";
    public static String czu = "";
    public static String czv = "";
    public static String czw = "";
    public static String czx = "";
    public static String czy = "";
    public static String czz = "";
    public static String czA = "";
    public static String czB = "";
    public static String czC = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId czD = BdUniqueId.gen();
    public static final BdUniqueId aic = BdUniqueId.gen();
    public static final BdUniqueId aii = BdUniqueId.gen();
    public static final BdUniqueId czE = BdUniqueId.gen();
    public boolean czF = false;
    public boolean isLinkThread = false;
    public boolean czG = false;
    public boolean aNy = true;

    public static boolean P(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return bcVar.getType() == bc.aib || bcVar.getType() == bc.aid || bcVar.getType() == bc.aic || bcVar.getType() == bc.aii || bcVar.getType() == bc.aik;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.czF) {
            return czD;
        }
        if (this.isLinkThread) {
            return aic;
        }
        if (this.threadData.isShareThread) {
            return aii;
        }
        if (this.threadData.getType() == bc.aik) {
            return czE;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bc SV() {
        if (this.threadData == null) {
            return this.threadData;
        }
        if (this.threadData.vl() == 5) {
            return this.threadData;
        }
        this.threadData.setResource(1);
        return this.threadData;
    }

    public boolean aiT() {
        return (this.threadData == null || w.z(this.threadData.vK()) == 0) ? false : true;
    }

    public an aiU() {
        bc SV;
        if (this.czF) {
            an anVar = new an("c11003");
            if (SV() != null && (SV = SV()) != null) {
                anVar.ah("tid", SV.getTid());
                if (SV.vw() != null) {
                    anVar.r("ab_type", SV.vw().hadConcerned() ? 1 : 0);
                }
            }
            return anVar;
        } else if (aiT()) {
            an ld = ld(czx);
            if (ld != null && SV() != null) {
                bc SV2 = SV();
                ld.r("obj_name", SV2.wI() != null && (SV2.wI().bxE() != null || SV2.wI().NH() != null) ? 1 : 0);
                if (SV2.vw() != null) {
                    ld.r("ab_type", SV2.vw().hadConcerned() ? 1 : 0);
                }
            }
            return ld;
        } else {
            an ld2 = ld(czs);
            if (ld2 != null) {
                ld2.ah("ab_tag", aiL()).ah("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
                if (SV() != null) {
                    bc SV3 = SV();
                    boolean z = (SV3.wI() == null || (SV3.wI().bxE() == null && SV3.wI().NH() == null)) ? false : true;
                    ld2.r("obj_name", z ? 1 : 0);
                    if (z && SV3.wI().bxE() != null && SV3.wI().bxE().Nz() != null && SV3.wI().bxE().Nz().size() > 0) {
                        ld2.r("obj_to", SV3.wI().gNB ? 2 : 1);
                    }
                    if (SV3.vw() != null) {
                        ld2.r("ab_type", SV3.vw().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return ld2;
        }
    }

    public an lf(String str) {
        int i;
        an anVar = new an(str);
        if (anVar != null && this.threadData != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            anVar.ah("tid", this.threadData.getTid());
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else {
                i = this.threadData.isShareThread ? 5 : 1;
            }
            anVar.r("obj_type", i);
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.threadData.vw().getUserId());
            anVar.r("obj_param1", aiP() ? 2 : 1);
        }
        return anVar;
    }

    public an lg(String str) {
        an ld = ld(str);
        if (ld != null) {
            ld.ah("ab_tag", aiL()).ah("ab_action", SmsLoginView.StatEvent.LOGIN_SHOW);
            if (SV() != null) {
                bc SV = SV();
                boolean z = (SV.wI() == null || (SV.wI().bxE() == null && SV.wI().NH() == null)) ? false : true;
                ld.r("obj_name", z ? 1 : 0);
                if (z && SV.wI().bxE() != null && SV.wI().bxE().Nz() != null && SV.wI().bxE().Nz().size() > 0) {
                    ld.r("obj_to", SV.wI().gNB ? 2 : 1);
                }
            }
        }
        return ld;
    }

    public an lh(String str) {
        an ld = ld(str);
        if (ld != null) {
            ld.ah("ab_tag", aiL()).ah("ab_action", "click");
        }
        return ld;
    }

    public an aiV() {
        if (aiT()) {
            return ld(czy);
        }
        an ld = ld(czt);
        if (ld != null) {
            ld.ah("ab_tag", aiL()).ah("ab_action", "click");
            return ld;
        }
        return ld;
    }

    public an aiW() {
        if (aiT()) {
            return ld(czz);
        }
        an U = U(czu, 0);
        if (U != null) {
            U.ah("ab_tag", aiL()).ah("ab_action", "click");
            return U;
        }
        return U;
    }

    public an aiX() {
        if (aiT()) {
            return ld(czA);
        }
        an ld = ld(czv);
        if (ld != null) {
            ld.ah("ab_tag", aiL()).ah("ab_action", "click");
            return ld;
        }
        return ld;
    }

    public an aiY() {
        if (aiT()) {
            return ld(czB);
        }
        an ld = ld(czw);
        if (ld != null) {
            ld.ah("ab_tag", aiL()).ah("ab_action", "click");
            return ld;
        }
        return ld;
    }

    public an aiZ() {
        return ld(czC);
    }

    public an li(String str) {
        return ld(str);
    }

    public an lj(String str) {
        an ld = ld(str);
        if (this.threadData != null && this.threadData.vw() != null) {
            ld.r("ab_type", this.threadData.vw().hadConcerned() ? 1 : 0);
        }
        return ld;
    }

    public an lk(String str) {
        return ld(str);
    }
}
