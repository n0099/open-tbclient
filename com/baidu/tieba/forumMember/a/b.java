package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes23.dex */
public class b implements q {
    public static final BdUniqueId ixh = BdUniqueId.gen();
    private int ixi;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ixh;
    }

    public int cuc() {
        return this.ixi;
    }

    public void yb(int i) {
        this.ixi = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            yb(memberGodInfo.forum_god_num.intValue());
        }
    }
}
