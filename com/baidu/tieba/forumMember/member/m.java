package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frq = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo frr;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frq;
    }

    public MemberGroupInfo bix() {
        return this.frr;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.frr = memberGroupInfo;
    }

    public void ju(boolean z) {
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
