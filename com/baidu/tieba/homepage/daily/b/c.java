package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUG = BdUniqueId.gen();
    private String dUH;

    public String aDw() {
        return this.dUH;
    }

    public void nx(String str) {
        this.dUH = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dUG;
    }
}
