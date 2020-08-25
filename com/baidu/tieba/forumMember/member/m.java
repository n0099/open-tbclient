package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes17.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPm = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean hNV = false;
    private MemberGroupInfo hPn;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPm;
    }

    public MemberGroupInfo ckn() {
        return this.hPn;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hPn = memberGroupInfo;
    }

    public void nU(boolean z) {
        this.hNV = z;
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
