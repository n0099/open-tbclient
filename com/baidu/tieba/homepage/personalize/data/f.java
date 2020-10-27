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
/* loaded from: classes22.dex */
public class f extends AbsThreadDataSupport {
    public static final BdUniqueId jAe = BdUniqueId.gen();
    private List<AlaLiveInfo> jAf = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.jAf.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !y.isEmpty(userFollowLive.user_follow_live)) {
            this.jAf.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jAe;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return null;
    }

    public List<AlaLiveInfo> cIS() {
        return this.jAf;
    }

    public aq cIT() {
        aq aqVar = new aq("c13620");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.aj("fid", 0);
        return aqVar;
    }
}
