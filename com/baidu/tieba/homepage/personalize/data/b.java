package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class b extends c {
    public static final BdUniqueId cvc = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.j, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cvc;
    }

    public b() {
        setStType(at.La());
        setYuelaouLocate("ptrcard#");
    }
}
