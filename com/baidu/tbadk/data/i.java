package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aBK = BdUniqueId.gen();
    private String aBL;
    private String aBM;
    private boolean aBN = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBK;
    }

    public String Dl() {
        return this.aBL;
    }

    public void fQ(String str) {
        this.aBL = str;
    }

    public String getSmallUrl() {
        return this.aBM;
    }

    public void fR(String str) {
        this.aBM = str;
    }

    public boolean isPortrait() {
        return this.aBN;
    }

    public void bq(boolean z) {
        this.aBN = z;
    }
}
