package com.baidu.tieba.card.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a.b {
    public static final BdUniqueId Op = BdUniqueId.gen();
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }
}
