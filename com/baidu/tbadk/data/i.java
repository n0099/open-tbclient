package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId boY = BdUniqueId.gen();
    private String boZ;
    private String bpa;
    private boolean bpb = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return boY;
    }

    public String JX() {
        return this.boZ;
    }

    public void fI(String str) {
        this.boZ = str;
    }

    public String getSmallUrl() {
        return this.bpa;
    }

    public void fJ(String str) {
        this.bpa = str;
    }

    public boolean isPortrait() {
        return this.bpb;
    }

    public void bT(boolean z) {
        this.bpb = z;
    }
}
