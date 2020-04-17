package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class t extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hby = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hby;
    }
}
