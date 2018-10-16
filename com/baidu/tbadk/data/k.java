package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId axF = BdUniqueId.gen();
    private String aTb;
    private String aTc;
    private boolean aTd = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return axF;
    }

    public String Kp() {
        return this.aTb;
    }

    public void hb(String str) {
        this.aTb = str;
    }

    public String getSmallUrl() {
        return this.aTc;
    }

    public void hc(String str) {
        this.aTc = str;
    }

    public boolean isPortrait() {
        return this.aTd;
    }

    public void bR(boolean z) {
        this.aTd = z;
    }
}
