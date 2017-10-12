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
            ak js = js(bNy);
            if (js != null && Nj() != null) {
                bh Nj = Nj();
                js.r("obj_name", Nj.sL() != null && (Nj.sL().aCd() != null || Nj.sL().IL() != null) ? 1 : 0);
            }
            return js;
        }
        ak js2 = js(bNt);
        if (js2 != null) {
            js2.ad("ab_tag", XW()).ad("ab_action", "show");
            if (Nj() != null) {
                bh Nj2 = Nj();
                boolean z = (Nj2.sL() == null || (Nj2.sL().aCd() == null && Nj2.sL().IL() == null)) ? false : true;
                js2.r("obj_name", z ? 1 : 0);
                if (z && Nj2.sL().aCd() != null && Nj2.sL().aCd().ID() != null && Nj2.sL().aCd().ID().size() > 0) {
                    js2.r("obj_to", Nj2.sL().ght ? 2 : 1);
                }
            }
        }
        return js2;
    }

    public ak ju(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f("fid", this.threadData.getFid());
            akVar.ad("tid", this.threadData.getTid());
            akVar.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
            akVar.ad("obj_id", this.threadData.getAuthor().getUserId());
        }
        return akVar;
    }

    public ak jv(String str) {
        ak js = js(str);
        if (js != null) {
            js.ad("ab_tag", XW()).ad("ab_action", "show");
            if (Nj() != null) {
                bh Nj = Nj();
                boolean z = (Nj.sL() == null || (Nj.sL().aCd() == null && Nj.sL().IL() == null)) ? false : true;
                js.r("obj_name", z ? 1 : 0);
                if (z && Nj.sL().aCd() != null && Nj.sL().aCd().ID() != null && Nj.sL().aCd().ID().size() > 0) {
                    js.r("obj_to", Nj.sL().ght ? 2 : 1);
                }
            }
        }
        return js;
    }

    public ak jw(String str) {
        ak js = js(str);
        if (js != null) {
            js.ad("ab_tag", XW()).ad("ab_action", "click");
        }
        return js;
    }

    public ak Ye() {
        if (Yc()) {
            return js(bNz);
        }
        ak js = js(bNu);
        if (js != null) {
            js.ad("ab_tag", XW()).ad("ab_action", "click");
            return js;
        }
        return js;
    }

    public ak Yf() {
        if (Yc()) {
            return js(bNA);
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
            return js(bNB);
        }
        ak js = js(bNw);
        if (js != null) {
            js.ad("ab_tag", XW()).ad("ab_action", "click");
            return js;
        }
        return js;
    }

    public ak Yh() {
        if (Yc()) {
            return js(bNC);
        }
        ak js = js(bNx);
        if (js != null) {
            js.ad("ab_tag", XW()).ad("ab_action", "click");
            return js;
        }
        return js;
    }

    public ak Yi() {
        return js(bND);
    }

    public ak jx(String str) {
        return js(str);
    }
}
