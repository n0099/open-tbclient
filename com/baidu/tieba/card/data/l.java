package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bj threadData;
    public static String bMX = "";
    public static String bMY = "";
    public static String bMZ = "";
    public static String bNa = "";
    public static String bNb = "";
    public static String bNc = "";
    public static String bNd = "";
    public static String bNe = "";
    public static String bNf = "";
    public static String bNg = "";
    public static String bNh = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bNi = BdUniqueId.gen();
    public static final BdUniqueId Yi = BdUniqueId.gen();
    public boolean bNj = false;
    public boolean isLinkThread = false;
    public boolean bNk = false;
    public boolean aCJ = true;

    public static boolean F(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.Yh || bjVar.getType() == bj.Yj || bjVar.getType() == bj.Yi;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bNj) {
            return bNi;
        }
        if (this.isLinkThread) {
            return Yi;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj MR() {
        return this.threadData;
    }

    public boolean Yj() {
        return (this.threadData == null || v.u(this.threadData.rP()) == 0) ? false : true;
    }

    public ak Yk() {
        if (Yj()) {
            ak jy = jy(bNc);
            if (jy != null && MR() != null) {
                bj MR = MR();
                jy.r("obj_name", MR.sR() != null && (MR.sR().aDg() != null || MR.sR().ID() != null) ? 1 : 0);
            }
            return jy;
        }
        ak jy2 = jy(bMX);
        if (jy2 != null) {
            jy2.ad("ab_tag", Yd()).ad("ab_action", "show");
            if (MR() != null) {
                bj MR2 = MR();
                boolean z = (MR2.sR() == null || (MR2.sR().aDg() == null && MR2.sR().ID() == null)) ? false : true;
                jy2.r("obj_name", z ? 1 : 0);
                if (z && MR2.sR().aDg() != null && MR2.sR().aDg().Iv() != null && MR2.sR().aDg().Iv().size() > 0) {
                    jy2.r("obj_to", MR2.sR().giQ ? 2 : 1);
                }
            }
        }
        return jy2;
    }

    public ak jz(String str) {
        ak jy = jy(str);
        if (jy != null) {
            jy.f("fid", this.threadData.getFid());
            jy.ad("tid", this.threadData.getTid());
            jy.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return jy;
    }

    public ak jA(String str) {
        ak jy = jy(str);
        if (jy != null) {
            jy.ad("ab_tag", Yd()).ad("ab_action", "show");
            if (MR() != null) {
                bj MR = MR();
                boolean z = (MR.sR() == null || (MR.sR().aDg() == null && MR.sR().ID() == null)) ? false : true;
                jy.r("obj_name", z ? 1 : 0);
                if (z && MR.sR().aDg() != null && MR.sR().aDg().Iv() != null && MR.sR().aDg().Iv().size() > 0) {
                    jy.r("obj_to", MR.sR().giQ ? 2 : 1);
                }
            }
        }
        return jy;
    }

    public ak jB(String str) {
        ak jy = jy(str);
        if (jy != null) {
            jy.ad("ab_tag", Yd()).ad("ab_action", "click");
        }
        return jy;
    }

    public ak Yl() {
        if (Yj()) {
            return jy(bNd);
        }
        ak jy = jy(bMY);
        if (jy != null) {
            jy.ad("ab_tag", Yd()).ad("ab_action", "click");
            return jy;
        }
        return jy;
    }

    public ak Ym() {
        if (Yj()) {
            return jy(bNe);
        }
        ak J = J(bMZ, 0);
        if (J != null) {
            J.ad("ab_tag", Yd()).ad("ab_action", "click");
            return J;
        }
        return J;
    }

    public ak Yn() {
        if (Yj()) {
            return jy(bNf);
        }
        ak jy = jy(bNa);
        if (jy != null) {
            jy.ad("ab_tag", Yd()).ad("ab_action", "click");
            return jy;
        }
        return jy;
    }

    public ak Yo() {
        if (Yj()) {
            return jy(bNg);
        }
        ak jy = jy(bNb);
        if (jy != null) {
            jy.ad("ab_tag", Yd()).ad("ab_action", "click");
            return jy;
        }
        return jy;
    }

    public ak Yp() {
        return jy(bNh);
    }

    public ak jC(String str) {
        return jy(str);
    }
}
