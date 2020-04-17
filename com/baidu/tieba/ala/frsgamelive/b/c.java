package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgI = BdUniqueId.gen();
    public static final BdUniqueId fgJ = BdUniqueId.gen();
    public bj dqA;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.dqA == null || this.dqA.aKX() == null || this.dqA.aKX().live_type != 1) ? fgI : fgJ;
    }
}
