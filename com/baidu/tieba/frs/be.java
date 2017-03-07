package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bPb = BdUniqueId.gen();
    private int bPc;

    public int ZW() {
        return this.bPc;
    }

    public void hQ(int i) {
        this.bPc = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bPb;
    }
}
