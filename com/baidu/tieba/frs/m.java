package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dOd = BdUniqueId.gen();
    private int dOe;

    public int aDm() {
        return this.dOe;
    }

    public void mw(int i) {
        this.dOe = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOd;
    }
}
