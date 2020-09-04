package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes16.dex */
public class f extends AbsThreadDataSupport {
    public static final BdUniqueId iPZ = BdUniqueId.gen();
    private List<AlaLiveInfo> iQa = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.iQa.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !y.isEmpty(userFollowLive.user_follow_live)) {
            this.iQa.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPZ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        return null;
    }

    public List<AlaLiveInfo> cyv() {
        return this.iQa;
    }

    public aq cyw() {
        aq aqVar = new aq("c13620");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.ai("fid", 0);
        return aqVar;
    }
}
