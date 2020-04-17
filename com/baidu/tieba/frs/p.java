package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hbj = BdUniqueId.gen();
    private int hbk;

    public int bQe() {
        return this.hbk;
    }

    public void ts(int i) {
        this.hbk = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hbj;
    }
}
