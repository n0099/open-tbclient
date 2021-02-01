package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jjF = BdUniqueId.gen();
    private int jjG;

    public int cEk() {
        return this.jjG;
    }

    public void yP(int i) {
        this.jjG = i;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jjF;
    }
}
