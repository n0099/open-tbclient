package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes22.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iEA = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iDk = false;
    private MemberGroupInfo iEB;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEA;
    }

    public MemberGroupInfo cwk() {
        return this.iEB;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.iEB = memberGroupInfo;
    }

    public void pl(boolean z) {
        this.iDk = z;
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
