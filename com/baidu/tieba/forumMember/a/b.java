package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes23.dex */
public class b implements q {
    public static final BdUniqueId ikJ = BdUniqueId.gen();
    private int ikK;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ikJ;
    }

    public int cqV() {
        return this.ikK;
    }

    public void xI(int i) {
        this.ikK = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            xI(memberGodInfo.forum_god_num.intValue());
        }
    }
}
