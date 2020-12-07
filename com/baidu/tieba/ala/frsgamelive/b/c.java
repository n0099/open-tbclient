package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gLq = BdUniqueId.gen();
    public static final BdUniqueId gLr = BdUniqueId.gen();
    public by eCR;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.eCR == null || this.eCR.bpj() == null || this.eCR.bpj().live_type != 1) ? gLq : gLr;
    }
}
