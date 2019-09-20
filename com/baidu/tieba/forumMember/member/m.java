package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fsV = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo fsW;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsV;
    }

    public MemberGroupInfo blt() {
        return this.fsW;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.fsW = memberGroupInfo;
    }

    public void jG(boolean z) {
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
