package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exA = BdUniqueId.gen();
    private bg bTo;

    public void setData(bg bgVar) {
        this.bTo = bgVar;
    }

    public bg WO() {
        return this.bTo;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exA;
    }
}
