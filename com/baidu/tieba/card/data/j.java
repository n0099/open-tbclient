package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes15.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public j(bv bvVar) {
        this.dLK = bvVar;
    }

    public static boolean aa(bv bvVar) {
        return bvVar != null && bvVar.getThreadType() == 49;
    }

    public ap EE(String str) {
        ap EF = EF(str);
        EF.delete("obj_type");
        EF.delete("obj_type");
        EF.ah("obj_type", 3);
        return EF;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this.dLK;
    }
}
