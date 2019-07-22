package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId XE = BdUniqueId.gen();
    private String cqU;
    private String cqV;
    private boolean cqW = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return XE;
    }

    public String arD() {
        return this.cqU;
    }

    public void pW(String str) {
        this.cqU = str;
    }

    public String getSmallUrl() {
        return this.cqV;
    }

    public void pX(String str) {
        this.cqV = str;
    }

    public boolean arE() {
        return this.cqW;
    }

    public void fa(boolean z) {
        this.cqW = z;
    }
}
