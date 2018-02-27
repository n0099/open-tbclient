package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class k extends c {
    public bd threadData;
    public static String cZM = "";
    public static String cZN = "";
    public static String cZO = "";
    public static String cZP = "";
    public static String cZQ = "";
    public static String cZR = "";
    public static String cZS = "";
    public static String cZT = "";
    public static String cZU = "";
    public static String cZV = "";
    public static String cZW = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cZX = BdUniqueId.gen();
    public static final BdUniqueId aOk = BdUniqueId.gen();
    public static final BdUniqueId aOq = BdUniqueId.gen();
    public boolean cZY = false;
    public boolean isLinkThread = false;
    public boolean cZZ = false;
    public boolean btD = true;

    public static boolean M(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.aOj || bdVar.getType() == bd.aOl || bdVar.getType() == bd.aOk || bdVar.getType() == bd.aOq;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cZY) {
            return cZX;
        }
        if (this.isLinkThread) {
            return aOk;
        }
        if (this.threadData.isShareThread) {
            return aOq;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WD() {
        return this.threadData;
    }

    public boolean alI() {
        return (this.threadData == null || v.D(this.threadData.zC()) == 0) ? false : true;
    }

    public ak alJ() {
        bd WD;
        if (this.cZY) {
            ak akVar = new ak("c11003");
            if (WD() != null && (WD = WD()) != null) {
                akVar.ab("tid", WD.getTid());
                if (WD.zn() != null) {
                    akVar.s("ab_type", WD.zn().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (alI()) {
            ak kx = kx(cZR);
            if (kx != null && WD() != null) {
                bd WD2 = WD();
                kx.s("obj_name", WD2.AA() != null && (WD2.AA().bwW() != null || WD2.AA().Rp() != null) ? 1 : 0);
                if (WD2.zn() != null) {
                    kx.s("ab_type", WD2.zn().hadConcerned() ? 1 : 0);
                }
            }
            return kx;
        } else {
            ak kx2 = kx(cZM);
            if (kx2 != null) {
                kx2.ab("ab_tag", alC()).ab("ab_action", "show");
                if (WD() != null) {
                    bd WD3 = WD();
                    boolean z = (WD3.AA() == null || (WD3.AA().bwW() == null && WD3.AA().Rp() == null)) ? false : true;
                    kx2.s("obj_name", z ? 1 : 0);
                    if (z && WD3.AA().bwW() != null && WD3.AA().bwW().Rh() != null && WD3.AA().bwW().Rh().size() > 0) {
                        kx2.s("obj_to", WD3.AA().hbg ? 2 : 1);
                    }
                    if (WD3.zn() != null) {
                        kx2.s("ab_type", WD3.zn().hadConcerned() ? 1 : 0);
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
            kx.ab("ab_tag", alC()).ab("ab_action", "show");
            if (WD() != null) {
                bd WD = WD();
                boolean z = (WD.AA() == null || (WD.AA().bwW() == null && WD.AA().Rp() == null)) ? false : true;
                kx.s("obj_name", z ? 1 : 0);
                if (z && WD.AA().bwW() != null && WD.AA().bwW().Rh() != null && WD.AA().bwW().Rh().size() > 0) {
                    kx.s("obj_to", WD.AA().hbg ? 2 : 1);
                }
            }
        }
        return kx;
    }

    public ak kB(String str) {
        ak kx = kx(str);
        if (kx != null) {
            kx.ab("ab_tag", alC()).ab("ab_action", "click");
        }
        return kx;
    }

    public ak alK() {
        if (alI()) {
            return kx(cZS);
        }
        ak kx = kx(cZN);
        if (kx != null) {
            kx.ab("ab_tag", alC()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alL() {
        if (alI()) {
            return kx(cZT);
        }
        ak U = U(cZO, 0);
        if (U != null) {
            U.ab("ab_tag", alC()).ab("ab_action", "click");
            return U;
        }
        return U;
    }

    public ak alM() {
        if (alI()) {
            return kx(cZU);
        }
        ak kx = kx(cZP);
        if (kx != null) {
            kx.ab("ab_tag", alC()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alN() {
        if (alI()) {
            return kx(cZV);
        }
        ak kx = kx(cZQ);
        if (kx != null) {
            kx.ab("ab_tag", alC()).ab("ab_action", "click");
            return kx;
        }
        return kx;
    }

    public ak alO() {
        return kx(cZW);
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
