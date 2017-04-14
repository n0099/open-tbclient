package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cyS = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cyS;
    }

    public d() {
        setStType(at.sf());
        setYuelaouLocate("percard#");
    }
}
