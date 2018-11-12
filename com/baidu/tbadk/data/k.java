package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId ays = BdUniqueId.gen();
    private String aTR;
    private String aTS;
    private boolean aTT = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ays;
    }

    public String KB() {
        return this.aTR;
    }

    public void hc(String str) {
        this.aTR = str;
    }

    public String getSmallUrl() {
        return this.aTS;
    }

    public void hd(String str) {
        this.aTS = str;
    }

    public boolean isPortrait() {
        return this.aTT;
    }

    public void ci(boolean z) {
        this.aTT = z;
    }
}
