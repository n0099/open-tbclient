package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gkY = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo gkZ;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gkY;
    }

    public MemberGroupInfo bCw() {
        return this.gkZ;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.gkZ = memberGroupInfo;
    }

    public void kV(boolean z) {
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
