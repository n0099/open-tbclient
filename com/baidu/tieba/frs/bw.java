package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bw implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId bin = BdUniqueId.gen();
    private int height = 0;
    private int bio = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bin;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int PH() {
        return this.bio;
    }

    public void gr(int i) {
        this.bio = i;
    }
}
