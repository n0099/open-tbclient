package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKy = BdUniqueId.gen();
    private bj Nl;

    public void setData(bj bjVar) {
        this.Nl = bjVar;
    }

    public bj axx() {
        return this.Nl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKy;
    }
}
