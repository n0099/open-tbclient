package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId brv = BdUniqueId.gen();
    private String brw;
    private String brx;
    private boolean bry = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return brv;
    }

    public String KF() {
        return this.brw;
    }

    public void fZ(String str) {
        this.brw = str;
    }

    public String getSmallUrl() {
        return this.brx;
    }

    public void ga(String str) {
        this.brx = str;
    }

    public boolean isPortrait() {
        return this.bry;
    }

    public void bY(boolean z) {
        this.bry = z;
    }
}
