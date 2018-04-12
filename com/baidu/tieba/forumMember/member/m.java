package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cUv = BdUniqueId.gen();
    private boolean cTg = false;
    private MemberGroupInfo cUw;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUv;
    }

    public MemberGroupInfo aok() {
        return this.cUw;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.cUw = memberGroupInfo;
    }

    public void fj(boolean z) {
        this.cTg = z;
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
