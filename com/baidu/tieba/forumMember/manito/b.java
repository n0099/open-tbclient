package com.baidu.tieba.forumMember.manito;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes8.dex */
public class b implements n {
    public static final BdUniqueId jaY = BdUniqueId.gen();
    private int jaZ;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jaY;
    }

    public int cDq() {
        return this.jaZ;
    }

    public void zE(int i) {
        this.jaZ = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            zE(memberGodInfo.forum_god_num.intValue());
        }
    }
}
