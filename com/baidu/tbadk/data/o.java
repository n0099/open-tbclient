package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId agC = BdUniqueId.gen();
    private boolean cEc = false;
    private String fAo;
    private String fAp;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return agC;
    }

    public String bAH() {
        return this.fAo;
    }

    public void CF(String str) {
        this.fAo = str;
    }

    public String getSmallUrl() {
        return this.fAp;
    }

    public void CG(String str) {
        this.fAp = str;
    }

    public boolean bAI() {
        return this.cEc;
    }

    public void kF(boolean z) {
        this.cEc = z;
    }
}
