package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dyL = BdUniqueId.gen();
    private int dyM;

    public int atZ() {
        return this.dyM;
    }

    public void mV(int i) {
        this.dyM = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dyL;
    }
}
