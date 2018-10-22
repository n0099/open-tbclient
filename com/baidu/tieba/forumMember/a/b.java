package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dwB = BdUniqueId.gen();
    private int dwC;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dwB;
    }

    public int ayi() {
        return this.dwC;
    }

    public void lc(int i) {
        this.dwC = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            lc(memberGodInfo.forum_god_num.intValue());
        }
    }
}
