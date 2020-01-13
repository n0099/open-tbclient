package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes8.dex */
public class b implements m {
    public static final BdUniqueId gin = BdUniqueId.gen();
    private int gio;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gin;
    }

    public int bAQ() {
        return this.gio;
    }

    public void sj(int i) {
        this.gio = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sj(memberGodInfo.forum_god_num.intValue());
        }
    }
}
