package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqg = BdUniqueId.gen();
    private bw ajx;

    public void setData(bw bwVar) {
        this.ajx = bwVar;
    }

    public bw bce() {
        return this.ajx;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqg;
    }
}
