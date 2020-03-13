package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gkD = BdUniqueId.gen();
    private int gkE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gkD;
    }

    public int bCv() {
        return this.gkE;
    }

    public void sp(int i) {
        this.gkE = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sp(memberGodInfo.forum_god_num.intValue());
        }
    }
}
