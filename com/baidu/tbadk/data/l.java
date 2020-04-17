package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class l implements m {
    public static final BdUniqueId afA = BdUniqueId.gen();
    private String dVM;
    private String dVN;
    private boolean dVO = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return afA;
    }

    public String aWv() {
        return this.dVM;
    }

    public void wh(String str) {
        this.dVM = str;
    }

    public String getSmallUrl() {
        return this.dVN;
    }

    public void wi(String str) {
        this.dVN = str;
    }

    public boolean aWw() {
        return this.dVO;
    }

    public void ht(boolean z) {
        this.dVO = z;
    }
}
