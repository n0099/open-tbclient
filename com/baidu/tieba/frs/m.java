package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frM = BdUniqueId.gen();
    private int frN;

    public int blo() {
        return this.frN;
    }

    public void rl(int i) {
        this.frN = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frM;
    }
}
