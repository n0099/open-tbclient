package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes9.dex */
public class f extends AbsThreadDataSupport {
    public static final BdUniqueId iuV = BdUniqueId.gen();
    private List<AlaLiveInfo> iuW = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.iuW.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !w.isEmpty(userFollowLive.user_follow_live)) {
            this.iuW.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iuV;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return null;
    }

    public List<AlaLiveInfo> cka() {
        return this.iuW;
    }

    public ao ckb() {
        ao aoVar = new ao("c13620");
        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
        aoVar.ag("fid", 0);
        return aoVar;
    }
}
