package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId aWD = BdUniqueId.gen();
    private int height = 0;
    private int aWE = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aWD;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int LF() {
        return this.aWE;
    }

    public void fq(int i) {
        this.aWE = i;
    }
}
