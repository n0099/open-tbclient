package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bQJ = BdUniqueId.gen();
    private int height = 0;
    private int bQK = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bQJ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bQK;
    }

    public void hV(int i) {
        this.bQK = i;
    }
}
