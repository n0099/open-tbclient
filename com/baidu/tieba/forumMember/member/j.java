package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jcG = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean jbp = false;
    private MemberGroupInfo jcH;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jcG;
    }

    public MemberGroupInfo cAN() {
        return this.jcH;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.jcH = memberGroupInfo;
    }

    public void ql(boolean z) {
        this.jbp = z;
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
