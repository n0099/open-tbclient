package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ggv = BdUniqueId.gen();
    private String ggw;

    public String bwf() {
        return this.ggw;
    }

    public void yz(String str) {
        this.ggw = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ggv;
    }
}
