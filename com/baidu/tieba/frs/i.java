package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dlY = BdUniqueId.gen();
    private int height = 0;
    private int dlZ = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dlY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aub() {
        return this.dlZ;
    }

    public void kp(int i) {
        this.dlZ = i;
    }
}
