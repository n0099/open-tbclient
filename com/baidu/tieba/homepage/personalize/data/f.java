package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes16.dex */
public class f extends AbsThreadDataSupport {
    public static final BdUniqueId iAZ = BdUniqueId.gen();
    private List<AlaLiveInfo> iBa = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.iBa.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !x.isEmpty(userFollowLive.user_follow_live)) {
            this.iBa.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iAZ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return null;
    }

    public List<AlaLiveInfo> cnB() {
        return this.iBa;
    }

    public ap cnC() {
        ap apVar = new ap("c13620");
        apVar.t("uid", TbadkApplication.getCurrentAccountId());
        apVar.ah("fid", 0);
        return apVar;
    }
}
