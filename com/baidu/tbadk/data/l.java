package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class l implements m {
    public static final BdUniqueId afD = BdUniqueId.gen();
    private String dVR;
    private String dVS;
    private boolean dVT = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return afD;
    }

    public String aWt() {
        return this.dVR;
    }

    public void wk(String str) {
        this.dVR = str;
    }

    public String getSmallUrl() {
        return this.dVS;
    }

    public void wl(String str) {
        this.dVS = str;
    }

    public boolean aWu() {
        return this.dVT;
    }

    public void ht(boolean z) {
        this.dVT = z;
    }
}
