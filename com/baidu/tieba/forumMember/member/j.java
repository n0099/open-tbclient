package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jbG = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean jap = false;
    private MemberGroupInfo jbH;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jbG;
    }

    public MemberGroupInfo cDt() {
        return this.jbH;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.jbH = memberGroupInfo;
    }

    public void qf(boolean z) {
        this.jap = z;
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
