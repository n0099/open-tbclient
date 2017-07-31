package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ckR = BdUniqueId.gen();
    private int ckS;

    public int agb() {
        return this.ckS;
    }

    public void iI(int i) {
        this.ckS = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ckR;
    }
}
