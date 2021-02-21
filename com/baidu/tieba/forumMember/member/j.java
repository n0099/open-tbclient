package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jcU = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean jbD = false;
    private MemberGroupInfo jcV;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jcU;
    }

    public MemberGroupInfo cAU() {
        return this.jcV;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.jcV = memberGroupInfo;
    }

    public void ql(boolean z) {
        this.jbD = z;
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
