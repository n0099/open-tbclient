package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId gAw = BdUniqueId.gen();
    public bz gAx;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAw;
    }

    public bz boO() {
        return this.gAx;
    }

    public aq aA(String str, boolean z) {
        bz boO = boO();
        if (boO == null || boO.eVx == null) {
            return null;
        }
        return new aq(str).w("obj_locate", boO.eVx.eOH);
    }
}
