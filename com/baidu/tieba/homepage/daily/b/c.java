package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIf = BdUniqueId.gen();
    private String fIg;

    public String blF() {
        return this.fIg;
    }

    public void wf(String str) {
        this.fIg = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fIf;
    }
}
