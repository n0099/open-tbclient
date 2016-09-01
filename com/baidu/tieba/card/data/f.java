package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId bbB = BdUniqueId.gen();
    public bg bbC;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bbB;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg Kw() {
        return this.bbC;
    }
}
