package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes23.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId ilr = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean ika = false;
    private MemberGroupInfo ils;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ilr;
    }

    public MemberGroupInfo cqZ() {
        return this.ils;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.ils = memberGroupInfo;
    }

    public void oH(boolean z) {
        this.ika = z;
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
