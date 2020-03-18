package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eCp = BdUniqueId.gen();
    public static final BdUniqueId eCq = BdUniqueId.gen();
    public bj cRt;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cRt == null || this.cRt.aCK() == null || this.cRt.aCK().live_type != 1) ? eCp : eCq;
    }
}
