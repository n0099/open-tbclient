package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cJg = BdUniqueId.gen();
    private int cJh;

    public int amq() {
        return this.cJh;
    }

    public void jU(int i) {
        this.cJh = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJg;
    }
}
