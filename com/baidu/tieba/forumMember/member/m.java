package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes23.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId ixP = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iwy = false;
    private MemberGroupInfo ixQ;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ixP;
    }

    public MemberGroupInfo cug() {
        return this.ixQ;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.ixQ = memberGroupInfo;
    }

    public void oZ(boolean z) {
        this.iwy = z;
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
