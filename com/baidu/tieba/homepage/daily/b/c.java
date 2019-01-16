package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evF = BdUniqueId.gen();
    private String evG;

    public String aLD() {
        return this.evG;
    }

    public void pC(String str) {
        this.evG = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return evF;
    }
}
