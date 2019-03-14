package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fbJ = BdUniqueId.gen();
    private int fbK;

    public int bdV() {
        return this.fbK;
    }

    public void qi(int i) {
        this.fbK = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbJ;
    }
}
