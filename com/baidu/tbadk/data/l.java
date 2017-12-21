package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAT = BdUniqueId.gen();
    private String aAU;
    private String aAV;
    private boolean aAW = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAT;
    }

    public String CG() {
        return this.aAU;
    }

    public void fA(String str) {
        this.aAU = str;
    }

    public String getSmallUrl() {
        return this.aAV;
    }

    public void fB(String str) {
        this.aAV = str;
    }

    public boolean CH() {
        return this.aAW;
    }

    public void br(boolean z) {
        this.aAW = z;
    }
}
