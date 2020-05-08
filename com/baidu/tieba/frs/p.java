package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hbp = BdUniqueId.gen();
    private int hbq;

    public int bQc() {
        return this.hbq;
    }

    public void ts(int i) {
        this.hbq = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hbp;
    }
}
