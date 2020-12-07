package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iWr = BdUniqueId.gen();
    private int iWs;

    public int cDT() {
        return this.iWs;
    }

    public void zZ(int i) {
        this.iWs = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWr;
    }
}
