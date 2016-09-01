package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class b extends c {
    public static final BdUniqueId cGH = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.j, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cGH;
    }

    public b() {
        setStType(ap.ND());
        setYuelaouLocate("ptrcard#");
    }
}
