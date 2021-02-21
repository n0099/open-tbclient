package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId gCD = BdUniqueId.gen();
    public boolean gGZ;
    public String gHa;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gCD;
    }
}
