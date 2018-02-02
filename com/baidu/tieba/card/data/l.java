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
            ak kq = kq(cXq);
            if (kq != null && VM() != null) {
                bd VM2 = VM();
                kq.s("obj_name", VM2.Ah() != null && (VM2.Ah().bvM() != null || VM2.Ah().QL() != null) ? 1 : 0);
                if (VM2.yT() != null) {
                    kq.s("ab_type", VM2.yT().hadConcerned() ? 1 : 0);
                }
            }
            return kq;
        } else {
            ak kq2 = kq(cXl);
            if (kq2 != null) {
                kq2.aa("ab_tag", akU()).aa("ab_action", "show");
                if (VM() != null) {
                    bd VM3 = VM();
                    boolean z = (VM3.Ah() == null || (VM3.Ah().bvM() == null && VM3.Ah().QL() == null)) ? false : true;
                    kq2.s("obj_name", z ? 1 : 0);
                    if (z && VM3.Ah().bvM() != null && VM3.Ah().bvM().QD() != null && VM3.Ah().bvM().QD().size() > 0) {
                        kq2.s("obj_to", VM3.Ah().gZh ? 2 : 1);
                    }
                    if (VM3.yT() != null) {
                        kq2.s("ab_type", VM3.yT().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return kq2;
        }
    }

    public ak ks(String str) {
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

    public ak kt(String str) {
        ak kq = kq(str);
        if (kq != null) {
            kq.aa("ab_tag", akU()).aa("ab_action", "show");
            if (VM() != null) {
                bd VM = VM();
                boolean z = (VM.Ah() == null || (VM.Ah().bvM() == null && VM.Ah().QL() == null)) ? false : true;
                kq.s("obj_name", z ? 1 : 0);
                if (z && VM.Ah().bvM() != null && VM.Ah().bvM().QD() != null && VM.Ah().bvM().QD().size() > 0) {
                    kq.s("obj_to", VM.Ah().gZh ? 2 : 1);
                }
            }
        }
        return kq;
    }

    public ak ku(String str) {
        ak kq = kq(str);
        if (kq != null) {
            kq.aa("ab_tag", akU()).aa("ab_action", "click");
        }
        return kq;
    }

    public ak alc() {
        if (ala()) {
            return kq(cXr);
        }
        ak kq = kq(cXm);
        if (kq != null) {
            kq.aa("ab_tag", akU()).aa("ab_action", "click");
            return kq;
        }
        return kq;
    }

    public ak ald() {
        if (ala()) {
            return kq(cXs);
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
            return kq(cXt);
        }
        ak kq = kq(cXo);
        if (kq != null) {
            kq.aa("ab_tag", akU()).aa("ab_action", "click");
            return kq;
        }
        return kq;
    }

    public ak alf() {
        if (ala()) {
            return kq(cXu);
        }
        ak kq = kq(cXp);
        if (kq != null) {
            kq.aa("ab_tag", akU()).aa("ab_action", "click");
            return kq;
        }
        return kq;
    }

    public ak alg() {
        return kq(cXv);
    }

    public ak kv(String str) {
        return kq(str);
    }

    public ak kw(String str) {
        ak kq = kq(str);
        if (this.threadData != null && this.threadData.yT() != null) {
            kq.s("ab_type", this.threadData.yT().hadConcerned() ? 1 : 0);
        }
        return kq;
    }

    public ak kx(String str) {
        return kq(str);
    }
}
