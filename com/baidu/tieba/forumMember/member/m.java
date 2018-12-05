package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dFc = BdUniqueId.gen();
    private boolean dDL = false;
    private MemberGroupInfo dFd;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dFc;
    }

    public MemberGroupInfo azu() {
        return this.dFd;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dFd = memberGroupInfo;
    }

    public void gk(boolean z) {
        this.dDL = z;
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
