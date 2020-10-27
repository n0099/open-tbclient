package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class a extends AbsThreadDataSupport {
    public static final BdUniqueId jqU = BdUniqueId.gen();

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jqU;
    }
}
