package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dDH = BdUniqueId.gen();
    private int dDI;

    public int avh() {
        return this.dDI;
    }

    public void mY(int i) {
        this.dDI = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDH;
    }
}
