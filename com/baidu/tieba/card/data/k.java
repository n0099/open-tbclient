package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class k extends c {
    public bd threadData;
    public static String cZY = "";
    public static String cZZ = "";
    public static String daa = "";
    public static String dab = "";
    public static String dac = "";
    public static String dad = "";
    public static String dae = "";
    public static String daf = "";
    public static String dag = "";
    public static String dah = "";
    public static String dai = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId daj = BdUniqueId.gen();
    public static final BdUniqueId aOv = BdUniqueId.gen();
    public static final BdUniqueId aOB = BdUniqueId.gen();
    public boolean dak = false;
    public boolean isLinkThread = false;
    public boolean dal = false;
    public boolean btQ = true;

    public static boolean M(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.aOu || bdVar.getType() == bd.aOw || bdVar.getType() == bd.aOv || bdVar.getType() == bd.aOB;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.dak) {
            return daj;
        }
        if (this.isLinkThread) {
            return aOv;
        }
        if (this.threadData.isShareThread) {
            return aOB;
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
        if (this.dak) {
            ak akVar = new ak("c11003");
            if (WE() != null && (WE = WE()) != null) {
                akVar.ab("tid", WE.getTid());
                if (WE.zn() != null) {
                    akVar.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (alJ()) {
            ak kx = kx(dad);
            if (kx != null && WE() != null) {
                bd WE2 = WE();
                kx.s("obj_name", WE2.AA() != null && (WE2.AA().bwX() != null || WE2.AA().Rq() != null) ? 1 : 0);
                if (WE2.zn() != null) {
                    kx.s("ab_type", WE2.zn().hadConcerned() ? 1 : 0);
                }
            }
            return kx;
        } else {
            ak kx2 = kx(cZY);
            if (kx2 != null) {
                kx2.ab("ab_tag", alD()).ab("ab_action", "show");
                if (WE() != null) {
                    bd WE3 = WE();
                    boolean z = (WE3.AA() == null || (WE3.AA().bwX() == null && WE3.AA().Rq() == null)) ? false : true;
                    kx2.s("obj_name", z ? 1 : 0);
                    if (z && WE3.AA().bwX() != null && WE3.AA().bwX().Ri() != null && WE3.AA().bwX().Ri().size() > 0) {
                        kx2.s("obj_to", WE3.AA().hbv ? 2 : 1);
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
                boolean z = (WE.AA() == null || (WE.AA().bwX() == null && WE.AA().Rq() == null)) ? false : true;
                kx.s("obj_name", z ? 1 : 0);
                if (z && WE.AA().bwX() != null && WE.AA().bwX().Ri() != null && WE.AA().bwX().Ri().size() > 0) {
                    kx.s("obj_to", WE.AA().hbv ? 2 : 1);
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
            return kx(dae);
        }
        ak kx = kx(cZZ);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alM() {
        if (alJ()) {
            return kx(daf);
        }
        ak U = U(daa, 0);
        if (U != null) {
            U.ab("ab_tag", alD()).ab("ab_action", "click");
            return U;
        }
        return U;
    }

    public ak alN() {
        if (alJ()) {
            return kx(dag);
        }
        ak kx = kx(dab);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alO() {
        if (alJ()) {
            return kx(dah);
        }
        ak kx = kx(dac);
        if (kx != null) {
            kx.ab("ab_tag", alD()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alP() {
        return kx(dai);
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
