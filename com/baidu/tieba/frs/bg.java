package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bRh = BdUniqueId.gen();
    private int bRi;

    public int abv() {
        return this.bRi;
    }

    public void hZ(int i) {
        this.bRi = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bRh;
    }
}
