package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes.dex */
public class m implements o {
    public static final BdUniqueId afZ = BdUniqueId.gen();
    private String eka;
    private String ekb;
    private boolean ekc = false;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return afZ;
    }

    public String bcC() {
        return this.eka;
    }

    public void xQ(String str) {
        this.eka = str;
    }

    public String getSmallUrl() {
        return this.ekb;
    }

    public void xR(String str) {
        this.ekb = str;
    }

    public boolean bcD() {
        return this.ekc;
    }

    public void hP(boolean z) {
        this.ekc = z;
    }
}
