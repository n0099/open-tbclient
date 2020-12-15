package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId gtn = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gtn;
    }
}
