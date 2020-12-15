package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes23.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPu = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean iOe = false;
    private MemberGroupInfo iPv;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPu;
    }

    public MemberGroupInfo cAA() {
        return this.iPv;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.iPv = memberGroupInfo;
    }

    public void pI(boolean z) {
        this.iOe = z;
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
