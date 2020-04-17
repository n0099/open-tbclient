package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eRj = BdUniqueId.gen();
    public int followStatus;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eRj;
    }
}
