package com.baidu.tieba.ala.gamelist.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gKB = BdUniqueId.gen();
    public bz gZa;
    public bz gZb;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gKB;
    }
}
