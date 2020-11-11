package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iGY = BdUniqueId.gen();
    private int height = 0;
    private int iGZ = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iGY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cyb() {
        return this.iGZ;
    }

    public void yB(int i) {
        this.iGZ = i;
    }
}
