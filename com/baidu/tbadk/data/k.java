package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId axG = BdUniqueId.gen();
    private String axH;
    private String axI;
    private boolean axJ = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return axG;
    }

    public String BO() {
        return this.axH;
    }

    public void eS(String str) {
        this.axH = str;
    }

    public String getSmallUrl() {
        return this.axI;
    }

    public void eT(String str) {
        this.axI = str;
    }

    public boolean BP() {
        return this.axJ;
    }

    public void bt(boolean z) {
        this.axJ = z;
    }
}
