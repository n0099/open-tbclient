package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.l;
/* loaded from: classes9.dex */
public class d extends b {
    public static final BdUniqueId heP = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return heP;
    }

    public d() {
        setStType(l.aBY());
        setYuelaouLocate("percard#");
    }
}
