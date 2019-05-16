package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Xk = BdUniqueId.gen();
    private String cpH;
    private String cpI;
    private boolean cpJ = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Xk;
    }

    public String aqy() {
        return this.cpH;
    }

    public void pG(String str) {
        this.cpH = str;
    }

    public String getSmallUrl() {
        return this.cpI;
    }

    public void pH(String str) {
        this.cpI = str;
    }

    public boolean isPortrait() {
        return this.cpJ;
    }

    public void eW(boolean z) {
        this.cpJ = z;
    }
}
