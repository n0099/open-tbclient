package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes9.dex */
public class a extends AbsThreadDataSupport {
    public static final BdUniqueId hYI = BdUniqueId.gen();

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hYI;
    }
}
