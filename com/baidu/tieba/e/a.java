package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvI = BdUniqueId.gen();
    private bj agz;

    public void setData(bj bjVar) {
        this.agz = bjVar;
    }

    public bj aIw() {
        return this.agz;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvI;
    }
}
