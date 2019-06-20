package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYS = BdUniqueId.gen();
    private String fYT;
    private String fYU;
    private boolean fYV;

    public String btd() {
        return this.fYT;
    }

    public void xv(String str) {
        this.fYT = str;
    }

    public String bte() {
        return this.fYU;
    }

    public void xw(String str) {
        this.fYU = str;
    }

    public boolean btf() {
        return this.fYV;
    }

    public void kZ(boolean z) {
        this.fYV = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYS;
    }
}
