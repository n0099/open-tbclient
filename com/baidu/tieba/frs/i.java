package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fuh = BdUniqueId.gen();
    private int height = 0;
    private int fui = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fuh;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bjD() {
        return this.fui;
    }

    public void qk(int i) {
        this.fui = i;
    }
}
