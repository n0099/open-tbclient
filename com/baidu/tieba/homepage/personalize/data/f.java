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
    public static final BdUniqueId hQm = BdUniqueId.gen();
    private List<AlaLiveInfo> hQn = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.hQn.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !v.isEmpty(userFollowLive.user_follow_live)) {
            this.hQn.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hQm;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIw() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIy() {
        return null;
    }

    public List<AlaLiveInfo> bZW() {
        return this.hQn;
    }
}
