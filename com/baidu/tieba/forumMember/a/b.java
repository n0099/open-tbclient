package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes17.dex */
public class b implements q {
    public static final BdUniqueId hOK = BdUniqueId.gen();
    private int hOL;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hOK;
    }

    public int ckk() {
        return this.hOL;
    }

    public void wD(int i) {
        this.hOL = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            wD(memberGodInfo.forum_god_num.intValue());
        }
    }
}
