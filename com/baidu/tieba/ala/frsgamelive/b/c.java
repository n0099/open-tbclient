package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXk = BdUniqueId.gen();
    public static final BdUniqueId fXl = BdUniqueId.gen();
    public bw dUS;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.dUS == null || this.dUS.beY() == null || this.dUS.beY().live_type != 1) ? fXk : fXl;
    }
}
