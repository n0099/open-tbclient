package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class d extends b {
    public static final BdUniqueId gky = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gky;
    }

    public d() {
        setStType(n.aek());
        setYuelaouLocate("percard#");
    }
}
