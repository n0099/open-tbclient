package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.an;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId cHy = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.j, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cHy;
    }

    public f() {
        setStType(an.Od());
        setYuelaouLocate("percard#");
    }
}
