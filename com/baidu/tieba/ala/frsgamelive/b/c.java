package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgN = BdUniqueId.gen();
    public static final BdUniqueId fgO = BdUniqueId.gen();
    public bj dqE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.dqE == null || this.dqE.aKV() == null || this.dqE.aKV().live_type != 1) ? fgN : fgO;
    }
}
