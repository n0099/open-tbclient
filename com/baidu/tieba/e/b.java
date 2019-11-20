package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eVQ = BdUniqueId.gen();
    private bh cqG;

    public void setData(bh bhVar) {
        this.cqG = bhVar;
    }

    public bh agG() {
        return this.cqG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVQ;
    }
}
