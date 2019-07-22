package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gdP = BdUniqueId.gen();
    private String gdQ;
    private String gdR;
    private boolean gdS;

    public String bvf() {
        return this.gdQ;
    }

    public void ya(String str) {
        this.gdQ = str;
    }

    public String bvg() {
        return this.gdR;
    }

    public void yb(String str) {
        this.gdR = str;
    }

    public boolean bvh() {
        return this.gdS;
    }

    public void lj(boolean z) {
        this.gdS = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gdP;
    }
}
