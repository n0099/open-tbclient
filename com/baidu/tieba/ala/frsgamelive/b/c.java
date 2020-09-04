package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXo = BdUniqueId.gen();
    public static final BdUniqueId fXp = BdUniqueId.gen();
    public bw dUW;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.dUW == null || this.dUW.beY() == null || this.dUW.beY().live_type != 1) ? fXo : fXp;
    }
}
