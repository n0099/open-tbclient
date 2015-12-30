package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId aPP = BdUniqueId.gen();
    public static String aQd;
    public static String aQe;
    public static String aQf;
    public static String aQg;
    public static String aQh;
    public static String aQi;
    public static String aQj;
    public static String aQk;
    public static String aQl;
    public static String aQm;
    public static String aQn;
    public z aQo;

    public static boolean b(z zVar) {
        return zVar != null && zVar.getType() == z.WC;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aPP;
    }

    @Override // com.baidu.tieba.card.a.c
    public z Iv() {
        return this.aQo;
    }

    public boolean Iz() {
        return (this.aQo == null || y.l(this.aQo.sB()) == 0) ? false : true;
    }

    public av IA() {
        return Iz() ? gM(aQi) : gM(aQd);
    }

    public av IB() {
        return Iz() ? gM(aQj) : gM(aQe);
    }

    public av IC() {
        return Iz() ? gM(aQk) : gM(aQf);
    }

    public av ID() {
        return Iz() ? gM(aQl) : gM(aQg);
    }

    public av IE() {
        return Iz() ? gM(aQm) : gM(aQh);
    }

    public av IF() {
        return gM(aQn);
    }
}
