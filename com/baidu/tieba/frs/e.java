package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId chA = BdUniqueId.gen();
    private int height = 0;
    private int chB = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return chA;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aeK() {
        return this.chB;
    }

    public void iA(int i) {
        this.chB = i;
    }
}
