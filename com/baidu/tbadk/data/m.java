package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId GX = BdUniqueId.gen();
    private String cDp;
    private String cDq;
    private boolean cDr = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return GX;
    }

    public String atD() {
        return this.cDp;
    }

    public void pr(String str) {
        this.cDp = str;
    }

    public String getSmallUrl() {
        return this.cDq;
    }

    public void ps(String str) {
        this.cDq = str;
    }

    public boolean atE() {
        return this.cDr;
    }

    public void eX(boolean z) {
        this.cDr = z;
    }
}
