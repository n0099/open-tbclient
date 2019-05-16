package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYP = BdUniqueId.gen();
    private String fYQ;
    private String fYR;
    private boolean fYS;

    public String bsZ() {
        return this.fYQ;
    }

    public void xt(String str) {
        this.fYQ = str;
    }

    public String bta() {
        return this.fYR;
    }

    public void xu(String str) {
        this.fYR = str;
    }

    public boolean btb() {
        return this.fYS;
    }

    public void kY(boolean z) {
        this.fYS = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYP;
    }
}
