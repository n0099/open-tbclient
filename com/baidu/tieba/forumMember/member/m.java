package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eVy = BdUniqueId.gen();
    private MemberGroupInfo eVz;
    private String forumId;
    private String forumName;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVy;
    }

    public MemberGroupInfo bbd() {
        return this.eVz;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.eVz = memberGroupInfo;
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
