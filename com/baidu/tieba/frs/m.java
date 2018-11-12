package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dEh = BdUniqueId.gen();
    private int dEi;

    public int aAq() {
        return this.dEi;
    }

    public void lS(int i) {
        this.dEi = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dEh;
    }
}
