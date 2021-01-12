package com.baidu.tieba.forumMember.manito;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes7.dex */
public class b implements n {
    public static final BdUniqueId iWr = BdUniqueId.gen();
    private int iWs;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iWr;
    }

    public int czy() {
        return this.iWs;
    }

    public void xY(int i) {
        this.iWs = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            xY(memberGodInfo.forum_god_num.intValue());
        }
    }
}
