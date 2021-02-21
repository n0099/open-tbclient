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
    public static final BdUniqueId klI = BdUniqueId.gen();
    private List<AlaLiveInfo> klJ = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.klJ.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !y.isEmpty(userFollowLive.user_follow_live)) {
            this.klJ.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return klI;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        return null;
    }

    public List<AlaLiveInfo> cRJ() {
        return this.klJ;
    }

    public ar cRK() {
        ar arVar = new ar("c13620");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.ap("fid", 0);
        return arVar;
    }
}
