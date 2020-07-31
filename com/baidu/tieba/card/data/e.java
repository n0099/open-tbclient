package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes15.dex */
public class e extends k {
    public static final BdUniqueId gZL = BdUniqueId.gen();

    public e(bv bvVar) {
        this.dLK = bvVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gZL;
    }

    public static boolean aa(bv bvVar) {
        return bvVar != null && bvVar.getType() == bv.dRK;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this.dLK;
    }
}
