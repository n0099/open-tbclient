package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Zs = BdUniqueId.gen();
    private String chA;
    private boolean chB = false;
    private String chz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Zs;
    }

    public String alv() {
        return this.chz;
    }

    public void oy(String str) {
        this.chz = str;
    }

    public String getSmallUrl() {
        return this.chA;
    }

    public void oz(String str) {
        this.chA = str;
    }

    public boolean isPortrait() {
        return this.chB;
    }

    public void eA(boolean z) {
        this.chB = z;
    }
}
