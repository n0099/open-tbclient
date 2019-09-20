package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId fsm = BdUniqueId.gen();
    private int fsn;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsm;
    }

    public int blo() {
        return this.fsn;
    }

    public void rg(int i) {
        this.fsn = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            rg(memberGodInfo.forum_god_num.intValue());
        }
    }
}
