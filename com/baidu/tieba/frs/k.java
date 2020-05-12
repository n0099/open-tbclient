package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gYf = BdUniqueId.gen();
    private int height = 0;
    private int gYg = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gYf;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bOm() {
        return this.gYg;
    }

    public void ta(int i) {
        this.gYg = i;
    }
}
