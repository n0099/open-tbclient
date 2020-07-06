package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hwl = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo hwm;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hwl;
    }

    public MemberGroupInfo bWy() {
        return this.hwm;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hwm = memberGroupInfo;
    }

    public void mL(boolean z) {
        this.isLast = z;
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
