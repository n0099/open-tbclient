package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exN = BdUniqueId.gen();
    private bg bTl;

    public void setData(bg bgVar) {
        this.bTl = bgVar;
    }

    public bg WR() {
        return this.bTl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exN;
    }
}
