package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fbs = BdUniqueId.gen();
    public int fbt;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbs;
    }
}
