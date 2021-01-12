package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId gvP = BdUniqueId.gen();
    public bz gvQ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gvP;
    }

    public bz bkV() {
        return this.gvQ;
    }

    public aq aA(String str, boolean z) {
        bz bkV = bkV();
        if (bkV == null || bkV.eQM == null) {
            return null;
        }
        return new aq(str).w("obj_locate", bkV.eQM.eJW);
    }
}
