package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId giJ = BdUniqueId.gen();
    private int height = 0;
    private int giK = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return giJ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bAY() {
        return this.giK;
    }

    public void sq(int i) {
        this.giK = i;
    }
}
