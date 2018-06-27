package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dmd = BdUniqueId.gen();
    private int dme;

    public int ava() {
        return this.dme;
    }

    public void kt(int i) {
        this.dme = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dmd;
    }
}
