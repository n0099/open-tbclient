package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId eUP = BdUniqueId.gen();
    private int eUQ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUP;
    }

    public int baY() {
        return this.eUQ;
    }

    public void pD(int i) {
        this.eUQ = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            pD(memberGodInfo.forum_god_num.intValue());
        }
    }
}
