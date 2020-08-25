package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWl = BdUniqueId.gen();
    private int hWm;

    public int cnG() {
        return this.hWm;
    }

    public void xl(int i) {
        this.hWm = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWl;
    }
}
