package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes23.dex */
public class b implements q {
    public static final BdUniqueId iDe = BdUniqueId.gen();
    private int iDf;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iDe;
    }

    public int cwD() {
        return this.iDf;
    }

    public void yo(int i) {
        this.iDf = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            yo(memberGodInfo.forum_god_num.intValue());
        }
    }
}
