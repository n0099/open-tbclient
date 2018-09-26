package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId doz = BdUniqueId.gen();
    private int doA;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doz;
    }

    public int auL() {
        return this.doA;
    }

    public void kE(int i) {
        this.doA = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            kE(memberGodInfo.forum_god_num.intValue());
        }
    }
}
