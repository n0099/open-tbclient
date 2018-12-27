package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aBS = BdUniqueId.gen();
    private String aXr;
    private String aXs;
    private boolean aXt = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBS;
    }

    public String LG() {
        return this.aXr;
    }

    public void hv(String str) {
        this.aXr = str;
    }

    public String getSmallUrl() {
        return this.aXs;
    }

    public void hw(String str) {
        this.aXs = str;
    }

    public boolean isPortrait() {
        return this.aXt;
    }

    public void cj(boolean z) {
        this.aXt = z;
    }
}
