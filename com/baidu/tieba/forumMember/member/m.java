package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes23.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iDM = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iCv = false;
    private MemberGroupInfo iDN;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iDM;
    }

    public MemberGroupInfo cwH() {
        return this.iDN;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.iDN = memberGroupInfo;
    }

    public void pi(boolean z) {
        this.iCv = z;
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
