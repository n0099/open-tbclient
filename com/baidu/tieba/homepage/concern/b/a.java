package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes9.dex */
public class a extends AbsThreadDataSupport {
    public static final BdUniqueId inm = BdUniqueId.gen();

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inm;
    }
}
