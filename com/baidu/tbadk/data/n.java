package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class n implements q {
    public static final BdUniqueId aiy = BdUniqueId.gen();
    private boolean chV = false;
    private String eYa;
    private String eYb;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return aiy;
    }

    public String buF() {
        return this.eYa;
    }

    public void CO(String str) {
        this.eYa = str;
    }

    public String getSmallUrl() {
        return this.eYb;
    }

    public void CP(String str) {
        this.eYb = str;
    }

    public boolean buG() {
        return this.chV;
    }

    public void jx(boolean z) {
        this.chV = z;
    }
}
