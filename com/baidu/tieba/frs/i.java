package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ftz = BdUniqueId.gen();
    private int height = 0;
    private int ftA = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftz;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int blH() {
        return this.ftA;
    }

    public void rn(int i) {
        this.ftA = i;
    }
}
