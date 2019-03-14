package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId eVd = BdUniqueId.gen();
    private int eVe;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVd;
    }

    public int bba() {
        return this.eVe;
    }

    public void pH(int i) {
        this.eVe = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            pH(memberGodInfo.forum_god_num.intValue());
        }
    }
}
