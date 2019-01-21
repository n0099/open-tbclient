package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aCv = BdUniqueId.gen();
    private String aYc;
    private String aYd;
    private boolean aYe = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aCv;
    }

    public String LX() {
        return this.aYc;
    }

    public void hJ(String str) {
        this.aYc = str;
    }

    public String getSmallUrl() {
        return this.aYd;
    }

    public void hK(String str) {
        this.aYd = str;
    }

    public boolean isPortrait() {
        return this.aYe;
    }

    public void cm(boolean z) {
        this.aYe = z;
    }
}
