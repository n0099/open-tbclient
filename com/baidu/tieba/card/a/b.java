package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }
}
