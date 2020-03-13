package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId goi = BdUniqueId.gen();
    private int height = 0;
    private int goj = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return goi;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bDG() {
        return this.goj;
    }

    public void sB(int i) {
        this.goj = i;
    }
}
