package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAZ = BdUniqueId.gen();
    private String aBa;
    private String aBb;
    private boolean aBc = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAZ;
    }

    public String CC() {
        return this.aBa;
    }

    public void fw(String str) {
        this.aBa = str;
    }

    public String getSmallUrl() {
        return this.aBb;
    }

    public void fx(String str) {
        this.aBb = str;
    }

    public boolean CD() {
        return this.aBc;
    }

    public void bx(boolean z) {
        this.aBc = z;
    }
}
