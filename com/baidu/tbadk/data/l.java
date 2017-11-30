package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAL = BdUniqueId.gen();
    private String aAM;
    private String aAN;
    private boolean aAO = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAL;
    }

    public String CF() {
        return this.aAM;
    }

    public void fB(String str) {
        this.aAM = str;
    }

    public String getSmallUrl() {
        return this.aAN;
    }

    public void fC(String str) {
        this.aAN = str;
    }

    public boolean CG() {
        return this.aAO;
    }

    public void bq(boolean z) {
        this.aAO = z;
    }
}
