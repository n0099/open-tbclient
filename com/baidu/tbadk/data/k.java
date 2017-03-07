package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId axF = BdUniqueId.gen();
    private String axG;
    private String axH;
    private boolean axI = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return axF;
    }

    public String Cr() {
        return this.axG;
    }

    public void eR(String str) {
        this.axG = str;
    }

    public String getSmallUrl() {
        return this.axH;
    }

    public void eS(String str) {
        this.axH = str;
    }

    public boolean Cs() {
        return this.axI;
    }

    public void bu(boolean z) {
        this.axI = z;
    }
}
