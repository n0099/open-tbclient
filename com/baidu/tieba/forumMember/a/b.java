package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements m {
    public static final BdUniqueId gll = BdUniqueId.gen();
    private int glm;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gll;
    }

    public int bCB() {
        return this.glm;
    }

    public void sr(int i) {
        this.glm = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            sr(memberGodInfo.forum_god_num.intValue());
        }
    }
}
