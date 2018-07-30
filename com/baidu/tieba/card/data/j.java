package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes2.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bb bbVar) {
        this.threadData = bbVar;
    }

    public static boolean R(bb bbVar) {
        return bbVar != null && bbVar.getThreadType() == 49;
    }

    public an ld(String str) {
        an le = le(str);
        le.delete("obj_type");
        le.delete("obj_type");
        le.r("obj_type", 3);
        return le;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bb Td() {
        return this.threadData;
    }
}
