package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYN = BdUniqueId.gen();
    private String fYO;

    public String bsY() {
        return this.fYO;
    }

    public void xs(String str) {
        this.fYO = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYN;
    }
}
