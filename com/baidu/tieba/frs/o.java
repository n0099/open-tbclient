package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId grX = BdUniqueId.gen();
    private int grY;

    public int bFB() {
        return this.grY;
    }

    public void sT(int i) {
        this.grY = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return grX;
    }
}
