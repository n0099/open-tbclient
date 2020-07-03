package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class m implements q {
    public static final BdUniqueId agK = BdUniqueId.gen();
    private String esL;
    private String esM;
    private boolean esN = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return agK;
    }

    public String beF() {
        return this.esL;
    }

    public void yj(String str) {
        this.esL = str;
    }

    public String getSmallUrl() {
        return this.esM;
    }

    public void yk(String str) {
        this.esM = str;
    }

    public boolean beG() {
        return this.esN;
    }

    public void hY(boolean z) {
        this.esN = z;
    }
}
