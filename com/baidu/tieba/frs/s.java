package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iss = BdUniqueId.gen();
    private int ist;

    public int cus() {
        return this.ist;
    }

    public void yq(int i) {
        this.ist = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iss;
    }
}
