package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hjT = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo hjU;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hjT;
    }

    public MemberGroupInfo bTz() {
        return this.hjU;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hjU = memberGroupInfo;
    }

    public void mA(boolean z) {
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
