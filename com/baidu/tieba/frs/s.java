package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId idu = BdUniqueId.gen();
    private int idv;

    public int cqU() {
        return this.idv;
    }

    public void xK(int i) {
        this.idv = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return idu;
    }
}
