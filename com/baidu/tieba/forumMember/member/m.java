package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIA = BdUniqueId.gen();
    private boolean dHj = false;
    private MemberGroupInfo dIB;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIA;
    }

    public MemberGroupInfo aAG() {
        return this.dIB;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dIB = memberGroupInfo;
    }

    public void gp(boolean z) {
        this.dHj = z;
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
