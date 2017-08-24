package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aBb = BdUniqueId.gen();
    private String aBc;
    private String aBd;
    private boolean aBe = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aBb;
    }

    public String CC() {
        return this.aBc;
    }

    public void fA(String str) {
        this.aBc = str;
    }

    public String getSmallUrl() {
        return this.aBd;
    }

    public void fB(String str) {
        this.aBd = str;
    }

    public boolean CD() {
        return this.aBe;
    }

    public void bx(boolean z) {
        this.aBe = z;
    }
}
