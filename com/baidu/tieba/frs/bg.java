package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bQQ = BdUniqueId.gen();
    private int height = 0;
    private int bQR = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bQQ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bQR;
    }

    public void hR(int i) {
        this.bQR = i;
    }
}
