package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iEO = BdUniqueId.gen();
    private int iEP;

    public int cxz() {
        return this.iEP;
    }

    public void yJ(int i) {
        this.iEP = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEO;
    }
}
