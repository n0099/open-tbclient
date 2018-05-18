package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId daG = BdUniqueId.gen();
    private int daH;

    public int aqB() {
        return this.daH;
    }

    public void ki(int i) {
        this.daH = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return daG;
    }
}
