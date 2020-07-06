package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hzt = BdUniqueId.gen();
    private int height = 0;
    private int hzu = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hzt;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bXQ() {
        return this.hzu;
    }

    public void uj(int i) {
        this.hzu = i;
    }
}
