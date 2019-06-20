package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNd = BdUniqueId.gen();
    private bg cbh;

    public void setData(bg bgVar) {
        this.cbh = bgVar;
    }

    public bg abv() {
        return this.cbh;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNd;
    }
}
