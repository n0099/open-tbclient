package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cZx = BdUniqueId.gen();
    private int cZy;

    public int aqC() {
        return this.cZy;
    }

    public void kj(int i) {
        this.cZy = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZx;
    }
}
