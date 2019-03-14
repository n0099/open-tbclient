package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIg = BdUniqueId.gen();
    private String fIh;
    private String fIi;
    private boolean fIj;

    public String blG() {
        return this.fIh;
    }

    public void wf(String str) {
        this.fIh = str;
    }

    public String blH() {
        return this.fIi;
    }

    public void wg(String str) {
        this.fIi = str;
    }

    public boolean blI() {
        return this.fIj;
    }

    public void kj(boolean z) {
        this.fIj = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fIg;
    }
}
