package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId goS = BdUniqueId.gen();
    private int height = 0;
    private int goT = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return goS;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bDO() {
        return this.goT;
    }

    public void sD(int i) {
        this.goT = i;
    }
}
