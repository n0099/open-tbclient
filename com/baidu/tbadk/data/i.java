package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aBL = BdUniqueId.gen();
    private String aBM;
    private String aBN;
    private boolean aBO = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBL;
    }

    public String Dj() {
        return this.aBM;
    }

    public void fQ(String str) {
        this.aBM = str;
    }

    public String getSmallUrl() {
        return this.aBN;
    }

    public void fR(String str) {
        this.aBN = str;
    }

    public boolean isPortrait() {
        return this.aBO;
    }

    public void bq(boolean z) {
        this.aBO = z;
    }
}
