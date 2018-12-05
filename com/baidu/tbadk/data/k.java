package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aBS = BdUniqueId.gen();
    private String aXo;
    private String aXp;
    private boolean aXq = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBS;
    }

    public String LF() {
        return this.aXo;
    }

    public void hu(String str) {
        this.aXo = str;
    }

    public String getSmallUrl() {
        return this.aXp;
    }

    public void hv(String str) {
        this.aXp = str;
    }

    public boolean isPortrait() {
        return this.aXq;
    }

    public void cj(boolean z) {
        this.aXq = z;
    }
}
