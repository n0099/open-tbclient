package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Xj = BdUniqueId.gen();
    private String cpI;
    private String cpJ;
    private boolean cpK = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Xj;
    }

    public String aqy() {
        return this.cpI;
    }

    public void pF(String str) {
        this.cpI = str;
    }

    public String getSmallUrl() {
        return this.cpJ;
    }

    public void pG(String str) {
        this.cpJ = str;
    }

    public boolean isPortrait() {
        return this.cpK;
    }

    public void eW(boolean z) {
        this.cpK = z;
    }
}
