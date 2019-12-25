package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes5.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bj bjVar) {
        this.cMR = bjVar;
    }

    public static boolean Y(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 49;
    }

    public an zx(String str) {
        an zy = zy(str);
        zy.delete("obj_type");
        zy.delete("obj_type");
        zy.Z("obj_type", 3);
        return zy;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        return this.cMR;
    }
}
