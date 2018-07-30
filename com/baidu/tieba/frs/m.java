package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId doV = BdUniqueId.gen();
    private int doW;

    public int avE() {
        return this.doW;
    }

    public void kE(int i) {
        this.doW = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doV;
    }
}
