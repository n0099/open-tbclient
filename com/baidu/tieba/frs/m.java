package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fyV = BdUniqueId.gen();
    private int fyW;

    public int bok() {
        return this.fyW;
    }

    public void rI(int i) {
        this.fyW = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fyV;
    }
}
