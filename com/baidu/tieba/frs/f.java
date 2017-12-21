package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cGY = BdUniqueId.gen();
    private int height = 0;
    private int cGZ = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cGY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int ald() {
        return this.cGZ;
    }

    public void jM(int i) {
        this.cGZ = i;
    }
}
