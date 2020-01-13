package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exw = BdUniqueId.gen();
    public static final BdUniqueId exx = BdUniqueId.gen();
    public bj cNb;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cNb == null || this.cNb.aAq() == null || this.cNb.aAq().live_type != 1) ? exw : exx;
    }
}
