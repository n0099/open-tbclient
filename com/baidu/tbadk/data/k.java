package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId ayI = BdUniqueId.gen();
    private String ayJ;
    private String ayK;
    private boolean ayL = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ayI;
    }

    public String Ci() {
        return this.ayJ;
    }

    public void fm(String str) {
        this.ayJ = str;
    }

    public String getSmallUrl() {
        return this.ayK;
    }

    public void fn(String str) {
        this.ayK = str;
    }

    public boolean Cj() {
        return this.ayL;
    }

    public void bu(boolean z) {
        this.ayL = z;
    }
}
