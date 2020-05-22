package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes9.dex */
public class f extends AbsThreadDataSupport {
    public static final BdUniqueId ieX = BdUniqueId.gen();
    private List<AlaLiveInfo> ieY = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.ieY.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !v.isEmpty(userFollowLive.user_follow_live)) {
            this.ieY.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ieX;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        return null;
    }

    public List<AlaLiveInfo> cgq() {
        return this.ieY;
    }

    public an cgr() {
        an anVar = new an("c13620");
        anVar.s("uid", TbadkApplication.getCurrentAccountId());
        anVar.ag("fid", 0);
        return anVar;
    }
}
