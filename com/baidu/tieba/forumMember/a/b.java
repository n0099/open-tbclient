package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements i {
    public static final BdUniqueId dAW = BdUniqueId.gen();
    private int dAX;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dAW;
    }

    public int atP() {
        return this.dAX;
    }

    public void mE(int i) {
        this.dAX = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            mE(memberGodInfo.forum_god_num.intValue());
        }
    }
}
