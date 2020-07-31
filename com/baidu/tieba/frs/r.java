package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hIV = BdUniqueId.gen();
    private int hIW;

    public int cdj() {
        return this.hIW;
    }

    public void uW(int i) {
        this.hIW = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hIV;
    }
}
