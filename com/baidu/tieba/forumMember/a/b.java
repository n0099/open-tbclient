package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.GetMemberInfo.MemberGodInfo;
/* loaded from: classes3.dex */
public class b implements h {
    public static final BdUniqueId diG = BdUniqueId.gen();
    private int diH;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return diG;
    }

    public int asX() {
        return this.diH;
    }

    public void kf(int i) {
        this.diH = i;
    }

    public void a(MemberGodInfo memberGodInfo) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0) {
            kf(memberGodInfo.forum_god_num.intValue());
        }
    }
}
