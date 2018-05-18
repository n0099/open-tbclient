package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cFe = BdUniqueId.gen();
    private bd bkk;

    public void setData(bd bdVar) {
        this.bkk = bdVar;
    }

    public bd Pb() {
        return this.bkk;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFe;
    }
}
