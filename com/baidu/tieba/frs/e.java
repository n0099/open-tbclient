package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cju = BdUniqueId.gen();
    private int height = 0;
    private int cjv = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cju;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int afl() {
        return this.cjv;
    }

    public void iC(int i) {
        this.cjv = i;
    }
}
