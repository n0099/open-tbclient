package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSl = BdUniqueId.gen();
    private bh ccq;

    public void setData(bh bhVar) {
        this.ccq = bhVar;
    }

    public bh acy() {
        return this.ccq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSl;
    }
}
