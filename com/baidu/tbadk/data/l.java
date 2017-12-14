package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAQ = BdUniqueId.gen();
    private String aAR;
    private String aAS;
    private boolean aAT = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAQ;
    }

    public String CG() {
        return this.aAR;
    }

    public void fA(String str) {
        this.aAR = str;
    }

    public String getSmallUrl() {
        return this.aAS;
    }

    public void fB(String str) {
        this.aAS = str;
    }

    public boolean CH() {
        return this.aAT;
    }

    public void br(boolean z) {
        this.aAT = z;
    }
}
