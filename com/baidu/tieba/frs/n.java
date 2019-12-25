package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glO = BdUniqueId.gen();
    private int glP;

    public int bCJ() {
        return this.glP;
    }

    public void sG(int i) {
        this.glP = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glO;
    }
}
