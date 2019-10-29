package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Hx = BdUniqueId.gen();
    private String cEg;
    private String cEh;
    private boolean cEi = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Hx;
    }

    public String atF() {
        return this.cEg;
    }

    public void pr(String str) {
        this.cEg = str;
    }

    public String getSmallUrl() {
        return this.cEh;
    }

    public void ps(String str) {
        this.cEh = str;
    }

    public boolean atG() {
        return this.cEi;
    }

    public void eX(boolean z) {
        this.cEi = z;
    }
}
