package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gdN = BdUniqueId.gen();
    private String gdO;

    public String bve() {
        return this.gdO;
    }

    public void xZ(String str) {
        this.gdO = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gdN;
    }
}
