package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIz = BdUniqueId.gen();
    private boolean dHi = false;
    private MemberGroupInfo dIA;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIz;
    }

    public MemberGroupInfo aAG() {
        return this.dIA;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dIA = memberGroupInfo;
    }

    public void gp(boolean z) {
        this.dHi = z;
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
