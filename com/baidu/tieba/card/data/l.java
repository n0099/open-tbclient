package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bh blk;
    public static String bUL = "";
    public static String bUM = "";
    public static String bUN = "";
    public static String bUO = "";
    public static String bUP = "";
    public static String bUQ = "";
    public static String bUR = "";
    public static String bUS = "";
    public static String bUT = "";
    public static String bUU = "";
    public static String bUV = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bUW = BdUniqueId.gen();
    public static final BdUniqueId Yp = BdUniqueId.gen();
    public boolean bUX = false;
    public boolean isLinkThread = false;
    public boolean bUY = false;
    public boolean aCw = true;

    public static boolean A(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.Yo || bhVar.getType() == bh.Yq || bhVar.getType() == bh.Yp;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.blk == null) {
            return TYPE;
        }
        if (this.bUX) {
            return bUW;
        }
        if (this.isLinkThread) {
            return Yp;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Np() {
        return this.blk;
    }

    public boolean aai() {
        return (this.blk == null || v.u(this.blk.rI()) == 0) ? false : true;
    }

    public ak aaj() {
        if (aai()) {
            ak jP = jP(bUQ);
            if (jP != null && Np() != null) {
                bh Np = Np();
                jP.r("obj_name", Np.sL() != null && (Np.sL().aEt() != null || Np.sL().IQ() != null) ? 1 : 0);
            }
            return jP;
        }
        ak jP2 = jP(bUL);
        if (jP2 != null) {
            jP2.ac("ab_tag", aac()).ac("ab_action", "show");
            if (Np() != null) {
                bh Np2 = Np();
                boolean z = (Np2.sL() == null || (Np2.sL().aEt() == null && Np2.sL().IQ() == null)) ? false : true;
                jP2.r("obj_name", z ? 1 : 0);
                if (z && Np2.sL().aEt() != null && Np2.sL().aEt().II() != null && Np2.sL().aEt().II().size() > 0) {
                    jP2.r("obj_to", Np2.sL().gpQ ? 2 : 1);
                }
            }
        }
        return jP2;
    }

    public ak jR(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.blk != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.blk.getFid());
            akVar.ac("tid", this.blk.getTid());
            akVar.r("obj_type", this.blk.isLinkThread() ? 4 : 1);
            akVar.ac("obj_id", this.blk.rt().getUserId());
        }
        return akVar;
    }

    public ak jS(String str) {
        ak jP = jP(str);
        if (jP != null) {
            jP.ac("ab_tag", aac()).ac("ab_action", "show");
            if (Np() != null) {
                bh Np = Np();
                boolean z = (Np.sL() == null || (Np.sL().aEt() == null && Np.sL().IQ() == null)) ? false : true;
                jP.r("obj_name", z ? 1 : 0);
                if (z && Np.sL().aEt() != null && Np.sL().aEt().II() != null && Np.sL().aEt().II().size() > 0) {
                    jP.r("obj_to", Np.sL().gpQ ? 2 : 1);
                }
            }
        }
        return jP;
    }

    public ak jT(String str) {
        ak jP = jP(str);
        if (jP != null) {
            jP.ac("ab_tag", aac()).ac("ab_action", "click");
        }
        return jP;
    }

    public ak aak() {
        if (aai()) {
            return jP(bUR);
        }
        ak jP = jP(bUM);
        if (jP != null) {
            jP.ac("ab_tag", aac()).ac("ab_action", "click");
            return jP;
        }
        return jP;
    }

    public ak aal() {
        if (aai()) {
            return jP(bUS);
        }
        ak P = P(bUN, 0);
        if (P != null) {
            P.ac("ab_tag", aac()).ac("ab_action", "click");
            return P;
        }
        return P;
    }

    public ak aam() {
        if (aai()) {
            return jP(bUT);
        }
        ak jP = jP(bUO);
        if (jP != null) {
            jP.ac("ab_tag", aac()).ac("ab_action", "click");
            return jP;
        }
        return jP;
    }

    public ak aan() {
        if (aai()) {
            return jP(bUU);
        }
        ak jP = jP(bUP);
        if (jP != null) {
            jP.ac("ab_tag", aac()).ac("ab_action", "click");
            return jP;
        }
        return jP;
    }

    public ak aao() {
        return jP(bUV);
    }

    public ak jU(String str) {
        return jP(str);
    }
}
