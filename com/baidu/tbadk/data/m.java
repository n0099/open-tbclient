package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Zr = BdUniqueId.gen();
    private boolean chA = false;
    private String chy;
    private String chz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Zr;
    }

    public String alv() {
        return this.chy;
    }

    public void oy(String str) {
        this.chy = str;
    }

    public String getSmallUrl() {
        return this.chz;
    }

    public void oz(String str) {
        this.chz = str;
    }

    public boolean isPortrait() {
        return this.chA;
    }

    public void eA(boolean z) {
        this.chA = z;
    }
}
