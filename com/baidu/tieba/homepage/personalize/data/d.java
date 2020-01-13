package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.l;
/* loaded from: classes7.dex */
public class d extends b {
    public static final BdUniqueId hcP = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hcP;
    }

    public d() {
        setStType(l.azJ());
        setYuelaouLocate("percard#");
    }
}
