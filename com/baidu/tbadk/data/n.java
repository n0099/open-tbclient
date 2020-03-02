package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId MO = BdUniqueId.gen();
    private String dvF;
    private String dvG;
    private boolean dvH = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return MO;
    }

    public String aNZ() {
        return this.dvF;
    }

    public void uT(String str) {
        this.dvF = str;
    }

    public String getSmallUrl() {
        return this.dvG;
    }

    public void uU(String str) {
        this.dvG = str;
    }

    public boolean aOa() {
        return this.dvH;
    }

    public void gu(boolean z) {
        this.dvH = z;
    }
}
