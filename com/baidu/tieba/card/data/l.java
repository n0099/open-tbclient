package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bd threadData;
    public static String cdG = "";
    public static String cdH = "";
    public static String cdI = "";
    public static String cdJ = "";
    public static String cdK = "";
    public static String cdL = "";
    public static String cdM = "";
    public static String cdN = "";
    public static String cdO = "";
    public static String cdP = "";
    public static String cdQ = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cdR = BdUniqueId.gen();
    public static final BdUniqueId YB = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    public boolean cdS = false;
    public boolean isLinkThread = false;
    public boolean cdT = false;
    public boolean aDm = true;

    public static boolean F(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.YA || bdVar.getType() == bd.YC || bdVar.getType() == bd.YB || bdVar.getType() == bd.YH;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cdS) {
            return cdR;
        }
        if (this.isLinkThread) {
            return YB;
        }
        if (this.threadData.isShareThread) {
            return YH;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.threadData;
    }

    public boolean acn() {
        return (this.threadData == null || v.v(this.threadData.rK()) == 0) ? false : true;
    }

    public ak aco() {
        bd Ox;
        if (this.cdS) {
            ak akVar = new ak("c11003");
            if (Ox() != null && (Ox = Ox()) != null) {
                akVar.ac("tid", Ox.getTid());
                if (Ox.rv() != null) {
                    akVar.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (acn()) {
            ak jU = jU(cdL);
            if (jU != null && Ox() != null) {
                bd Ox2 = Ox();
                jU.r("obj_name", Ox2.sM() != null && (Ox2.sM().bwY() != null || Ox2.sM().Jz() != null) ? 1 : 0);
                if (Ox2.rv() != null) {
                    jU.r("ab_type", Ox2.rv().hadConcerned() ? 1 : 0);
                }
            }
            return jU;
        } else {
            ak jU2 = jU(cdG);
            if (jU2 != null) {
                jU2.ac("ab_tag", ach()).ac("ab_action", "show");
                if (Ox() != null) {
                    bd Ox3 = Ox();
                    boolean z = (Ox3.sM() == null || (Ox3.sM().bwY() == null && Ox3.sM().Jz() == null)) ? false : true;
                    jU2.r("obj_name", z ? 1 : 0);
                    if (z && Ox3.sM().bwY() != null && Ox3.sM().bwY().Jr() != null && Ox3.sM().bwY().Jr().size() > 0) {
                        jU2.r("obj_to", Ox3.sM().gCv ? 2 : 1);
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
            jU.ac("ab_tag", ach()).ac("ab_action", "show");
            if (Ox() != null) {
                bd Ox = Ox();
                boolean z = (Ox.sM() == null || (Ox.sM().bwY() == null && Ox.sM().Jz() == null)) ? false : true;
                jU.r("obj_name", z ? 1 : 0);
                if (z && Ox.sM().bwY() != null && Ox.sM().bwY().Jr() != null && Ox.sM().bwY().Jr().size() > 0) {
                    jU.r("obj_to", Ox.sM().gCv ? 2 : 1);
                }
            }
        }
        return jU;
    }

    public ak jY(String str) {
        ak jU = jU(str);
        if (jU != null) {
            jU.ac("ab_tag", ach()).ac("ab_action", "click");
        }
        return jU;
    }

    public ak acp() {
        if (acn()) {
            return jU(cdM);
        }
        ak jU = jU(cdH);
        if (jU != null) {
            jU.ac("ab_tag", ach()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak acq() {
        if (acn()) {
            return jU(cdN);
        }
        ak S = S(cdI, 0);
        if (S != null) {
            S.ac("ab_tag", ach()).ac("ab_action", "click");
            return S;
        }
        return S;
    }

    public ak acr() {
        if (acn()) {
            return jU(cdO);
        }
        ak jU = jU(cdJ);
        if (jU != null) {
            jU.ac("ab_tag", ach()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak acs() {
        if (acn()) {
            return jU(cdP);
        }
        ak jU = jU(cdK);
        if (jU != null) {
            jU.ac("ab_tag", ach()).ac("ab_action", "click");
            return jU;
        }
        return jU;
    }

    public ak act() {
        return jU(cdQ);
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
