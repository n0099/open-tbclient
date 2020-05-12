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
    public static final BdUniqueId hQs = BdUniqueId.gen();
    private List<AlaLiveInfo> hQt = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.hQt.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !v.isEmpty(userFollowLive.user_follow_live)) {
            this.hQt.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hQs;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIu() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIw() {
        return null;
    }

    public List<AlaLiveInfo> bZV() {
        return this.hQt;
    }
}
