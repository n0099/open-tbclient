package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aBa = BdUniqueId.gen();
    private String aBb;
    private String aBc;
    private boolean aBd = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aBa;
    }

    public String CC() {
        return this.aBb;
    }

    public void fw(String str) {
        this.aBb = str;
    }

    public String getSmallUrl() {
        return this.aBc;
    }

    public void fx(String str) {
        this.aBc = str;
    }

    public boolean CD() {
        return this.aBd;
    }

    public void bx(boolean z) {
        this.aBd = z;
    }
}
