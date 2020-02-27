package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gqY = BdUniqueId.gen();
    private int gqZ;

    public int bFo() {
        return this.gqZ;
    }

    public void sR(int i) {
        this.gqZ = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gqY;
    }
}
