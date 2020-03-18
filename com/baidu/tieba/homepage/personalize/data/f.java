package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes9.dex */
public class f extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId hgC = BdUniqueId.gen();
    private List<AlaLiveInfo> hgD = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.hgD.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !v.isEmpty(userFollowLive.user_follow_live)) {
            this.hgD.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgC;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAj() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAl() {
        return null;
    }

    public List<AlaLiveInfo> bPv() {
        return this.hgD;
    }
}
