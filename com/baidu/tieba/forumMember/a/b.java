package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements o {
    public static final BdUniqueId hjk = BdUniqueId.gen();
    private int hjl;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hjk;
    }

    public int bTv() {
        return this.hjl;
    }

    public void tt(int i) {
        this.hjl = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            tt(memberGodInfo.forum_god_num.intValue());
        }
    }
}
