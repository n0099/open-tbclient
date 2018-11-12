package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId dxT = BdUniqueId.gen();
    private int dxU;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dxT;
    }

    public int axF() {
        return this.dxU;
    }

    public void lu(int i) {
        this.dxU = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            lu(memberGodInfo.forum_god_num.intValue());
        }
    }
}
