package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId cve = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.a.j, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cve;
    }

    public f() {
        setStType(at.La());
        setYuelaouLocate("percard#");
    }
}
