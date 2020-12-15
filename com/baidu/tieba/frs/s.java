package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iWt = BdUniqueId.gen();
    private int iWu;

    public int cDU() {
        return this.iWu;
    }

    public void zZ(int i) {
        this.iWu = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWt;
    }
}
