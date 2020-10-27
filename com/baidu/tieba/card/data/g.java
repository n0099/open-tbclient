package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes21.dex */
public class g extends l {
    public static final BdUniqueId hVd = BdUniqueId.gen();

    public g(bw bwVar) {
        this.erH = bwVar;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hVd;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this.erH;
    }

    public static boolean ac(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.blV();
    }
}
