package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId doT = BdUniqueId.gen();
    private int doU;

    public int avD() {
        return this.doU;
    }

    public void kD(int i) {
        this.doU = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doT;
    }
}
