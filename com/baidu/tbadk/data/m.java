package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes2.dex */
public class m implements q {
    public static final BdUniqueId ahK = BdUniqueId.gen();
    private boolean bTD = false;
    private String eJD;
    private String eJE;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ahK;
    }

    public String bra() {
        return this.eJD;
    }

    public void BF(String str) {
        this.eJD = str;
    }

    public String getSmallUrl() {
        return this.eJE;
    }

    public void BG(String str) {
        this.eJE = str;
    }

    public boolean brb() {
        return this.bTD;
    }

    public void ja(boolean z) {
        this.bTD = z;
    }
}
