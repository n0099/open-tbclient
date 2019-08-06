package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ftY = BdUniqueId.gen();
    private int height = 0;
    private int ftZ = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int blO() {
        return this.ftZ;
    }

    public void rp(int i) {
        this.ftZ = i;
    }
}
