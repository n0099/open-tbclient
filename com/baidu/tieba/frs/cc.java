package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class cc implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bGZ = BdUniqueId.gen();
    private int bHa;

    public int Xi() {
        return this.bHa;
    }

    public void hr(int i) {
        this.bHa = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bGZ;
    }
}
