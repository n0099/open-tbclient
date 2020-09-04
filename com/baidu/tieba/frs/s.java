package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWr = BdUniqueId.gen();
    private int hWs;

    public int cnH() {
        return this.hWs;
    }

    public void xl(int i) {
        this.hWs = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWr;
    }
}
