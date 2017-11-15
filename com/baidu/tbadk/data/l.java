package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAk = BdUniqueId.gen();
    private String aAl;
    private String aAm;
    private boolean aAn = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAk;
    }

    public String Cw() {
        return this.aAl;
    }

    public void fv(String str) {
        this.aAl = str;
    }

    public String getSmallUrl() {
        return this.aAm;
    }

    public void fw(String str) {
        this.aAm = str;
    }

    public boolean Cx() {
        return this.aAn;
    }

    public void bq(boolean z) {
        this.aAn = z;
    }
}
