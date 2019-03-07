package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIh = BdUniqueId.gen();
    private String fIi;
    private String fIj;
    private boolean fIk;

    public String blG() {
        return this.fIi;
    }

    public void wg(String str) {
        this.fIi = str;
    }

    public String blH() {
        return this.fIj;
    }

    public void wh(String str) {
        this.fIj = str;
    }

    public boolean blI() {
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
