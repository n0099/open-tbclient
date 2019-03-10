package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIh = BdUniqueId.gen();
    private String fIi;
    private String fIj;
    private boolean fIk;

    public String blH() {
        return this.fIi;
    }

    public void wh(String str) {
        this.fIi = str;
    }

    public String blI() {
        return this.fIj;
    }

    public void wi(String str) {
        this.fIj = str;
    }

    public boolean blJ() {
        return this.fIk;
    }

    public void kj(boolean z) {
        this.fIk = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fIh;
    }
}
