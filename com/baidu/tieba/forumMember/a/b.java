package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gUs = BdUniqueId.gen();
    private int gUt;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gUs;
    }

    public int bNb() {
        return this.gUt;
    }

    public void sO(int i) {
        this.gUt = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sO(memberGodInfo.forum_god_num.intValue());
        }
    }
}
