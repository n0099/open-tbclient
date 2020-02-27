package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eBF = BdUniqueId.gen();
    public static final BdUniqueId eBG = BdUniqueId.gen();
    public bj cRe;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cRe == null || this.cRe.aCF() == null || this.cRe.aCF().live_type != 1) ? eBF : eBG;
    }
}
