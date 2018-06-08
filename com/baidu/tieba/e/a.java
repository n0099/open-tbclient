package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cNT = BdUniqueId.gen();
    private bd bso;

    public void setData(bd bdVar) {
        this.bso = bdVar;
    }

    public bd Sz() {
        return this.bso;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cNT;
    }
}
