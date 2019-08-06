package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frh = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo fri;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frh;
    }

    public MemberGroupInfo bkI() {
        return this.fri;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.fri = memberGroupInfo;
    }

    public void jD(boolean z) {
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
