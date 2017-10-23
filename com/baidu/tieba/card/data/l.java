package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bh threadData;
    public static String bNh = "";
    public static String bNi = "";
    public static String bNj = "";
    public static String bNk = "";
    public static String bNl = "";
    public static String bNm = "";
    public static String bNn = "";
    public static String bNo = "";
    public static String bNp = "";
    public static String bNq = "";
    public static String bNr = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bNs = BdUniqueId.gen();
    public static final BdUniqueId XX = BdUniqueId.gen();
    public boolean bNt = false;
    public boolean isLinkThread = false;
    public boolean bNu = false;
    public boolean aBN = true;

    public static boolean A(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.XW || bhVar.getType() == bh.XY || bhVar.getType() == bh.XX;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bNt) {
            return bNs;
        }
        if (this.isLinkThread) {
            return XX;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Nd() {
        return this.threadData;
    }

    public boolean XY() {
        return (this.threadData == null || v.t(this.threadData.rC()) == 0) ? false : true;
    }

    public ak XZ() {
        if (XY()) {
            ak jr = jr(bNm);
            if (jr != null && Nd() != null) {
                bh Nd = Nd();
                jr.r("obj_name", Nd.sE() != null && (Nd.sE().aBY() != null || Nd.sE().IF() != null) ? 1 : 0);
            }
            return jr;
        }
        ak jr2 = jr(bNh);
        if (jr2 != null) {
            jr2.ac("ab_tag", XS()).ac("ab_action", "show");
            if (Nd() != null) {
                bh Nd2 = Nd();
                boolean z = (Nd2.sE() == null || (Nd2.sE().aBY() == null && Nd2.sE().IF() == null)) ? false : true;
                jr2.r("obj_name", z ? 1 : 0);
                if (z && Nd2.sE().aBY() != null && Nd2.sE().aBY().Ix() != null && Nd2.sE().aBY().Ix().size() > 0) {
                    jr2.r("obj_to", Nd2.sE().ghf ? 2 : 1);
                }
            }
        }
        return jr2;
    }

    public ak jt(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f("fid", this.threadData.getFid());
            akVar.ac("tid", this.threadData.getTid());
            akVar.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
            akVar.ac("obj_id", this.threadData.getAuthor().getUserId());
        }
        return akVar;
    }

    public ak ju(String str) {
        ak jr = jr(str);
        if (jr != null) {
            jr.ac("ab_tag", XS()).ac("ab_action", "show");
            if (Nd() != null) {
                bh Nd = Nd();
                boolean z = (Nd.sE() == null || (Nd.sE().aBY() == null && Nd.sE().IF() == null)) ? false : true;
                jr.r("obj_name", z ? 1 : 0);
                if (z && Nd.sE().aBY() != null && Nd.sE().aBY().Ix() != null && Nd.sE().aBY().Ix().size() > 0) {
                    jr.r("obj_to", Nd.sE().ghf ? 2 : 1);
                }
            }
        }
        return jr;
    }

    public ak jv(String str) {
        ak jr = jr(str);
        if (jr != null) {
            jr.ac("ab_tag", XS()).ac("ab_action", "click");
        }
        return jr;
    }

    public ak Ya() {
        if (XY()) {
            return jr(bNn);
        }
        ak jr = jr(bNi);
        if (jr != null) {
            jr.ac("ab_tag", XS()).ac("ab_action", "click");
            return jr;
        }
        return jr;
    }

    public ak Yb() {
        if (XY()) {
            return jr(bNo);
        }
        ak J = J(bNj, 0);
        if (J != null) {
            J.ac("ab_tag", XS()).ac("ab_action", "click");
            return J;
        }
        return J;
    }

    public ak Yc() {
        if (XY()) {
            return jr(bNp);
        }
        ak jr = jr(bNk);
        if (jr != null) {
            jr.ac("ab_tag", XS()).ac("ab_action", "click");
            return jr;
        }
        return jr;
    }

    public ak Yd() {
        if (XY()) {
            return jr(bNq);
        }
        ak jr = jr(bNl);
        if (jr != null) {
            jr.ac("ab_tag", XS()).ac("ab_action", "click");
            return jr;
        }
        return jr;
    }

    public ak Ye() {
        return jr(bNr);
    }

    public ak jw(String str) {
        return jr(str);
    }
}
