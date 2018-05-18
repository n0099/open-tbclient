package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId cUP = BdUniqueId.gen();
    private int cUQ;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUP;
    }

    public int aoe() {
        return this.cUQ;
    }

    public void jP(int i) {
        this.cUQ = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            jP(memberGodInfo.forum_god_num.intValue());
        }
    }
}
