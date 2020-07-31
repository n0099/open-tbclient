package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes15.dex */
public class f extends k {
    public static final BdUniqueId gZM = BdUniqueId.gen();

    public f(bv bvVar) {
        this.dLK = bvVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gZM;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this.dLK;
    }

    public static boolean ab(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        return bvVar.aYg();
    }
}
