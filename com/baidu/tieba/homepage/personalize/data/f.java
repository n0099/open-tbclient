package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes2.dex */
public class f extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId khQ = BdUniqueId.gen();
    private List<AlaLiveInfo> khR = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.khR.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !x.isEmpty(userFollowLive.user_follow_live)) {
            this.khR.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return khQ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boO() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boQ() {
        return null;
    }

    public List<AlaLiveInfo> cTu() {
        return this.khR;
    }

    public aq cTv() {
        aq aqVar = new aq("c13620");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.an("fid", 0);
        return aqVar;
    }
}
