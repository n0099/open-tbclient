package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bd threadData;
    public static String cdK = "";
    public static String cdL = "";
    public static String cdM = "";
    public static String cdN = "";
    public static String cdO = "";
    public static String cdP = "";
    public static String cdQ = "";
    public static String cdR = "";
    public static String cdS = "";
    public static String cdT = "";
    public static String cdU = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cdV = BdUniqueId.gen();
    public static final BdUniqueId YE = BdUniqueId.gen();
    public static final BdUniqueId YK = BdUniqueId.gen();
    public boolean cdW = false;
    public boolean isLinkThread = false;
    public boolean cdX = false;
    public boolean aDp = true;

    public static boolean F(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.YD || bdVar.getType() == bd.YF || bdVar.getType() == bd.YE || bdVar.getType() == bd.YK;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cdW) {
            return cdV;
        }
        if (this.isLinkThread) {
            return YE;
        }
        if (this.threadData.isShareThread) {
            return YK;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.threadData;
    }

    public boolean acm() {
        return (this.threadData == null || v.v(this.threadData.rK()) == 0) ? false : true;
    }

    public ak acn() {
        bd Ox;
        if (this.cdW) {
            ak akVar = new ak("c11003");
            if (Ox() != null && (Ox = Ox()) != null) {
                akVar.ac("tid", Ox.getTid());
                if (Ox.rv() != null) {
                    akVar.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (acm()) {
            ak jU = jU(cdP);
            if (jU != null && Ox() != null) {
                bd Ox2 = Ox();
                jU.r("obj_name", Ox2.sM() != null && (Ox2.sM().bwY() != null || Ox2.sM().Jz() != null) ? 1 : 0);
                if (Ox2.rv() != null) {
                    jU.r("ab_type", Ox2.rv().hadConcerned() ? 1 : 0);
                }
            }
            return jU;
        } else {
            ak jU2 = jU(cdK);
            if (jU2 != null) {
                jU2.ac("ab_tag", acg()).ac("ab_action", "show");
                if (Ox() != null) {
                    bd Ox3 = Ox();
                    boolean z = (Ox3.sM() == null || (Ox3.sM().bwY() == null && Ox3.sM().Jz() == null)) ? false : true;
                    jU2.r("obj_name", z ? 1 : 0);
                    if (z && Ox3.sM().bwY() != null && Ox3.sM().bwY().Jr() != null && Ox3.sM().bwY().Jr().size() > 0) {
                        jU2.r("obj_to", Ox3.sM().gCA ? 2 : 1);
                    }
                    if (Ox3.rv() != null) {
                        jU2.r("ab_type", Ox3.rv().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return jU2;
        }
    }

    public ak jW(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            akVar.ac("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            akVar.r("obj_type", i);
            akVar.ac("obj_id", this.threadData.rv().getUserId());
        }
        return akVar;
    }

    public ak jX(String str) {
        ak jU = jU(str);
        if (jU != null) {
            jU.ac("ab_tag", acg()).ac("ab_action", "show");
            if (Ox() != null) {
                bd Ox = Ox();
                boolean z = (Ox.sM() == null || (Ox.sM().bwY() == null && Ox.sM().Jz() == null)) ? false : true;
                jU.r("obj_name", z ? 1 : 0);
                if (z && Ox.sM().bwY() != null && Ox.sM().bwY().Jr() != null && Ox.sM().bwY().Jr().size() > 0) {
                    jU.r("obj_to", Ox.sM().gCA ? 2 : 1);
                }
            }
        }
        return jU;
    }

    public ak jY(String str) {
        ak jU = jU(str);
        if (jU != null) {
            jU.ac("ab_tag", acg()).ac("ab_action", "click");
        }
        return jU;
    }

    public ak aco() {
        if (acm()) {
            return jU(cdQ);
        }
        ak jU = jU(cdL);
        if (jU != null) {
            jU.ac("ab_tag", acg()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak acp() {
        if (acm()) {
            return jU(cdR);
        }
        ak S = S(cdM, 0);
        if (S != null) {
            S.ac("ab_tag", acg()).ac("ab_action", "click");
            return S;
        }
        return S;
    }

    public ak acq() {
        if (acm()) {
            return jU(cdS);
        }
        ak jU = jU(cdN);
        if (jU != null) {
            jU.ac("ab_tag", acg()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak acr() {
        if (acm()) {
            return jU(cdT);
        }
        ak jU = jU(cdO);
        if (jU != null) {
            jU.ac("ab_tag", acg()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak acs() {
        return jU(cdU);
    }

    public ak jZ(String str) {
        return jU(str);
    }

    public ak ka(String str) {
        ak jU = jU(str);
        if (this.threadData != null && this.threadData.rv() != null) {
            jU.r("ab_type", this.threadData.rv().hadConcerned() ? 1 : 0);
        }
        return jU;
    }

    public ak kb(String str) {
        return jU(str);
    }
}
