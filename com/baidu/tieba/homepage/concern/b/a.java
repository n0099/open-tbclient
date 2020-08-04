package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes16.dex */
public class a extends AbsThreadDataSupport {
    public static final BdUniqueId itr = BdUniqueId.gen();

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return itr;
    }
}
