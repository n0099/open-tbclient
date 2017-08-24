package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId clD = BdUniqueId.gen();
    private int clE;

    public int agq() {
        return this.clE;
    }

    public void iK(int i) {
        this.clE = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return clD;
    }
}
