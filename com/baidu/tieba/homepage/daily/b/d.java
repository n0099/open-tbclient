package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYQ = BdUniqueId.gen();
    private String fYR;
    private String fYS;
    private boolean fYT;

    public String btc() {
        return this.fYR;
    }

    public void xt(String str) {
        this.fYR = str;
    }

    public String btd() {
        return this.fYS;
    }

    public void xu(String str) {
        this.fYS = str;
    }

    public boolean bte() {
        return this.fYT;
    }

    public void kY(boolean z) {
        this.fYT = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYQ;
    }
}
