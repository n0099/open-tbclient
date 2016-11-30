package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bUl = BdUniqueId.gen();
    private int bUm;

    public int adx() {
        return this.bUm;
    }

    public void hX(int i) {
        this.bUm = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bUl;
    }
}
