package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes8.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId giX = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo giY;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return giX;
    }

    public MemberGroupInfo bAU() {
        return this.giY;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.giY = memberGroupInfo;
    }

    public void kR(boolean z) {
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
