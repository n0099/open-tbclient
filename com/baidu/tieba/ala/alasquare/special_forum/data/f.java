package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eiW = BdUniqueId.gen();
    public AlaInfoData ene;
    public boolean enf;
    public UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eiW;
    }
}
