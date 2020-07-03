package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpr = BdUniqueId.gen();
    public AlaInfoData ftK;
    public boolean ftL;
    public UserData mUserData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fpr;
    }
}
