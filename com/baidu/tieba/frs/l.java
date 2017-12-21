package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cJk = BdUniqueId.gen();
    private int cJl;

    public int amr() {
        return this.cJl;
    }

    public void jU(int i) {
        this.cJl = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJk;
    }
}
