package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejS = BdUniqueId.gen();
    private String ejT;

    public String aJb() {
        return this.ejT;
    }

    public void oG(String str) {
        this.ejT = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ejS;
    }
}
