package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gUy = BdUniqueId.gen();
    private int gUz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gUy;
    }

    public int bMZ() {
        return this.gUz;
    }

    public void sO(int i) {
        this.gUz = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sO(memberGodInfo.forum_god_num.intValue());
        }
    }
}
