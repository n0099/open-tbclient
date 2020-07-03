package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes10.dex */
public class b implements q {
    public static final BdUniqueId hvD = BdUniqueId.gen();
    private int hvE;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hvD;
    }

    public int bWt() {
        return this.hvE;
    }

    public void tW(int i) {
        this.hvE = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            tW(memberGodInfo.forum_god_num.intValue());
        }
    }
}
