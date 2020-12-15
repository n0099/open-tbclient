package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gtn = BdUniqueId.gen();
    public AlaInfoData gxC;
    public boolean gxD;
    public UserData mUserData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gtn;
    }
}
