package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes15.dex */
public class g extends l {
    public static final BdUniqueId hmF = BdUniqueId.gen();

    public g(bw bwVar) {
        this.dUS = bwVar;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hmF;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.dUS;
    }

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.bgz();
    }
}
