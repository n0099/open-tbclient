package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hdm = BdUniqueId.gen();
    private bv aii;

    public void setData(bv bvVar) {
        this.aii = bvVar;
    }

    public bv aTN() {
        return this.aii;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdm;
    }
}
