package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fwJ = BdUniqueId.gen();
    private int fwK;

    public int bnp() {
        return this.fwK;
    }

    public void rD(int i) {
        this.fwK = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fwJ;
    }
}
