package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes7.dex */
public class b implements m {
    public static final BdUniqueId gfd = BdUniqueId.gen();
    private int gfe;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfd;
    }

    public int bzO() {
        return this.gfe;
    }

    public void se(int i) {
        this.gfe = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            se(memberGodInfo.forum_god_num.intValue());
        }
    }
}
