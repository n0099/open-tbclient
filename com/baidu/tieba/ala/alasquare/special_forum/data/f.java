package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ent = BdUniqueId.gen();
    public AlaInfoData erF;
    public boolean erG;
    public UserData mUserData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ent;
    }
}
