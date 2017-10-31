package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId czy = BdUniqueId.gen();
    private int czz;

    public int ajY() {
        return this.czz;
    }

    public void jv(int i) {
        this.czz = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return czy;
    }
}
