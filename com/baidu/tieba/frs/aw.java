package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bQr = BdUniqueId.gen();
    private int height = 0;
    private int bnw = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bQr;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aaI() {
        return this.bnw;
    }

    public void hV(int i) {
        this.bnw = i;
    }
}
