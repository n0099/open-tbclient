package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dDm = BdUniqueId.gen();
    private int dDn;

    public int avc() {
        return this.dDn;
    }

    public void mY(int i) {
        this.dDn = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDm;
    }
}
