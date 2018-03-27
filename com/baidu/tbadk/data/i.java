package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId brl = BdUniqueId.gen();
    private String brm;
    private String brn;
    private boolean bro = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return brl;
    }

    public String KF() {
        return this.brm;
    }

    public void fZ(String str) {
        this.brm = str;
    }

    public String getSmallUrl() {
        return this.brn;
    }

    public void ga(String str) {
        this.brn = str;
    }

    public boolean isPortrait() {
        return this.bro;
    }

    public void bY(boolean z) {
        this.bro = z;
    }
}
