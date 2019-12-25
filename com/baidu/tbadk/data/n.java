package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Mh = BdUniqueId.gen();
    private String drl;
    private String drm;
    private boolean drn = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Mh;
    }

    public String aLi() {
        return this.drl;
    }

    public void ux(String str) {
        this.drl = str;
    }

    public String getSmallUrl() {
        return this.drm;
    }

    public void uy(String str) {
        this.drm = str;
    }

    public boolean aLj() {
        return this.drn;
    }

    public void gi(boolean z) {
        this.drn = z;
    }
}
