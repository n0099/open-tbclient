package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dEs = BdUniqueId.gen();
    private int dEt;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dEs;
    }

    public int azp() {
        return this.dEt;
    }

    public void lK(int i) {
        this.dEt = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            lK(memberGodInfo.forum_god_num.intValue());
        }
    }
}
