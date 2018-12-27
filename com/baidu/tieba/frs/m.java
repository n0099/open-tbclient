package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dNu = BdUniqueId.gen();
    private int dNv;

    public int aCP() {
        return this.dNv;
    }

    public void mv(int i) {
        this.dNv = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dNu;
    }
}
