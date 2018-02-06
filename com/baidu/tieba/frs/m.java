package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGK = BdUniqueId.gen();
    private int dGL;

    public int awf() {
        return this.dGL;
    }

    public void mW(int i) {
        this.dGL = i;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGK;
    }
}
