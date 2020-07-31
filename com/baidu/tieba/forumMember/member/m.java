package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes17.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hBX = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo hBY;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hBX;
    }

    public MemberGroupInfo bZR() {
        return this.hBY;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hBY = memberGroupInfo;
    }

    public void nq(boolean z) {
        this.isLast = z;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
