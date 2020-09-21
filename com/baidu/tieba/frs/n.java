package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hZE = BdUniqueId.gen();
    private int height = 0;
    private int hZF = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hZE;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int coV() {
        return this.hZF;
    }

    public void xp(int i) {
        this.hZF = i;
    }
}
