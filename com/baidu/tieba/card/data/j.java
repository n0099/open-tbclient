package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
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

    public static boolean S(bb bbVar) {
        return bbVar != null && bbVar.getThreadType() == 49;
    }

    public am lH(String str) {
        am lI = lI(str);
        lI.delete("obj_type");
        lI.delete("obj_type");
        lI.w("obj_type", 3);
        return lI;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bb UT() {
        return this.threadData;
    }
}
