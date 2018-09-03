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

    public an lf(String str) {
        an lg = lg(str);
        lg.delete("obj_type");
        lg.delete("obj_type");
        lg.r("obj_type", 3);
        return lg;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bb Tg() {
        return this.threadData;
    }
}
