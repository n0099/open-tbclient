package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bj bjVar) {
        this.dqA = bjVar;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 49;
    }

    public an BG(String str) {
        an BH = BH(str);
        BH.delete("obj_type");
        BH.delete("obj_type");
        BH.af("obj_type", 3);
        return BH;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIw() {
        return this.dqA;
    }
}
