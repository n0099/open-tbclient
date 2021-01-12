package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId agN = BdUniqueId.gen();
    private boolean cBG = false;
    private String fxY;
    private String fxZ;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return agN;
    }

    public String bAp() {
        return this.fxY;
    }

    public void Co(String str) {
        this.fxY = str;
    }

    public String getSmallUrl() {
        return this.fxZ;
    }

    public void Cp(String str) {
        this.fxZ = str;
    }

    public boolean bAq() {
        return this.cBG;
    }

    public void kC(boolean z) {
        this.cBG = z;
    }
}
