package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dHQ = BdUniqueId.gen();
    private boolean dGz = false;
    private MemberGroupInfo dHR;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHQ;
    }

    public MemberGroupInfo aAj() {
        return this.dHR;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dHR = memberGroupInfo;
    }

    public void gm(boolean z) {
        this.dGz = z;
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
