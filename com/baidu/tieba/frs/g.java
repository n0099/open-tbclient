package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cWV = BdUniqueId.gen();
    private int height = 0;
    private int cWW = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cWV;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int apc() {
        return this.cWW;
    }

    public void ka(int i) {
        this.cWW = i;
    }
}
