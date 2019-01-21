package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dOe = BdUniqueId.gen();
    private int dOf;

    public int aDm() {
        return this.dOf;
    }

    public void mw(int i) {
        this.dOf = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOe;
    }
}
