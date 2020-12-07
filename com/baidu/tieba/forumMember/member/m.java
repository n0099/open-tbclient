package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes23.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPs = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iOc = false;
    private MemberGroupInfo iPt;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPs;
    }

    public MemberGroupInfo cAz() {
        return this.iPt;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.iPt = memberGroupInfo;
    }

    public void pI(boolean z) {
        this.iOc = z;
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
