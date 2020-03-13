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
        this.cRg = bjVar;
    }

    public static boolean aa(bj bjVar) {
        return bjVar != null && bjVar.getThreadType() == 49;
    }

    public an zY(String str) {
        an zZ = zZ(str);
        zZ.delete("obj_type");
        zZ.delete("obj_type");
        zZ.X("obj_type", 3);
        return zZ;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this.cRg;
    }
}
