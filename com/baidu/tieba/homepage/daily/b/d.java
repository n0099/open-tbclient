package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfU = BdUniqueId.gen();
    private String gfV;
    private String gfW;
    private boolean gfX;

    public String btl() {
        return this.gfV;
    }

    public void wT(String str) {
        this.gfV = str;
    }

    public String btm() {
        return this.gfW;
    }

    public void wU(String str) {
        this.gfW = str;
    }

    public boolean btn() {
        return this.gfX;
    }

    public void la(boolean z) {
        this.gfX = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfU;
    }
}
