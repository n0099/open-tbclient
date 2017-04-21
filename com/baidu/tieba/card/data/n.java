package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class n extends c {
    public bi threadData;
    public static String bxm = "";
    public static String bxn = "";
    public static String bxo = "";
    public static String bxp = "";
    public static String bxq = "";
    public static String bxr = "";
    public static String bxs = "";
    public static String bxt = "";
    public static String bxu = "";
    public static String bxv = "";
    public static String bxw = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bxx = BdUniqueId.gen();
    public boolean bxy = false;
    public boolean bxz = false;
    public boolean aAq = true;

    public static boolean n(bi biVar) {
        if (biVar == null) {
            return false;
        }
        return biVar.getType() == bi.Yb || biVar.getType() == bi.Yc;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bxy) {
            return bxx;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bi Kn() {
        return this.threadData;
    }

    public boolean Um() {
        return (this.threadData == null || x.p(this.threadData.sC()) == 0) ? false : true;
    }

    public as Un() {
        if (Um()) {
            return m16if(bxr);
        }
        as asVar = m16if(bxm);
        if (asVar != null) {
            asVar.aa("ab_tag", TZ()).aa("ab_action", "show");
            return asVar;
        }
        return asVar;
    }

    public as Uo() {
        if (Um()) {
            return m16if(bxs);
        }
        as asVar = m16if(bxn);
        if (asVar != null) {
            asVar.aa("ab_tag", TZ()).aa("ab_action", "click");
            return asVar;
        }
        return asVar;
    }

    public as Up() {
        if (Um()) {
            return m16if(bxt);
        }
        as asVar = m16if(bxo);
        if (asVar != null) {
            asVar.aa("ab_tag", TZ()).aa("ab_action", "click");
            return asVar;
        }
        return asVar;
    }

    public as Uq() {
        if (Um()) {
            return m16if(bxu);
        }
        as asVar = m16if(bxp);
        if (asVar != null) {
            asVar.aa("ab_tag", TZ()).aa("ab_action", "click");
            return asVar;
        }
        return asVar;
    }

    public as Ur() {
        if (Um()) {
            return m16if(bxv);
        }
        as asVar = m16if(bxq);
        if (asVar != null) {
            asVar.aa("ab_tag", TZ()).aa("ab_action", "click");
            return asVar;
        }
        return asVar;
    }

    public as Us() {
        return m16if(bxw);
    }
}
