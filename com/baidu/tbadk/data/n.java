package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId MP = BdUniqueId.gen();
    private String dwf;
    private String dwg;
    private boolean dwh = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return MP;
    }

    public String aOe() {
        return this.dwf;
    }

    public void uU(String str) {
        this.dwf = str;
    }

    public String getSmallUrl() {
        return this.dwg;
    }

    public void uV(String str) {
        this.dwg = str;
    }

    public boolean aOf() {
        return this.dwh;
    }

    public void gv(boolean z) {
        this.dwh = z;
    }
}
