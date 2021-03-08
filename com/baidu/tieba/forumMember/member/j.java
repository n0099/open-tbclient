package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes7.dex */
public class j implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jeD = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean jdm = false;
    private MemberGroupInfo jeE;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jeD;
    }

    public MemberGroupInfo cBa() {
        return this.jeE;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.jeE = memberGroupInfo;
    }

    public void ql(boolean z) {
        this.jdm = z;
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
