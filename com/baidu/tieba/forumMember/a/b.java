package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dHQ = BdUniqueId.gen();
    private int dHR;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHQ;
    }

    public int aAB() {
        return this.dHR;
    }

    public void lY(int i) {
        this.dHR = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            lY(memberGodInfo.forum_god_num.intValue());
        }
    }
}
