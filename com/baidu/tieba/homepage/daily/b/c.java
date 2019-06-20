package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYQ = BdUniqueId.gen();
    private String fYR;

    public String btc() {
        return this.fYR;
    }

    public void xu(String str) {
        this.fYR = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYQ;
    }
}
