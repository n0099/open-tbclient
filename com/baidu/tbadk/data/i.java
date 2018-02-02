package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId bph = BdUniqueId.gen();
    private String bpi;
    private String bpj;
    private boolean bpk = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bph;
    }

    public String JZ() {
        return this.bpi;
    }

    public void fQ(String str) {
        this.bpi = str;
    }

    public String getSmallUrl() {
        return this.bpj;
    }

    public void fR(String str) {
        this.bpj = str;
    }

    public boolean isPortrait() {
        return this.bpk;
    }

    public void bU(boolean z) {
        this.bpk = z;
    }
}
