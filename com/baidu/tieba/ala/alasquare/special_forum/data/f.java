package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dxX = BdUniqueId.gen();
    public AlaInfoData dBZ;
    public boolean dCa;
    public UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dxX;
    }
}
