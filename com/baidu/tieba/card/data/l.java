package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bd threadData;
    public static String cXl = "";
    public static String cXm = "";
    public static String cXn = "";
    public static String cXo = "";
    public static String cXp = "";
    public static String cXq = "";
    public static String cXr = "";
    public static String cXs = "";
    public static String cXt = "";
    public static String cXu = "";
    public static String cXv = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cXw = BdUniqueId.gen();
    public static final BdUniqueId aNc = BdUniqueId.gen();
    public static final BdUniqueId aNi = BdUniqueId.gen();
    public boolean cXx = false;
    public boolean isLinkThread = false;
    public boolean cXy = false;
    public boolean brC = true;

    public static boolean J(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.aNb || bdVar.getType() == bd.aNd || bdVar.getType() == bd.aNc || bdVar.getType() == bd.aNi;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cXx) {
            return cXw;
        }
        if (this.isLinkThread) {
            return aNc;
        }
        if (this.threadData.isShareThread) {
            return aNi;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VM() {
        return this.threadData;
    }

    public boolean ala() {
        return (this.threadData == null || v.D(this.threadData.zi()) == 0) ? false : true;
    }

    public ak alb() {
        bd VM;
        if (this.cXx) {
            ak akVar = new ak("c11003");
            if (VM() != null && (VM = VM()) != null) {
                akVar.aa("tid", VM.getTid());
                if (VM.yT() != null) {
                    akVar.s("ab_type", VM.yT().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (ala()) {
            ak kp = kp(cXq);
            if (kp != null && VM() != null) {
                bd VM2 = VM();
                kp.s("obj_name", VM2.Ah() != null && (VM2.Ah().bvM() != null || VM2.Ah().QL() != null) ? 1 : 0);
                if (VM2.yT() != null) {
                    kp.s("ab_type", VM2.yT().hadConcerned() ? 1 : 0);
                }
            }
            return kp;
        } else {
            ak kp2 = kp(cXl);
            if (kp2 != null) {
                kp2.aa("ab_tag", akU()).aa("ab_action", "show");
                if (VM() != null) {
                    bd VM3 = VM();
                    boolean z = (VM3.Ah() == null || (VM3.Ah().bvM() == null && VM3.Ah().QL() == null)) ? false : true;
                    kp2.s("obj_name", z ? 1 : 0);
                    if (z && VM3.Ah().bvM() != null && VM3.Ah().bvM().QD() != null && VM3.Ah().bvM().QD().size() > 0) {
                        kp2.s("obj_to", VM3.Ah().gZh ? 2 : 1);
                    }
                    if (VM3.yT() != null) {
                        kp2.s("ab_type", VM3.yT().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return kp2;
        }
    }

    public ak kr(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            akVar.aa("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            akVar.s("obj_type", i);
            akVar.aa("obj_id", this.threadData.yT().getUserId());
        }
        return akVar;
    }

    public ak ks(String str) {
        ak kp = kp(str);
        if (kp != null) {
            kp.aa("ab_tag", akU()).aa("ab_action", "show");
            if (VM() != null) {
                bd VM = VM();
                boolean z = (VM.Ah() == null || (VM.Ah().bvM() == null && VM.Ah().QL() == null)) ? false : true;
                kp.s("obj_name", z ? 1 : 0);
                if (z && VM.Ah().bvM() != null && VM.Ah().bvM().QD() != null && VM.Ah().bvM().QD().size() > 0) {
                    kp.s("obj_to", VM.Ah().gZh ? 2 : 1);
                }
            }
        }
        return kp;
    }

    public ak kt(String str) {
        ak kp = kp(str);
        if (kp != null) {
            kp.aa("ab_tag", akU()).aa("ab_action", "click");
        }
        return kp;
    }

    public ak alc() {
        if (ala()) {
            return kp(cXr);
        }
        ak kp = kp(cXm);
        if (kp != null) {
            kp.aa("ab_tag", akU()).aa("ab_action", "click");
            return kp;
        }
        return kp;
    }

    public ak ald() {
        if (ala()) {
            return kp(cXs);
        }
        ak W = W(cXn, 0);
        if (W != null) {
            W.aa("ab_tag", akU()).aa("ab_action", "click");
            return W;
        }
        return W;
    }

    public ak ale() {
        if (ala()) {
            return kp(cXt);
        }
        ak kp = kp(cXo);
        if (kp != null) {
            kp.aa("ab_tag", akU()).aa("ab_action", "click");
            return kp;
        }
        return kp;
    }

    public ak alf() {
        if (ala()) {
            return kp(cXu);
        }
        ak kp = kp(cXp);
        if (kp != null) {
            kp.aa("ab_tag", akU()).aa("ab_action", "click");
            return kp;
        }
        return kp;
    }

    public ak alg() {
        return kp(cXv);
    }

    public ak ku(String str) {
        return kp(str);
    }

    public ak kv(String str) {
        ak kp = kp(str);
        if (this.threadData != null && this.threadData.yT() != null) {
            kp.s("ab_type", this.threadData.yT().hadConcerned() ? 1 : 0);
        }
        return kp;
    }

    public ak kw(String str) {
        return kp(str);
    }
}
