package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hFi = BdUniqueId.gen();
    private int height = 0;
    private int hFj = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hFi;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cbm() {
        return this.hFj;
    }

    public void uB(int i) {
        this.hFj = i;
    }
}
