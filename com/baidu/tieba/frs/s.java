package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jlC = BdUniqueId.gen();
    private int jlD;

    public int cEx() {
        return this.jlD;
    }

    public void yQ(int i) {
        this.jlD = i;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jlC;
    }
}
