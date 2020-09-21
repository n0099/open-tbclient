package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId hVK = BdUniqueId.gen();
    private int hVL;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hVK;
    }

    public int cnx() {
        return this.hVL;
    }

    public void xc(int i) {
        this.hVL = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            xc(memberGodInfo.forum_god_num.intValue());
        }
    }
}
