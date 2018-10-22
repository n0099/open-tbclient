package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejT = BdUniqueId.gen();
    private String ejU;

    public String aJb() {
        return this.ejU;
    }

    public void oG(String str) {
        this.ejU = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ejT;
    }
}
