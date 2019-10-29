package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId gfc = BdUniqueId.gen();
    public static final BdUniqueId gfd = BdUniqueId.gen();
    public boolean isLinkThread;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.isLinkThread ? gfd : gfc;
    }
}
