package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cxG = BdUniqueId.gen();
    private int height = 0;
    private int cxH = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cxG;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aja() {
        return this.cxH;
    }

    public void jm(int i) {
        this.cxH = i;
    }
}
