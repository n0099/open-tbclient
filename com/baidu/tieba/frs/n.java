package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId grn = BdUniqueId.gen();
    private int gro;

    public int bFr() {
        return this.gro;
    }

    public void sR(int i) {
        this.gro = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return grn;
    }
}
