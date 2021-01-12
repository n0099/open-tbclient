package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gFV = BdUniqueId.gen();
    public bz gUu;
    public bz gUv;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gFV;
    }
}
