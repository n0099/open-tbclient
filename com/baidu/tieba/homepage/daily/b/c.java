package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUL = BdUniqueId.gen();
    private String dUM;

    public String aDz() {
        return this.dUM;
    }

    public void nv(String str) {
        this.dUM = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dUL;
    }
}
