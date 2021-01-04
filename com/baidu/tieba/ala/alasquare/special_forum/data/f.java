package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gEm = BdUniqueId.gen();
    public AlaInfoData gIF;
    public boolean gIG;
    public UserData mUserData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gEm;
    }
}
