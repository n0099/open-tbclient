package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes10.dex */
public class m implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gla = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private MemberGroupInfo glb;
    private boolean isLast = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gla;
    }

    public MemberGroupInfo bCy() {
        return this.glb;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.glb = memberGroupInfo;
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
