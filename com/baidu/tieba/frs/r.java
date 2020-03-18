package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gsm = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gsm;
    }
}
