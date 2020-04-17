package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gVb = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo gVc;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gVb;
    }

    public MemberGroupInfo bNf() {
        return this.gVc;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.gVc = memberGroupInfo;
    }

    public void mf(boolean z) {
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
