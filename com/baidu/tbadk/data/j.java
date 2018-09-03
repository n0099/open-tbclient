package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aqw = BdUniqueId.gen();
    private String aLh;
    private String aLi;
    private boolean aLj = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aqw;
    }

    public String Ha() {
        return this.aLh;
    }

    public void gq(String str) {
        this.aLh = str;
    }

    public String getSmallUrl() {
        return this.aLi;
    }

    public void gr(String str) {
        this.aLi = str;
    }

    public boolean isPortrait() {
        return this.aLj;
    }

    public void bw(boolean z) {
        this.aLj = z;
    }
}
