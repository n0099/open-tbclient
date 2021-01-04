package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ahE = BdUniqueId.gen();
    private boolean cGs = false;
    private String fCG;
    private String fCH;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ahE;
    }

    public String bEi() {
        return this.fCG;
    }

    public void DA(String str) {
        this.fCG = str;
    }

    public String getSmallUrl() {
        return this.fCH;
    }

    public void DB(String str) {
        this.fCH = str;
    }

    public boolean bEj() {
        return this.cGs;
    }

    public void kG(boolean z) {
        this.cGs = z;
    }
}
