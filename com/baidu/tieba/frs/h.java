package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dAU = BdUniqueId.gen();
    private int height = 0;
    private int dAV = 0;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dAU;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int atO() {
        return this.dAV;
    }

    public void mQ(int i) {
        this.dAV = i;
    }
}
