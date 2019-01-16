package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aCu = BdUniqueId.gen();
    private String aYb;
    private String aYc;
    private boolean aYd = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aCu;
    }

    public String LX() {
        return this.aYb;
    }

    public void hJ(String str) {
        this.aYb = str;
    }

    public String getSmallUrl() {
        return this.aYc;
    }

    public void hK(String str) {
        this.aYc = str;
    }

    public boolean isPortrait() {
        return this.aYd;
    }

    public void cm(boolean z) {
        this.aYd = z;
    }
}
