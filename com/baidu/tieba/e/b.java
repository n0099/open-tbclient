package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSe = BdUniqueId.gen();
    private bg ccj;

    public void setData(bg bgVar) {
        this.ccj = bgVar;
    }

    public bg acx() {
        return this.ccj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSe;
    }
}
