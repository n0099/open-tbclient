package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAc = BdUniqueId.gen();
    private String aAd;
    private String aAe;
    private boolean aAf = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAc;
    }

    public String Ck() {
        return this.aAd;
    }

    public void fu(String str) {
        this.aAd = str;
    }

    public String getSmallUrl() {
        return this.aAe;
    }

    public void fv(String str) {
        this.aAe = str;
    }

    public boolean Cl() {
        return this.aAf;
    }

    public void bp(boolean z) {
        this.aAf = z;
    }
}
