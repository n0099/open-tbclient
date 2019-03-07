package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fbK = BdUniqueId.gen();
    private int fbL;

    public int bdV() {
        return this.fbL;
    }

    public void qi(int i) {
        this.fbL = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbK;
    }
}
