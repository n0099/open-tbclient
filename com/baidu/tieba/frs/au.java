package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class au implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bOl = BdUniqueId.gen();
    private int height = 0;
    private int blm = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bOl;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.blm;
    }

    public void hM(int i) {
        this.blm = i;
    }
}
