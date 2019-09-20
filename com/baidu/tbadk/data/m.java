package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId XD = BdUniqueId.gen();
    private String crW;
    private String crX;
    private boolean crY = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return XD;
    }

    public String arR() {
        return this.crW;
    }

    public void qh(String str) {
        this.crW = str;
    }

    public String getSmallUrl() {
        return this.crX;
    }

    public void qi(String str) {
        this.crX = str;
    }

    public boolean arS() {
        return this.crY;
    }

    public void fd(boolean z) {
        this.crY = z;
    }
}
