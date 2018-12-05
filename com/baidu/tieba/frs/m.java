package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dKG = BdUniqueId.gen();
    private int dKH;

    public int aCa() {
        return this.dKH;
    }

    public void mi(int i) {
        this.dKH = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKG;
    }
}
