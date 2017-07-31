package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ciH = BdUniqueId.gen();
    private int height = 0;
    private int ciI = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ciH;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aeP() {
        return this.ciI;
    }

    public void iA(int i) {
        this.ciI = i;
    }
}
