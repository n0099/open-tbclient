package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ahU = BdUniqueId.gen();
    private boolean cFC = false;
    private String fBN;
    private String fBO;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ahU;
    }

    public String bAK() {
        return this.fBN;
    }

    public void CM(String str) {
        this.fBN = str;
    }

    public String getSmallUrl() {
        return this.fBO;
    }

    public void CN(String str) {
        this.fBO = str;
    }

    public boolean bAL() {
        return this.cFC;
    }

    public void kF(boolean z) {
        this.cFC = z;
    }
}
