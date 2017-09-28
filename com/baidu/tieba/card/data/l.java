package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bh threadData;
    public static String bNt = "";
    public static String bNu = "";
    public static String bNv = "";
    public static String bNw = "";
    public static String bNx = "";
    public static String bNy = "";
    public static String bNz = "";
    public static String bNA = "";
    public static String bNB = "";
    public static String bNC = "";
    public static String bND = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bNE = BdUniqueId.gen();
    public static final BdUniqueId Yj = BdUniqueId.gen();
    public boolean bNF = false;
    public boolean isLinkThread = false;
    public boolean bNG = false;
    public boolean aCa = true;

    public static boolean A(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.Yi || bhVar.getType() == bh.Yk || bhVar.getType() == bh.Yj;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bNF) {
            return bNE;
        }
        if (this.isLinkThread) {
            return Yj;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nj() {
        return this.threadData;
    }

    public boolean Yc() {
        return (this.threadData == null || v.t(this.threadData.rJ()) == 0) ? false : true;
    }

    public ak Yd() {
        if (Yc()) {
            ak jt = jt(bNy);
            if (jt != null && Nj() != null) {
                bh Nj = Nj();
                jt.r("obj_name", Nj.sL() != null && (Nj.sL().aCd() != null || Nj.sL().IL() != null) ? 1 : 0);
            }
            return jt;
        }
        ak jt2 = jt(bNt);
        if (jt2 != null) {
            jt2.ad("ab_tag", XW()).ad("ab_action", "show");
            if (Nj() != null) {
                bh Nj2 = Nj();
                boolean z = (Nj2.sL() == null || (Nj2.sL().aCd() == null && Nj2.sL().IL() == null)) ? false : true;
                jt2.r("obj_name", z ? 1 : 0);
                if (z && Nj2.sL().aCd() != null && Nj2.sL().aCd().ID() != null && Nj2.sL().aCd().ID().size() > 0) {
                    jt2.r("obj_to", Nj2.sL().ghu ? 2 : 1);
                }
            }
        }
        return jt2;
    }

    public ak jv(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f("fid", this.threadData.getFid());
            akVar.ad("tid", this.threadData.getTid());
            akVar.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
            akVar.ad("obj_id", this.threadData.getAuthor().getUserId());
        }
        return akVar;
    }

    public ak jw(String str) {
        ak jt = jt(str);
        if (jt != null) {
            jt.ad("ab_tag", XW()).ad("ab_action", "show");
            if (Nj() != null) {
                bh Nj = Nj();
                boolean z = (Nj.sL() == null || (Nj.sL().aCd() == null && Nj.sL().IL() == null)) ? false : true;
                jt.r("obj_name", z ? 1 : 0);
                if (z && Nj.sL().aCd() != null && Nj.sL().aCd().ID() != null && Nj.sL().aCd().ID().size() > 0) {
                    jt.r("obj_to", Nj.sL().ghu ? 2 : 1);
                }
            }
        }
        return jt;
    }

    public ak jx(String str) {
        ak jt = jt(str);
        if (jt != null) {
            jt.ad("ab_tag", XW()).ad("ab_action", "click");
        }
        return jt;
    }

    public ak Ye() {
        if (Yc()) {
            return jt(bNz);
        }
        ak jt = jt(bNu);
        if (jt != null) {
            jt.ad("ab_tag", XW()).ad("ab_action", "click");
            return jt;
        }
        return jt;
    }

    public ak Yf() {
        if (Yc()) {
            return jt(bNA);
        }
        ak J = J(bNv, 0);
        if (J != null) {
            J.ad("ab_tag", XW()).ad("ab_action", "click");
            return J;
        }
        return J;
    }

    public ak Yg() {
        if (Yc()) {
            return jt(bNB);
        }
        ak jt = jt(bNw);
        if (jt != null) {
            jt.ad("ab_tag", XW()).ad("ab_action", "click");
            return jt;
        }
        return jt;
    }

    public ak Yh() {
        if (Yc()) {
            return jt(bNC);
        }
        ak jt = jt(bNx);
        if (jt != null) {
            jt.ad("ab_tag", XW()).ad("ab_action", "click");
            return jt;
        }
        return jt;
    }

    public ak Yi() {
        return jt(bND);
    }

    public ak jy(String str) {
        return jt(str);
    }
}
