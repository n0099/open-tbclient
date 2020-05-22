package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class t extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqs = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hqs;
    }
}
