package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iKL = BdUniqueId.gen();
    private int iKM;

    public int cAa() {
        return this.iKM;
    }

    public void yW(int i) {
        this.iKM = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKL;
    }
}
