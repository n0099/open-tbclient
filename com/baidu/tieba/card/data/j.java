package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes2.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bc bcVar) {
        this.threadData = bcVar;
    }

    public static boolean P(bc bcVar) {
        return bcVar != null && bcVar.getThreadType() == 49;
    }

    public an le(String str) {
        an lf = lf(str);
        lf.delete("obj_type");
        lf.delete("obj_type");
        lf.r("obj_type", 3);
        return lf;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c
    public bc SV() {
        return this.threadData;
    }
}
