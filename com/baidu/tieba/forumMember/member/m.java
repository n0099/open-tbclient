package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cVz = BdUniqueId.gen();
    private boolean cUk = false;
    private MemberGroupInfo cVA;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cVz;
    }

    public MemberGroupInfo aoj() {
        return this.cVA;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.cVA = memberGroupInfo;
    }

    public void fk(boolean z) {
        this.cUk = z;
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
