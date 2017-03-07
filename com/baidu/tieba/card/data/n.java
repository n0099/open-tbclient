package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class n extends c {
    public bj threadData;
    public static String bvc = "";
    public static String bvd = "";
    public static String bve = "";
    public static String bvf = "";
    public static String bvg = "";
    public static String bvh = "";
    public static String bvi = "";
    public static String bvj = "";
    public static String bvk = "";
    public static String bvl = "";
    public static String bvm = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bvn = BdUniqueId.gen();
    public boolean bvo = false;
    public boolean bvp = false;
    public boolean azY = true;

    public static boolean n(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        return bjVar.getType() == bj.XK || bjVar.getType() == bj.XL;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bvo) {
            return bvn;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bj JN() {
        return this.threadData;
    }

    public boolean SM() {
        return (this.threadData == null || x.p(this.threadData.se()) == 0) ? false : true;
    }

    public as SN() {
        if (SM()) {
            return ia(bvh);
        }
        as ia = ia(bvc);
        if (ia != null) {
            ia.Z("ab_tag", Sz()).Z("ab_action", "show");
            return ia;
        }
        return ia;
    }

    public as SO() {
        if (SM()) {
            return ia(bvi);
        }
        as ia = ia(bvd);
        if (ia != null) {
            ia.Z("ab_tag", Sz()).Z("ab_action", "click");
            return ia;
        }
        return ia;
    }

    public as SP() {
        if (SM()) {
            return ia(bvj);
        }
        as ia = ia(bve);
        if (ia != null) {
            ia.Z("ab_tag", Sz()).Z("ab_action", "click");
            return ia;
        }
        return ia;
    }

    public as SQ() {
        if (SM()) {
            return ia(bvk);
        }
        as ia = ia(bvf);
        if (ia != null) {
            ia.Z("ab_tag", Sz()).Z("ab_action", "click");
            return ia;
        }
        return ia;
    }

    public as SR() {
        if (SM()) {
            return ia(bvl);
        }
        as ia = ia(bvg);
        if (ia != null) {
            ia.Z("ab_tag", Sz()).Z("ab_action", "click");
            return ia;
        }
        return ia;
    }

    public as SS() {
        return ia(bvm);
    }
}
