package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cWS = BdUniqueId.gen();
    private int height = 0;
    private int cWT = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cWS;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int apc() {
        return this.cWT;
    }

    public void jZ(int i) {
        this.cWT = i;
    }
}
