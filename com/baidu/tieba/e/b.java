package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hYK = BdUniqueId.gen();
    private bw akq;

    public void setData(bw bwVar) {
        this.akq = bwVar;
    }

    public bw bhz() {
        return this.akq;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYK;
    }
}
