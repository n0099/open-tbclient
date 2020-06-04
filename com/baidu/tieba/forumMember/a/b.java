package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements o {
    public static final BdUniqueId hjv = BdUniqueId.gen();
    private int hjw;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hjv;
    }

    public int bTx() {
        return this.hjw;
    }

    public void tv(int i) {
        this.hjw = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            tv(memberGodInfo.forum_god_num.intValue());
        }
    }
}
