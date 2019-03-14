package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIe = BdUniqueId.gen();
    private String fIf;

    public String blF() {
        return this.fIf;
    }

    public void we(String str) {
        this.fIf = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fIe;
    }
}
