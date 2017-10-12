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
        this.threadData = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 49;
    }

    public ak jt(String str) {
        ak ju = ju(str);
        ju.dH("obj_type");
        ju.dH("obj_type");
        ju.r("obj_type", 3);
        return ju;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c
    public bh Nj() {
        return this.threadData;
    }
}
