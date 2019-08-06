package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fxi = BdUniqueId.gen();
    private int fxj;

    public int bnz() {
        return this.fxj;
    }

    public void rF(int i) {
        this.fxj = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxi;
    }
}
