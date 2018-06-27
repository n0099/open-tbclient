package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aqU = BdUniqueId.gen();
    private String aLe;
    private String aLf;
    private boolean aLg = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aqU;
    }

    public String He() {
        return this.aLe;
    }

    public void gt(String str) {
        this.aLe = str;
    }

    public String getSmallUrl() {
        return this.aLf;
    }

    public void gu(String str) {
        this.aLf = str;
    }

    public boolean isPortrait() {
        return this.aLg;
    }

    public void bx(boolean z) {
        this.aLg = z;
    }
}
