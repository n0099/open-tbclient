package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gwY = BdUniqueId.gen();
    public static final BdUniqueId gwZ = BdUniqueId.gen();
    public bw erH;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.erH == null || this.erH.bku() == null || this.erH.bku().live_type != 1) ? gwY : gwZ;
    }
}
