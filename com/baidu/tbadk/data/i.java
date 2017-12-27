package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId boP = BdUniqueId.gen();
    private String boQ;
    private String boR;
    private boolean boS = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return boP;
    }

    public String Ki() {
        return this.boQ;
    }

    public void fH(String str) {
        this.boQ = str;
    }

    public String getSmallUrl() {
        return this.boR;
    }

    public void fI(String str) {
        this.boR = str;
    }

    public boolean isPortrait() {
        return this.boS;
    }

    public void bV(boolean z) {
        this.boS = z;
    }
}
