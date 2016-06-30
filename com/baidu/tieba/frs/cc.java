package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class cc implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bFL = BdUniqueId.gen();
    private int bFM;

    public int WQ() {
        return this.bFM;
    }

    public void hs(int i) {
        this.bFM = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bFL;
    }
}
