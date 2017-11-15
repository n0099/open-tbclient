package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public k(bh bhVar) {
        this.blt = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 49;
    }

    public ak jR(String str) {
        ak jS = jS(str);
        jS.dM("obj_type");
        jS.dM("obj_type");
        jS.r("obj_type", 3);
        return jS;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bh NA() {
        return this.blt;
    }
}
