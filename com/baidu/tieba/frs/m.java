package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dCR = BdUniqueId.gen();
    private int dCS;

    public int aAT() {
        return this.dCS;
    }

    public void lA(int i) {
        this.dCS = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dCR;
    }
}
