package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eTR = BdUniqueId.gen();
    private bh cdk;

    public void setData(bh bhVar) {
        this.cdk = bhVar;
    }

    public bh acC() {
        return this.cdk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eTR;
    }
}
