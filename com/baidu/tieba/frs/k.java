package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId csn = BdUniqueId.gen();
    private int cso;

    public int ahV() {
        return this.cso;
    }

    public void jg(int i) {
        this.cso = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csn;
    }
}
