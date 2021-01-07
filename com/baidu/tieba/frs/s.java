package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jiG = BdUniqueId.gen();
    private int jiH;

    public int cGQ() {
        return this.jiH;
    }

    public void Al(int i) {
        this.jiH = i;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jiG;
    }
}
