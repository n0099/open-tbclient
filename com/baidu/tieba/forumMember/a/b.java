package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dea = BdUniqueId.gen();
    private int deb;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dea;
    }

    public int asj() {
        return this.deb;
    }

    public void jS(int i) {
        this.deb = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            jS(memberGodInfo.forum_god_num.intValue());
        }
    }
}
