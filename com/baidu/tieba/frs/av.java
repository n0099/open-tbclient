package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class av implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bzC = BdUniqueId.gen();
    private int height = 0;
    private int bzD = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bzC;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bzD;
    }

    public void he(int i) {
        this.bzD = i;
    }
}
