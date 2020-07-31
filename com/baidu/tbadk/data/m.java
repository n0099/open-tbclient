package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class m implements q {
    public static final BdUniqueId agB = BdUniqueId.gen();
    private boolean bOf = false;
    private String ezf;
    private String ezg;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return agB;
    }

    public String bio() {
        return this.ezf;
    }

    public void zp(String str) {
        this.ezf = str;
    }

    public String getSmallUrl() {
        return this.ezg;
    }

    public void zq(String str) {
        this.ezg = str;
    }

    public boolean bip() {
        return this.bOf;
    }

    public void iC(boolean z) {
        this.bOf = z;
    }
}
