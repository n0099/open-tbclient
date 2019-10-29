package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes5.dex */
public class b implements m {
    public static final BdUniqueId frz = BdUniqueId.gen();
    private int frA;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frz;
    }

    public int biv() {
        return this.frA;
    }

    public void pZ(int i) {
        this.frA = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            pZ(memberGodInfo.forum_god_num.intValue());
        }
    }
}
