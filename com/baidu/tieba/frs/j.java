package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glS = BdUniqueId.gen();
    private int height = 0;
    private int glT = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glS;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bCa() {
        return this.glT;
    }

    public void sv(int i) {
        this.glT = i;
    }
}
