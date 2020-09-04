package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqn = BdUniqueId.gen();
    private bw ajz;

    public void setData(bw bwVar) {
        this.ajz = bwVar;
    }

    public bw bce() {
        return this.ajz;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqn;
    }
}
