package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmT = BdUniqueId.gen();
    public static final BdUniqueId gmU = BdUniqueId.gen();
    public bw eji;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.eji == null || this.eji.biB() == null || this.eji.biB().live_type != 1) ? gmT : gmU;
    }
}
