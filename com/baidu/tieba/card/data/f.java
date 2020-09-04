package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes15.dex */
public class f extends l {
    public static final BdUniqueId hmI = BdUniqueId.gen();

    public f(bw bwVar) {
        this.dUW = bwVar;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hmI;
    }

    public static boolean aa(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.ebk;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.dUW;
    }
}
