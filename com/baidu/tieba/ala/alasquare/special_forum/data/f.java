package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId gzF = BdUniqueId.gen();
    public AlaInfoData gDZ;
    public boolean gEa;
    public UserData mUserData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gzF;
    }
}
