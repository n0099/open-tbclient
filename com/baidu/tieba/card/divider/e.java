package com.baidu.tieba.card.divider;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return TYPE;
    }
}
