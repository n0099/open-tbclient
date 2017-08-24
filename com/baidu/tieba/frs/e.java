package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cjv = BdUniqueId.gen();
    private int height = 0;
    private int cjw = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cjv;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aff() {
        return this.cjw;
    }

    public void iC(int i) {
        this.cjw = i;
    }
}
