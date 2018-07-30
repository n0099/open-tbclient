package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aqv = BdUniqueId.gen();
    private String aLk;
    private String aLl;
    private boolean aLm = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aqv;
    }

    public String Ha() {
        return this.aLk;
    }

    public void gq(String str) {
        this.aLk = str;
    }

    public String getSmallUrl() {
        return this.aLl;
    }

    public void gr(String str) {
        this.aLl = str;
    }

    public boolean isPortrait() {
        return this.aLm;
    }

    public void bv(boolean z) {
        this.aLm = z;
    }
}
