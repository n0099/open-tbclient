package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfS = BdUniqueId.gen();
    private String gfT;

    public String btk() {
        return this.gfT;
    }

    public void wS(String str) {
        this.gfT = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfS;
    }
}
