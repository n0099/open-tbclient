package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes23.dex */
public class b implements q {
    public static final BdUniqueId iOK = BdUniqueId.gen();
    private int iOL;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iOK;
    }

    public int cAv() {
        return this.iOL;
    }

    public void zr(int i) {
        this.iOL = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            zr(memberGodInfo.forum_god_num.intValue());
        }
    }
}
