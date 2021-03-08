package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes2.dex */
public class f extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId knK = BdUniqueId.gen();
    private List<AlaLiveInfo> knL = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.knL.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !y.isEmpty(userFollowLive.user_follow_live)) {
            this.knL.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return knK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        return null;
    }

    public List<AlaLiveInfo> cRQ() {
        return this.knL;
    }

    public ar cRR() {
        ar arVar = new ar("c13620");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.aq("fid", 0);
        return arVar;
    }
}
