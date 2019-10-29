package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fyi = BdUniqueId.gen();
    private int fyj;

    public int blo() {
        return this.fyj;
    }

    public void qB(int i) {
        this.fyj = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fyi;
    }
}
