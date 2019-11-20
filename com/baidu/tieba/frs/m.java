package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fxr = BdUniqueId.gen();
    private int fxs;

    public int blm() {
        return this.fxs;
    }

    public void qA(int i) {
        this.fxs = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxr;
    }
}
