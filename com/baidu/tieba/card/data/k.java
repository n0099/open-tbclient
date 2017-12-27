package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(be beVar) {
        this.threadData = beVar;
    }

    public static boolean J(be beVar) {
        return beVar != null && beVar.getThreadType() == 49;
    }

    public ak kb(String str) {
        ak kc = kc(str);
        kc.dV("obj_type");
        kc.dV("obj_type");
        kc.s("obj_type", 3);
        return kc;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public be VW() {
        return this.threadData;
    }
}
