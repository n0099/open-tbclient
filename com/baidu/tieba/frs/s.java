package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jjT = BdUniqueId.gen();
    private int jjU;

    public int cEr() {
        return this.jjU;
    }

    public void yP(int i) {
        this.jjU = i;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jjT;
    }
}
