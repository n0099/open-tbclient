package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hCX = BdUniqueId.gen();
    private int hCY;

    public int bZM() {
        return this.hCY;
    }

    public void uE(int i) {
        this.hCY = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hCX;
    }
}
