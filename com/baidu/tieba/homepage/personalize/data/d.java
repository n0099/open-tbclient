package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class d extends b {
    public static final BdUniqueId glN = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glN;
    }

    public d() {
        setStType(n.air());
        setYuelaouLocate("percard#");
    }
}
