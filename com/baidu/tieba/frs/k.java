package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djW = BdUniqueId.gen();
    private int djX;

    public int auG() {
        return this.djX;
    }

    public void kn(int i) {
        this.djX = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djW;
    }
}
