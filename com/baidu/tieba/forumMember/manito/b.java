package com.baidu.tieba.forumMember.manito;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes7.dex */
public class b implements n {
    public static final BdUniqueId jdV = BdUniqueId.gen();
    private int jdW;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdV;
    }

    public int cAW() {
        return this.jdW;
    }

    public void yj(int i) {
        this.jdW = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            yj(memberGodInfo.forum_god_num.intValue());
        }
    }
}
