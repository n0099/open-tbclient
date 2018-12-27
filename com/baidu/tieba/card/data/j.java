package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
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

    public am mM(String str) {
        am mN = mN(str);
        mN.delete("obj_type");
        mN.delete("obj_type");
        mN.x("obj_type", 3);
        return mN;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bb ZT() {
        return this.threadData;
    }
}
