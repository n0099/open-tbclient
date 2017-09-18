package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAj = BdUniqueId.gen();
    private String aAk;
    private String aAl;
    private boolean aAm = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAj;
    }

    public String Cx() {
        return this.aAk;
    }

    public void fv(String str) {
        this.aAk = str;
    }

    public String getSmallUrl() {
        return this.aAl;
    }

    public void fw(String str) {
        this.aAl = str;
    }

    public boolean Cy() {
        return this.aAm;
    }

    public void bw(boolean z) {
        this.aAm = z;
    }
}
