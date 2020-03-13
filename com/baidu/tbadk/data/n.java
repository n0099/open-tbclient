package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId MO = BdUniqueId.gen();
    private String dvS;
    private String dvT;
    private boolean dvU = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return MO;
    }

    public String aOa() {
        return this.dvS;
    }

    public void uU(String str) {
        this.dvS = str;
    }

    public String getSmallUrl() {
        return this.dvT;
    }

    public void uV(String str) {
        this.dvT = str;
    }

    public boolean aOb() {
        return this.dvU;
    }

    public void gu(boolean z) {
        this.dvU = z;
    }
}
