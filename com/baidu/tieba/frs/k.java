package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId czR = BdUniqueId.gen();
    private int czS;

    public int akm() {
        return this.czS;
    }

    public void ju(int i) {
        this.czS = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return czR;
    }
}
