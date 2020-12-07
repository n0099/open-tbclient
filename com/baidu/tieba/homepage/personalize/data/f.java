package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.UserFollowLive;
/* loaded from: classes22.dex */
public class f extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId jUD = BdUniqueId.gen();
    private List<AlaLiveInfo> jUE = new ArrayList();

    public void a(UserFollowLive userFollowLive) {
        this.jUE.clear();
        if (userFollowLive != null && userFollowLive._switch.intValue() != 0 && !y.isEmpty(userFollowLive.user_follow_live)) {
            this.jUE.addAll(userFollowLive.user_follow_live);
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jUD;
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        return null;
    }

    public List<AlaLiveInfo> cQn() {
        return this.jUE;
    }

    public ar cQo() {
        ar arVar = new ar("c13620");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.al("fid", 0);
        return arVar;
    }
}
