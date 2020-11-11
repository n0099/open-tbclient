package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class n implements q {
    public static final BdUniqueId aiz = BdUniqueId.gen();
    private boolean cwu = false;
    private String fmq;
    private String fmr;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return aiz;
    }

    public String byX() {
        return this.fmq;
    }

    public void Dv(String str) {
        this.fmq = str;
    }

    public String getSmallUrl() {
        return this.fmr;
    }

    public void Dw(String str) {
        this.fmr = str;
    }

    public boolean byY() {
        return this.cwu;
    }

    public void jT(boolean z) {
        this.cwu = z;
    }
}
