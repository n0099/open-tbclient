package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class n implements q {
    public static final BdUniqueId aih = BdUniqueId.gen();
    private boolean bVH = false;
    private String eLT;
    private String eLU;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return aih;
    }

    public String brV() {
        return this.eLT;
    }

    public void Cc(String str) {
        this.eLT = str;
    }

    public String getSmallUrl() {
        return this.eLU;
    }

    public void Cd(String str) {
        this.eLU = str;
    }

    public boolean brW() {
        return this.bVH;
    }

    public void iZ(boolean z) {
        this.bVH = z;
    }
}
