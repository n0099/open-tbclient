package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes17.dex */
public class b implements q {
    public static final BdUniqueId hOE = BdUniqueId.gen();
    private int hOF;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hOE;
    }

    public int ckj() {
        return this.hOF;
    }

    public void wD(int i) {
        this.hOF = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            wD(memberGodInfo.forum_god_num.intValue());
        }
    }
}
