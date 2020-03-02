package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gkq = BdUniqueId.gen();
    private int gkr;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gkq;
    }

    public int bCu() {
        return this.gkr;
    }

    public void sp(int i) {
        this.gkr = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sp(memberGodInfo.forum_god_num.intValue());
        }
    }
}
