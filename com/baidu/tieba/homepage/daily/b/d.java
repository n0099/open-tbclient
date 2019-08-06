package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId geG = BdUniqueId.gen();
    private String geH;
    private String geI;
    private boolean geJ;

    public String bvs() {
        return this.geH;
    }

    public void yb(String str) {
        this.geH = str;
    }

    public String bvt() {
        return this.geI;
    }

    public void yc(String str) {
        this.geI = str;
    }

    public boolean bvu() {
        return this.geJ;
    }

    public void lj(boolean z) {
        this.geJ = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return geG;
    }
}
