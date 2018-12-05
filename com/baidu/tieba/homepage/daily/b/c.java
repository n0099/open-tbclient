package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId esi = BdUniqueId.gen();
    private String esj;

    public String aKq() {
        return this.esj;
    }

    public void pj(String str) {
        this.esj = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return esi;
    }
}
