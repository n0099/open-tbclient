package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bOQ = BdUniqueId.gen();
    private int bOR;

    public int aau() {
        return this.bOR;
    }

    public void hT(int i) {
        this.bOR = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bOQ;
    }
}
