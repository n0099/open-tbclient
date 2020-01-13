package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class q extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpm = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gpm;
    }
}
