package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gra = BdUniqueId.gen();
    private int grb;

    public int bFq() {
        return this.grb;
    }

    public void sR(int i) {
        this.grb = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gra;
    }
}
