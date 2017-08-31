package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cqX = BdUniqueId.gen();
    private int cqY;

    public int ahO() {
        return this.cqY;
    }

    public void iW(int i) {
        this.cqY = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cqX;
    }
}
