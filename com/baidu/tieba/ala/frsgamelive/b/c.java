package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eBG = BdUniqueId.gen();
    public static final BdUniqueId eBH = BdUniqueId.gen();
    public bj cRf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cRf == null || this.cRf.aCH() == null || this.cRf.aCH().live_type != 1) ? eBG : eBH;
    }
}
