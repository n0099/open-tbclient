package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ebZ = BdUniqueId.gen();
    private String eca;

    public String aFJ() {
        return this.eca;
    }

    public void oc(String str) {
        this.eca = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ebZ;
    }
}
