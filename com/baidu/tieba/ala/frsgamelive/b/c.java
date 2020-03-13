package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eBT = BdUniqueId.gen();
    public static final BdUniqueId eBU = BdUniqueId.gen();
    public bj cRg;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cRg == null || this.cRg.aCH() == null || this.cRg.aCH().live_type != 1) ? eBT : eBU;
    }
}
