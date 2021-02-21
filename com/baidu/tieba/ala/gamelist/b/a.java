package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gIT = BdUniqueId.gen();
    public cb gXs;
    public cb gXt;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gIT;
    }
}
