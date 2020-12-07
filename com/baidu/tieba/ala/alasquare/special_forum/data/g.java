package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId gtl = BdUniqueId.gen();
    public boolean gxC;
    public String gxD;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gtl;
    }
}
