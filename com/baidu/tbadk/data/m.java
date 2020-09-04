package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class m implements q {
    public static final BdUniqueId ahM = BdUniqueId.gen();
    private boolean bTH = false;
    private String eJH;
    private String eJI;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ahM;
    }

    public String brb() {
        return this.eJH;
    }

    public void BG(String str) {
        this.eJH = str;
    }

    public String getSmallUrl() {
        return this.eJI;
    }

    public void BH(String str) {
        this.eJI = str;
    }

    public boolean brc() {
        return this.bTH;
    }

    public void jc(boolean z) {
        this.bTH = z;
    }
}
