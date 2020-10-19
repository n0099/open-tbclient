package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hMn = BdUniqueId.gen();
    private bw akp;

    public void setData(bw bwVar) {
        this.akp = bwVar;
    }

    public bw bfG() {
        return this.akp;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMn;
    }
}
