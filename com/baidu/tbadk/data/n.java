package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class n implements q {
    public static final BdUniqueId aiz = BdUniqueId.gen();
    private boolean cqw = false;
    private String fgw;
    private String fgx;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return aiz;
    }

    public String bwy() {
        return this.fgw;
    }

    public void Dh(String str) {
        this.fgw = str;
    }

    public String getSmallUrl() {
        return this.fgx;
    }

    public void Di(String str) {
        this.fgx = str;
    }

    public boolean bwz() {
        return this.cqw;
    }

    public void jK(boolean z) {
        this.cqw = z;
    }
}
