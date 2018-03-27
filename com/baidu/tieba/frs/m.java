package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGD = BdUniqueId.gen();
    private int dGE;

    public int awg() {
        return this.dGE;
    }

    public void mW(int i) {
        this.dGE = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGD;
    }
}
