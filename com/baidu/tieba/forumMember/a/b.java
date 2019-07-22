package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId fpZ = BdUniqueId.gen();
    private int fqa;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fpZ;
    }

    public int bkw() {
        return this.fqa;
    }

    public void rb(int i) {
        this.fqa = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            rb(memberGodInfo.forum_god_num.intValue());
        }
    }
}
