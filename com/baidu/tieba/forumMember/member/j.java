package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes7.dex */
public class j implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iWZ = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iVI = false;
    private MemberGroupInfo iXa;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iWZ;
    }

    public MemberGroupInfo czC() {
        return this.iXa;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.iXa = memberGroupInfo;
    }

    public void qb(boolean z) {
        this.iVI = z;
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
