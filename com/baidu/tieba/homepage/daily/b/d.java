package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ecb = BdUniqueId.gen();
    private String ecc;
    private String ecd;
    private boolean ece;

    public String aFK() {
        return this.ecc;
    }

    public void od(String str) {
        this.ecc = str;
    }

    public String aFL() {
        return this.ecd;
    }

    public void oe(String str) {
        this.ecd = str;
    }

    public boolean aFM() {
        return this.ece;
    }

    public void hi(boolean z) {
        this.ece = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ecb;
    }
}
