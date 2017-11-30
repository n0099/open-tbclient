package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cGM = BdUniqueId.gen();
    private int height = 0;
    private int cGN = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cGM;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int akU() {
        return this.cGN;
    }

    public void jK(int i) {
        this.cGN = i;
    }
}
