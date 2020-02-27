package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gko = BdUniqueId.gen();
    private int gkp;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gko;
    }

    public int bCs() {
        return this.gkp;
    }

    public void sp(int i) {
        this.gkp = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sp(memberGodInfo.forum_god_num.intValue());
        }
    }
}
