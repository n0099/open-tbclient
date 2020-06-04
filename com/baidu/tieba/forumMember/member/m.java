package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hke = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo hkf;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hke;
    }

    public MemberGroupInfo bTB() {
        return this.hkf;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hkf = memberGroupInfo;
    }

    public void mA(boolean z) {
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
