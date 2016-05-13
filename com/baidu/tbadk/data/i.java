package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class i implements v {
    public static final BdUniqueId aoj = BdUniqueId.gen();
    private String aok;
    private String aol;
    private boolean aom = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aoj;
    }

    public String AG() {
        return this.aok;
    }

    public void eW(String str) {
        this.aok = str;
    }

    public String getSmallUrl() {
        return this.aol;
    }

    public void eX(String str) {
        this.aol = str;
    }

    public boolean AH() {
        return this.aom;
    }

    public void bq(boolean z) {
        this.aom = z;
    }
}
