package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId XE = BdUniqueId.gen();
    private String crb;
    private String crd;
    private boolean cre = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return XE;
    }

    public String arF() {
        return this.crb;
    }

    public void pW(String str) {
        this.crb = str;
    }

    public String getSmallUrl() {
        return this.crd;
    }

    public void pX(String str) {
        this.crd = str;
    }

    public boolean arG() {
        return this.cre;
    }

    public void fa(boolean z) {
        this.cre = z;
    }
}
