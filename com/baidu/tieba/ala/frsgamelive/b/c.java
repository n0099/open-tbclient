package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dIP = BdUniqueId.gen();
    public static final BdUniqueId dIQ = BdUniqueId.gen();
    public bh cbq;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cbq == null || this.cbq.aiZ() == null || this.cbq.aiZ().live_type != 1) ? dIP : dIQ;
    }
}
