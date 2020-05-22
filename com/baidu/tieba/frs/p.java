package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hqd = BdUniqueId.gen();
    private int hqe;

    public int bWz() {
        return this.hqe;
    }

    public void tX(int i) {
        this.hqe = i;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hqd;
    }
}
