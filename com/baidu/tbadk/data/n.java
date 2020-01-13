package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId Mm = BdUniqueId.gen();
    private String drx;
    private String dry;
    private boolean drz = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Mm;
    }

    public String aLB() {
        return this.drx;
    }

    public void uC(String str) {
        this.drx = str;
    }

    public String getSmallUrl() {
        return this.dry;
    }

    public void uD(String str) {
        this.dry = str;
    }

    public boolean aLC() {
        return this.drz;
    }

    public void gn(boolean z) {
        this.drz = z;
    }
}
