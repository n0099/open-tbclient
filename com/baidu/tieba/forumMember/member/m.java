package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes17.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPs = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean hOb = false;
    private MemberGroupInfo hPt;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPs;
    }

    public MemberGroupInfo cko() {
        return this.hPt;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hPt = memberGroupInfo;
    }

    public void nW(boolean z) {
        this.hOb = z;
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
