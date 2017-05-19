package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId axU = BdUniqueId.gen();
    private String axV;
    private String axW;
    private boolean axX = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return axU;
    }

    public String BU() {
        return this.axV;
    }

    public void eU(String str) {
        this.axV = str;
    }

    public String getSmallUrl() {
        return this.axW;
    }

    public void eV(String str) {
        this.axW = str;
    }

    public boolean BV() {
        return this.axX;
    }

    public void bw(boolean z) {
        this.axX = z;
    }
}
