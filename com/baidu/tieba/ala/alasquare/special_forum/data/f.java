package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fFZ = BdUniqueId.gen();
    public AlaInfoData fKn;
    public boolean fKo;
    public UserData mUserData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fFZ;
    }
}
