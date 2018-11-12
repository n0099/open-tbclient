package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eln = BdUniqueId.gen();
    private String elo;

    public String aIz() {
        return this.elo;
    }

    public void oH(String str) {
        this.elo = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eln;
    }
}
