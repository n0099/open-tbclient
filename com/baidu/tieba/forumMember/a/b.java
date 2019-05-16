package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId fla = BdUniqueId.gen();
    private int flb;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fla;
    }

    public int bir() {
        return this.flb;
    }

    public void qJ(int i) {
        this.flb = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            qJ(memberGodInfo.forum_god_num.intValue());
        }
    }
}
