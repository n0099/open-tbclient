package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUI = BdUniqueId.gen();
    private String dUJ;
    private String dUK;
    private boolean dUL;

    public String aDx() {
        return this.dUJ;
    }

    public void ny(String str) {
        this.dUJ = str;
    }

    public String aDy() {
        return this.dUK;
    }

    public void nz(String str) {
        this.dUK = str;
    }

    public boolean aDz() {
        return this.dUL;
    }

    public void gK(boolean z) {
        this.dUL = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dUI;
    }
}
