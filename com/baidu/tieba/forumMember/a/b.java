package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId fqy = BdUniqueId.gen();
    private int fqz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fqy;
    }

    public int bkD() {
        return this.fqz;
    }

    public void rd(int i) {
        this.fqz = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            rd(memberGodInfo.forum_god_num.intValue());
        }
    }
}
