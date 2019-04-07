package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fHU = BdUniqueId.gen();
    private String fHV;
    private String fHW;
    private boolean fHX;

    public String blD() {
        return this.fHV;
    }

    public void we(String str) {
        this.fHV = str;
    }

    public String blE() {
        return this.fHW;
    }

    public void wf(String str) {
        this.fHW = str;
    }

    public boolean blF() {
        return this.fHX;
    }

    public void kj(boolean z) {
        this.fHX = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fHU;
    }
}
