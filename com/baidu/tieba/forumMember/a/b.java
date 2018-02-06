package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements i {
    public static final BdUniqueId dBi = BdUniqueId.gen();
    private int dBj;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBi;
    }

    public int atQ() {
        return this.dBj;
    }

    public void mE(int i) {
        this.dBj = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            mE(memberGodInfo.forum_god_num.intValue());
        }
    }
}
