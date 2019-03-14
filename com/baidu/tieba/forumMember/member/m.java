package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eVM = BdUniqueId.gen();
    private MemberGroupInfo eVN;
    private String forumId;
    private String forumName;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVM;
    }

    public MemberGroupInfo bbf() {
        return this.eVN;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.eVN = memberGroupInfo;
    }

    public void iL(boolean z) {
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
