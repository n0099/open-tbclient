package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gIF = BdUniqueId.gen();
    public cb gXe;
    public cb gXf;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gIF;
    }
}
