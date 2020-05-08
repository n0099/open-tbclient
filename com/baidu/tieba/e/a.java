package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvO = BdUniqueId.gen();
    private bj agC;

    public void setData(bj bjVar) {
        this.agC = bjVar;
    }

    public bj aIu() {
        return this.agC;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvO;
    }
}
