package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId bri = BdUniqueId.gen();
    private String brj;
    private String brk;
    private boolean brl = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bri;
    }

    public String KE() {
        return this.brj;
    }

    public void fZ(String str) {
        this.brj = str;
    }

    public String getSmallUrl() {
        return this.brk;
    }

    public void ga(String str) {
        this.brk = str;
    }

    public boolean isPortrait() {
        return this.brl;
    }

    public void bY(boolean z) {
        this.brl = z;
    }
}
