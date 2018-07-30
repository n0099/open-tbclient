package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId diI = BdUniqueId.gen();
    private int diJ;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return diI;
    }

    public int asY() {
        return this.diJ;
    }

    public void kg(int i) {
        this.diJ = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            kg(memberGodInfo.forum_god_num.intValue());
        }
    }
}
