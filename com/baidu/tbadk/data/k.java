package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAm = BdUniqueId.gen();
    private String aAn;
    private String aAo;
    private boolean aAp = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAm;
    }

    public String Cx() {
        return this.aAn;
    }

    public void fv(String str) {
        this.aAn = str;
    }

    public String getSmallUrl() {
        return this.aAo;
    }

    public void fw(String str) {
        this.aAo = str;
    }

    public boolean Cy() {
        return this.aAp;
    }

    public void bw(boolean z) {
        this.aAp = z;
    }
}
