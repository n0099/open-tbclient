package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId goX = BdUniqueId.gen();
    private int goY;

    public int bDL() {
        return this.goY;
    }

    public void sL(int i) {
        this.goY = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return goX;
    }
}
