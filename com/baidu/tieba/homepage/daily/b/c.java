package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evG = BdUniqueId.gen();
    private String evH;

    public String aLD() {
        return this.evH;
    }

    public void pC(String str) {
        this.evH = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return evG;
    }
}
