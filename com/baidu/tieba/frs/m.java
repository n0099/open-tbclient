package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId duQ = BdUniqueId.gen();
    private int duR;

    public int axx() {
        return this.duR;
    }

    public void lc(int i) {
        this.duR = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return duQ;
    }
}
