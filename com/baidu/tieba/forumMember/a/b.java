package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dHg = BdUniqueId.gen();
    private int dHh;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHg;
    }

    public int aAe() {
        return this.dHh;
    }

    public void lX(int i) {
        this.dHh = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            lX(memberGodInfo.forum_god_num.intValue());
        }
    }
}
