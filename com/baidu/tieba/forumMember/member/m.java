package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cUs = BdUniqueId.gen();
    private boolean cTd = false;
    private MemberGroupInfo cUt;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUs;
    }

    public MemberGroupInfo aok() {
        return this.cUt;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.cUt = memberGroupInfo;
    }

    public void fj(boolean z) {
        this.cTd = z;
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
