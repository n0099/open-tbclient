package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfb = BdUniqueId.gen();
    private String gfc;

    public String bti() {
        return this.gfc;
    }

    public void wS(String str) {
        this.gfc = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfb;
    }
}
