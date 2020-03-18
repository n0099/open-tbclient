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
        this.cRt = bjVar;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 49;
    }

    public an zZ(String str) {
        an Aa = Aa(str);
        Aa.delete("obj_type");
        Aa.delete("obj_type");
        Aa.X("obj_type", 3);
        return Aa;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAj() {
        return this.cRt;
    }
}
