package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId csb = BdUniqueId.gen();
    private int csc;

    public int ahQ() {
        return this.csc;
    }

    public void jf(int i) {
        this.csc = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csb;
    }
}
