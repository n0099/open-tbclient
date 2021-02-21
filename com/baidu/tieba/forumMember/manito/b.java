package com.baidu.tieba.forumMember.manito;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes8.dex */
public class b implements n {
    public static final BdUniqueId jcm = BdUniqueId.gen();
    private int jcn;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jcm;
    }

    public int cAQ() {
        return this.jcn;
    }

    public void yi(int i) {
        this.jcn = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            yi(memberGodInfo.forum_god_num.intValue());
        }
    }
}
