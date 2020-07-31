package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes17.dex */
public class b implements q {
    public static final BdUniqueId hBp = BdUniqueId.gen();
    private int hBq;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hBp;
    }

    public int bZN() {
        return this.hBq;
    }

    public void uo(int i) {
        this.hBq = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            uo(memberGodInfo.forum_god_num.intValue());
        }
    }
}
