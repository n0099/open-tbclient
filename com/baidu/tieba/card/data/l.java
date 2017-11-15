package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bh blt;
    public static String bUY = "";
    public static String bUZ = "";
    public static String bVa = "";
    public static String bVb = "";
    public static String bVc = "";
    public static String bVd = "";
    public static String bVe = "";
    public static String bVf = "";
    public static String bVg = "";
    public static String bVh = "";
    public static String bVi = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bVj = BdUniqueId.gen();
    public static final BdUniqueId Yp = BdUniqueId.gen();
    public boolean bVk = false;
    public boolean isLinkThread = false;
    public boolean bVl = false;
    public boolean aCE = true;

    public static boolean A(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.Yo || bhVar.getType() == bh.Yq || bhVar.getType() == bh.Yp;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.blt == null) {
            return TYPE;
        }
        if (this.bVk) {
            return bVj;
        }
        if (this.isLinkThread) {
            return Yp;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh NA() {
        return this.blt;
    }

    public boolean aau() {
        return (this.blt == null || v.u(this.blt.rI()) == 0) ? false : true;
    }

    public ak aav() {
        if (aau()) {
            ak jQ = jQ(bVd);
            if (jQ != null && NA() != null) {
                bh NA = NA();
                jQ.r("obj_name", NA.sL() != null && (NA.sL().aEx() != null || NA.sL().Jb() != null) ? 1 : 0);
            }
            return jQ;
        }
        ak jQ2 = jQ(bUY);
        if (jQ2 != null) {
            jQ2.ac("ab_tag", aao()).ac("ab_action", "show");
            if (NA() != null) {
                bh NA2 = NA();
                boolean z = (NA2.sL() == null || (NA2.sL().aEx() == null && NA2.sL().Jb() == null)) ? false : true;
                jQ2.r("obj_name", z ? 1 : 0);
                if (z && NA2.sL().aEx() != null && NA2.sL().aEx().IT() != null && NA2.sL().aEx().IT().size() > 0) {
                    jQ2.r("obj_to", NA2.sL().gqT ? 2 : 1);
                }
            }
        }
        return jQ2;
    }

    public ak jS(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.blt != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.blt.getFid());
            akVar.ac("tid", this.blt.getTid());
            akVar.r("obj_type", this.blt.isLinkThread() ? 4 : 1);
            akVar.ac("obj_id", this.blt.rt().getUserId());
        }
        return akVar;
    }

    public ak jT(String str) {
        ak jQ = jQ(str);
        if (jQ != null) {
            jQ.ac("ab_tag", aao()).ac("ab_action", "show");
            if (NA() != null) {
                bh NA = NA();
                boolean z = (NA.sL() == null || (NA.sL().aEx() == null && NA.sL().Jb() == null)) ? false : true;
                jQ.r("obj_name", z ? 1 : 0);
                if (z && NA.sL().aEx() != null && NA.sL().aEx().IT() != null && NA.sL().aEx().IT().size() > 0) {
                    jQ.r("obj_to", NA.sL().gqT ? 2 : 1);
                }
            }
        }
        return jQ;
    }

    public ak jU(String str) {
        ak jQ = jQ(str);
        if (jQ != null) {
            jQ.ac("ab_tag", aao()).ac("ab_action", "click");
        }
        return jQ;
    }

    public ak aaw() {
        if (aau()) {
            return jQ(bVe);
        }
        ak jQ = jQ(bUZ);
        if (jQ != null) {
            jQ.ac("ab_tag", aao()).ac("ab_action", "click");
            return jQ;
        }
        return jQ;
    }

    public ak aax() {
        if (aau()) {
            return jQ(bVf);
        }
        ak P = P(bVa, 0);
        if (P != null) {
            P.ac("ab_tag", aao()).ac("ab_action", "click");
            return P;
        }
        return P;
    }

    public ak aay() {
        if (aau()) {
            return jQ(bVg);
        }
        ak jQ = jQ(bVb);
        if (jQ != null) {
            jQ.ac("ab_tag", aao()).ac("ab_action", "click");
            return jQ;
        }
        return jQ;
    }

    public ak aaz() {
        if (aau()) {
            return jQ(bVh);
        }
        ak jQ = jQ(bVc);
        if (jQ != null) {
            jQ.ac("ab_tag", aao()).ac("ab_action", "click");
            return jQ;
        }
        return jQ;
    }

    public ak aaA() {
        return jQ(bVi);
    }

    public ak jV(String str) {
        return jQ(str);
    }
}
