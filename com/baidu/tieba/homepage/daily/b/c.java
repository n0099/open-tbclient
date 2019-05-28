package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYO = BdUniqueId.gen();
    private String fYP;

    public String btb() {
        return this.fYP;
    }

    public void xs(String str) {
        this.fYP = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYO;
    }
}
