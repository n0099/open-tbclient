package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bd threadData;
    public static String cds = "";
    public static String cdt = "";
    public static String cdu = "";
    public static String cdv = "";
    public static String cdw = "";
    public static String cdx = "";
    public static String cdy = "";
    public static String cdz = "";
    public static String cdA = "";
    public static String cdB = "";
    public static String cdC = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cdD = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    public static final BdUniqueId YN = BdUniqueId.gen();
    public boolean cdE = false;
    public boolean isLinkThread = false;
    public boolean cdF = false;
    public boolean aDh = true;

    public static boolean D(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.YG || bdVar.getType() == bd.YI || bdVar.getType() == bd.YH || bdVar.getType() == bd.YN;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cdE) {
            return cdD;
        }
        if (this.isLinkThread) {
            return YH;
        }
        if (this.threadData.isShareThread) {
            return YN;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.threadData;
    }

    public boolean acd() {
        return (this.threadData == null || v.v(this.threadData.rM()) == 0) ? false : true;
    }

    public ak ace() {
        bd Ox;
        if (this.cdE) {
            ak akVar = new ak("c11003");
            if (Ox() != null && (Ox = Ox()) != null) {
                akVar.ac("tid", Ox.getTid());
                if (Ox.rx() != null) {
                    akVar.r("ab_type", Ox.rx().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (acd()) {
            ak jW = jW(cdx);
            if (jW != null && Ox() != null) {
                bd Ox2 = Ox();
                jW.r("obj_name", Ox2.sO() != null && (Ox2.sO().bwr() != null || Ox2.sO().Jy() != null) ? 1 : 0);
                if (Ox2.rx() != null) {
                    jW.r("ab_type", Ox2.rx().hadConcerned() ? 1 : 0);
                }
            }
            return jW;
        } else {
            ak jW2 = jW(cds);
            if (jW2 != null) {
                jW2.ac("ab_tag", abX()).ac("ab_action", "show");
                if (Ox() != null) {
                    bd Ox3 = Ox();
                    boolean z = (Ox3.sO() == null || (Ox3.sO().bwr() == null && Ox3.sO().Jy() == null)) ? false : true;
                    jW2.r("obj_name", z ? 1 : 0);
                    if (z && Ox3.sO().bwr() != null && Ox3.sO().bwr().Jq() != null && Ox3.sO().bwr().Jq().size() > 0) {
                        jW2.r("obj_to", Ox3.sO().gzM ? 2 : 1);
                    }
                    if (Ox3.rx() != null) {
                        jW2.r("ab_type", Ox3.rx().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return jW2;
        }
    }

    public ak jY(String str) {
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
            akVar.ac("obj_id", this.threadData.rx().getUserId());
        }
        return akVar;
    }

    public ak jZ(String str) {
        ak jW = jW(str);
        if (jW != null) {
            jW.ac("ab_tag", abX()).ac("ab_action", "show");
            if (Ox() != null) {
                bd Ox = Ox();
                boolean z = (Ox.sO() == null || (Ox.sO().bwr() == null && Ox.sO().Jy() == null)) ? false : true;
                jW.r("obj_name", z ? 1 : 0);
                if (z && Ox.sO().bwr() != null && Ox.sO().bwr().Jq() != null && Ox.sO().bwr().Jq().size() > 0) {
                    jW.r("obj_to", Ox.sO().gzM ? 2 : 1);
                }
            }
        }
        return jW;
    }

    public ak ka(String str) {
        ak jW = jW(str);
        if (jW != null) {
            jW.ac("ab_tag", abX()).ac("ab_action", "click");
        }
        return jW;
    }

    public ak acf() {
        if (acd()) {
            return jW(cdy);
        }
        ak jW = jW(cdt);
        if (jW != null) {
            jW.ac("ab_tag", abX()).ac("ab_action", "click");
            return jW;
        }
        return jW;
    }

    public ak acg() {
        if (acd()) {
            return jW(cdz);
        }
        ak R = R(cdu, 0);
        if (R != null) {
            R.ac("ab_tag", abX()).ac("ab_action", "click");
            return R;
        }
        return R;
    }

    public ak ach() {
        if (acd()) {
            return jW(cdA);
        }
        ak jW = jW(cdv);
        if (jW != null) {
            jW.ac("ab_tag", abX()).ac("ab_action", "click");
            return jW;
        }
        return jW;
    }

    public ak aci() {
        if (acd()) {
            return jW(cdB);
        }
        ak jW = jW(cdw);
        if (jW != null) {
            jW.ac("ab_tag", abX()).ac("ab_action", "click");
            return jW;
        }
        return jW;
    }

    public ak acj() {
        return jW(cdC);
    }

    public ak kb(String str) {
        return jW(str);
    }

    public ak kc(String str) {
        ak jW = jW(str);
        if (this.threadData != null && this.threadData.rx() != null) {
            jW.r("ab_type", this.threadData.rx().hadConcerned() ? 1 : 0);
        }
        return jW;
    }

    public ak kd(String str) {
        return jW(str);
    }
}
