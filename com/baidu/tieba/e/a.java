package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWG = BdUniqueId.gen();
    private bh cry;

    public void setData(bh bhVar) {
        this.cry = bhVar;
    }

    public bh agI() {
        return this.cry;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWG;
    }
}
