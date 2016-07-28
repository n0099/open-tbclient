package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId apP = BdUniqueId.gen();
    private String PK;
    private String PM;
    private boolean apQ = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return apP;
    }

    public String AP() {
        return this.PM;
    }

    public void fa(String str) {
        this.PM = str;
    }

    public String getSmallUrl() {
        return this.PK;
    }

    public void fb(String str) {
        this.PK = str;
    }

    public boolean AQ() {
        return this.apQ;
    }

    public void bq(boolean z) {
        this.apQ = z;
    }
}
