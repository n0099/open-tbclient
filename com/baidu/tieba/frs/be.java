package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bHS = BdUniqueId.gen();
    private int bHT;

    public int YX() {
        return this.bHT;
    }

    public void hU(int i) {
        this.bHT = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bHS;
    }
}
