package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fNI = BdUniqueId.gen();
    private bj Np;

    public void setData(bj bjVar) {
        this.Np = bjVar;
    }

    public bj axQ() {
        return this.Np;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNI;
    }
}
