package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId iDS = BdUniqueId.gen();
    private int iDT;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iDS;
    }

    public int cwg() {
        return this.iDT;
    }

    public void yM(int i) {
        this.iDT = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            yM(memberGodInfo.forum_god_num.intValue());
        }
    }
}
