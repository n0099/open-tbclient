package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frL = BdUniqueId.gen();
    private int frM;

    public int bll() {
        return this.frM;
    }

    public void rl(int i) {
        this.frM = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frL;
    }
}
