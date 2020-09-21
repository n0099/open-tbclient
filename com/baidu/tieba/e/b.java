package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hxs = BdUniqueId.gen();
    private bw ajX;

    public void setData(bw bwVar) {
        this.ajX = bwVar;
    }

    public bw bcY() {
        return this.ajX;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxs;
    }
}
