package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dfS = BdUniqueId.gen();
    private int dfT;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dfS;
    }

    public int asu() {
        return this.dfT;
    }

    public void jV(int i) {
        this.dfT = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            jV(memberGodInfo.forum_god_num.intValue());
        }
    }
}
