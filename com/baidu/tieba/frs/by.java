package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bSf = BdUniqueId.gen();
    private int bSg;

    public int acf() {
        return this.bSg;
    }

    public void hU(int i) {
        this.bSg = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bSf;
    }
}
