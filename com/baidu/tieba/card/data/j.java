package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bk bkVar) {
        this.dEA = bkVar;
    }

    public static boolean ac(bk bkVar) {
        return bkVar != null && bkVar.getThreadType() == 49;
    }

    public an Ds(String str) {
        an Dt = Dt(str);
        Dt.delete("obj_type");
        Dt.delete("obj_type");
        Dt.ag("obj_type", 3);
        return Dt;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this.dEA;
    }
}
