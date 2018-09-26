package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId asU = BdUniqueId.gen();
    private String aOA;
    private boolean aOB = false;
    private String aOz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return asU;
    }

    public String Iq() {
        return this.aOz;
    }

    public void gN(String str) {
        this.aOz = str;
    }

    public String getSmallUrl() {
        return this.aOA;
    }

    public void gO(String str) {
        this.aOA = str;
    }

    public boolean isPortrait() {
        return this.aOB;
    }

    public void bI(boolean z) {
        this.aOB = z;
    }
}
