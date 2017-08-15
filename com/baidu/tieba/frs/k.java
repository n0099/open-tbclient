package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId clC = BdUniqueId.gen();
    private int clD;

    public int agw() {
        return this.clD;
    }

    public void iK(int i) {
        this.clD = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return clC;
    }
}
