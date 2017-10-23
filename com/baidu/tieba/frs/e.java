package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cpT = BdUniqueId.gen();
    private int height = 0;
    private int cpU = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cpT;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int agF() {
        return this.cpU;
    }

    public void iX(int i) {
        this.cpU = i;
    }
}
