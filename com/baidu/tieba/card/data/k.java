package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class k extends c {
    public bd threadData;
    public static String cZP = "";
    public static String cZQ = "";
    public static String cZR = "";
    public static String cZS = "";
    public static String cZT = "";
    public static String cZU = "";
    public static String cZV = "";
    public static String cZW = "";
    public static String cZX = "";
    public static String cZY = "";
    public static String cZZ = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId daa = BdUniqueId.gen();
    public static final BdUniqueId aOl = BdUniqueId.gen();
    public static final BdUniqueId aOr = BdUniqueId.gen();
    public boolean dab = false;
    public boolean isLinkThread = false;
    public boolean dac = false;
    public boolean btG = true;

    public static boolean M(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.aOk || bdVar.getType() == bd.aOm || bdVar.getType() == bd.aOl || bdVar.getType() == bd.aOr;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.dab) {
            return daa;
        }
        if (this.isLinkThread) {
            return aOl;
        }
        if (this.threadData.isShareThread) {
            return aOr;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WE() {
        return this.threadData;
    }

    public boolean alJ() {
        return (this.threadData == null || v.D(this.threadData.zC()) == 0) ? false : true;
    }

    public ak alK() {
        bd WE;
        if (this.dab) {
            ak akVar = new ak("c11003");
            if (WE() != null && (WE = WE()) != null) {
                akVar.ab("tid", WE.getTid());
                if (WE.zn() != null) {
                    akVar.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (alJ()) {
            ak kx = kx(cZU);
            if (kx != null && WE() != null) {
                bd WE2 = WE();
                kx.s("obj_name", WE2.AA() != null && (WE2.AA().bxb() != null || WE2.AA().Rq() != null) ? 1 : 0);
                if (WE2.zn() != null) {
                    kx.s("ab_type", WE2.zn().hadConcerned() ? 1 : 0);
                }
            }
            return kx;
        } else {
            ak kx2 = kx(cZP);
            if (kx2 != null) {
                kx2.ab("ab_tag", alD()).ab("ab_action", "show");
                if (WE() != null) {
                    bd WE3 = WE();
                    boolean z = (WE3.AA() == null || (WE3.AA().bxb() == null && WE3.AA().Rq() == null)) ? false : true;
                    kx2.s("obj_name", z ? 1 : 0);
                    if (z && WE3.AA().bxb() != null && WE3.AA().bxb().Ri() != null && WE3.AA().bxb().Ri().size() > 0) {
                        kx2.s("obj_to", WE3.AA().hbE ? 2 : 1);
                    }
                    if (WE3.zn() != null) {
                        kx2.s("ab_type", WE3.zn().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return kx2;
        }
    }

    public ak kz(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            akVar.ab("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            akVar.s("obj_type", i);
            akVar.ab("obj_id", this.threadData.zn().getUserId());
        }
        return akVar;
    }

    public ak kA(String str) {
        ak kx = kx(str);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "show");
            if (WE() != null) {
                bd WE = WE();
                boolean z = (WE.AA() == null || (WE.AA().bxb() == null && WE.AA().Rq() == null)) ? false : true;
                kx.s("obj_name", z ? 1 : 0);
                if (z && WE.AA().bxb() != null && WE.AA().bxb().Ri() != null && WE.AA().bxb().Ri().size() > 0) {
                    kx.s("obj_to", WE.AA().hbE ? 2 : 1);
                }
            }
        }
        return kx;
    }

    public ak kB(String str) {
        ak kx = kx(str);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
        }
        return kx;
    }

    public ak alL() {
        if (alJ()) {
            return kx(cZV);
        }
        ak kx = kx(cZQ);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alM() {
        if (alJ()) {
            return kx(cZW);
        }
        ak U = U(cZR, 0);
        if (U != null) {
            U.ab("ab_tag", alD()).ab("ab_action", "click");
            return U;
        }
        return U;
    }

    public ak alN() {
        if (alJ()) {
            return kx(cZX);
        }
        ak kx = kx(cZS);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alO() {
        if (alJ()) {
            return kx(cZY);
        }
        ak kx = kx(cZT);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alP() {
        return kx(cZZ);
    }

    public ak kC(String str) {
        return kx(str);
    }

    public ak kD(String str) {
        ak kx = kx(str);
        if (this.threadData != null && this.threadData.zn() != null) {
            kx.s("ab_type", this.threadData.zn().hadConcerned() ? 1 : 0);
        }
        return kx;
    }

    public ak kE(String str) {
        return kx(str);
    }
}
