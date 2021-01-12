package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jdY = BdUniqueId.gen();
    private int jdZ;

    public int cCY() {
        return this.jdZ;
    }

    public void yF(int i) {
        this.jdZ = i;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdY;
    }
}
