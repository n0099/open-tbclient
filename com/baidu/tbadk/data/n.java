package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId MO = BdUniqueId.gen();
    private String dvE;
    private String dvF;
    private boolean dvG = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return MO;
    }

    public String aNX() {
        return this.dvE;
    }

    public void uT(String str) {
        this.dvE = str;
    }

    public String getSmallUrl() {
        return this.dvF;
    }

    public void uU(String str) {
        this.dvF = str;
    }

    public boolean aNY() {
        return this.dvG;
    }

    public void gu(boolean z) {
        this.dvG = z;
    }
}
