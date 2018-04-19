package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId cTL = BdUniqueId.gen();
    private int cTM;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cTL;
    }

    public int aof() {
        return this.cTM;
    }

    public void jQ(int i) {
        this.cTM = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            jQ(memberGodInfo.forum_god_num.intValue());
        }
    }
}
