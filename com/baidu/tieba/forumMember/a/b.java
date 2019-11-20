package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId fqH = BdUniqueId.gen();
    private int fqI;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fqH;
    }

    public int bit() {
        return this.fqI;
    }

    public void pY(int i) {
        this.fqI = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            pY(memberGodInfo.forum_god_num.intValue());
        }
    }
}
