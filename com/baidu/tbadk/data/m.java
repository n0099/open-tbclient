package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Zq = BdUniqueId.gen();
    private String chw;
    private String chx;
    private boolean chy = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Zq;
    }

    public String alz() {
        return this.chw;
    }

    public void ox(String str) {
        this.chw = str;
    }

    public String getSmallUrl() {
        return this.chx;
    }

    public void oy(String str) {
        this.chx = str;
    }

    public boolean isPortrait() {
        return this.chy;
    }

    public void eA(boolean z) {
        this.chy = z;
    }
}
