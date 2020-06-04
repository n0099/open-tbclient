package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hqo = BdUniqueId.gen();
    private int hqp;

    public int bWB() {
        return this.hqp;
    }

    public void tZ(int i) {
        this.hqp = i;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hqo;
    }
}
