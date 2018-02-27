package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGy = BdUniqueId.gen();
    private int dGz;

    public int awe() {
        return this.dGz;
    }

    public void mW(int i) {
        this.dGz = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGy;
    }
}
